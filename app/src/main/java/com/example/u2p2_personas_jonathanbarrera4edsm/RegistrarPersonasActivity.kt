package com.example.u2p2_personas_jonathanbarrera4edsm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityRegistarPersonasBinding
import org.json.JSONObject

class RegistrarPersonasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistarPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistarPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val queue = Volley.newRequestQueue(this)
        binding.btnRegistrarUsuario.setOnClickListener {
            //variables para los datos de los edt
            val nombre=binding.edtNombre.text.toString()
            val apellido = binding.edtApellido.text.toString()
            val fechaNacimiento = binding.edtFechaNacimiento.text.toString()
            val estadoNacimiento = binding.edtEstadoNacimiento.text.toString()


            //PARA PETICION

            val url = "http://192.168.1.87:8080/api/personas"
            val metodo = Request.Method.POST

            val body=JSONObject()
            body.put("nombre",nombre)
            body.put("apellidos",apellido)
            body.put("fechaNacimiento",fechaNacimiento)
            body.put("estadoNacimiento",estadoNacimiento)

            val listener= Response.Listener<JSONObject> { resultado ->
                val mensaje=resultado.getString("message")
                if(mensaje.equals("Persona registrada exitosamente")){
                    Toast.makeText(this,"Persona registrada",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Error al registrar persona",Toast.LENGTH_SHORT).show()
                }
            }

            val errorListener = Response.ErrorListener { error ->
                Toast.makeText(this, "Error: ${error.networkResponse?.statusCode}", Toast.LENGTH_SHORT).show()
                val errorMessage = String(error.networkResponse?.data ?: ByteArray(0))
                binding.mensajes.text = errorMessage
            }

            val request=JsonObjectRequest(metodo,url,body,listener,errorListener)
            queue.add(request)
        }

        binding.btnRegresar.setOnClickListener {
            val intent=Intent(this@RegistrarPersonasActivity,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}