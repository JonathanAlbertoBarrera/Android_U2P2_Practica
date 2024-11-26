package com.example.u2p2_personas_jonathanbarrera4edsm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityDetallePersonaBinding
import org.json.JSONObject

class DetallePersona : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePersonaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos pasados desde la actividad anterior
        val id = intent.getIntExtra("id",1)
        val nombre = intent.getStringExtra("nombre") ?: ""
        val apellidos = intent.getStringExtra("apellidos") ?: ""
        val fechaNacimiento = intent.getStringExtra("fechaNacimiento") ?: ""
        val estadoNacimiento = intent.getStringExtra("estadoNacimiento") ?: ""

        // Cargar datos en los EditText
        binding.edtNombre.setText(nombre)
        binding.edtApellidos.setText(apellidos)
        binding.edtFechaNacimiento.setText(fechaNacimiento)
        binding.edtEstadoNacimiento.setText(estadoNacimiento)

        val queue = Volley.newRequestQueue(this)
        // Botón para modificar cambios
        binding.btnModificar.setOnClickListener {


            val url = "http://192.168.1.87:8080/api/personas/${id}"
            val metodo=Request.Method.PUT
            val body=JSONObject()
            body.put("nombre", binding.edtNombre.text.toString())
            body.put("apellidos", binding.edtApellidos.text.toString())
            body.put("fechaNacimiento", binding.edtFechaNacimiento.text.toString())
            body.put("estadoNacimiento", binding.edtEstadoNacimiento.text.toString())

            val listener=Response.Listener<JSONObject> { resultado ->
                val mensaje=resultado.getString("message")
                if(mensaje.equals("Persona actualizada exitosamente")){
                    Toast.makeText(this,"Persona ACTUALIZADA",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Error al ACTUALIZAR persona",Toast.LENGTH_SHORT).show()
                }
            }

            val errorListener = Response.ErrorListener { error -> }

            val request=JsonObjectRequest(metodo,url,body,listener,errorListener)
            queue.add(request)
        }


        // Botón para eliminar
        binding.btnEliminar.setOnClickListener {
            val url = "http://192.168.1.87:8080/api/personas/${id}" // Ajusta según tu API
            val metodo=Request.Method.DELETE
            val body=null

            val listener=Response.Listener<JSONObject> { resultado ->
                val mensaje=resultado.getString("message")
                if(mensaje.equals("Persona eliminada exitosamente")){
                    Toast.makeText(this,"Persona ELIMINADA",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Error al ELIMINAR persona",Toast.LENGTH_SHORT).show()
                }
            }

            val errorListener = Response.ErrorListener { error -> }

            val request=JsonObjectRequest(metodo,url,body,listener,errorListener)
            queue.add(request)
        }


    }
}
