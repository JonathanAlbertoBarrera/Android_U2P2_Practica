package com.example.u2p2_personas_jonathanbarrera4edsm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

            if(nombre.isNotEmpty() && apellido.isNotEmpty()&& fechaNacimiento.isNotEmpty() && estadoNacimiento.isNotEmpty()){
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
                    //Si se hizo el registro
                    if(mensaje.equals("Persona registrada exitosamente")){
                        val builder=AlertDialog.Builder(this)
                        builder.setTitle("Resultado")
                        builder.setMessage("La persona se ha registrado correctamente")
                        builder.setPositiveButton("OK"){dialog, _ ->
                            binding.edtNombre.setText("")
                            binding.edtApellido.setText("")
                            binding.edtFechaNacimiento.setText("")
                            binding.edtEstadoNacimiento.setText("")
                            dialog.cancel()
                        }
                        builder.show()

                    }else{ //No se hizo
                        val builder=AlertDialog.Builder(this)
                        builder.setTitle("Resultado")
                        builder.setMessage("NO SE REGISTRO A LA PERSONA")
                        builder.setPositiveButton("OK :("){dialog, _ ->
                            binding.edtNombre.setText("")
                            binding.edtApellido.setText("")
                            binding.edtFechaNacimiento.setText("")
                            binding.edtEstadoNacimiento.setText("")
                            dialog.cancel()
                        }
                        builder.show()
                    }
                }

                val errorListener = Response.ErrorListener { error -> }

                val request=JsonObjectRequest(metodo,url,body,listener,errorListener)
                queue.add(request)
            }else{ //Hay un campo vacio
                val builder=AlertDialog.Builder(this)
                builder.setTitle("Nota")
                builder.setMessage("Tienes que llenar todos los campos")
                builder.setPositiveButton("OK"){dialog, _ ->
                    dialog.cancel()
                }
                builder.show()
            }



        }

        binding.btnRegresar.setOnClickListener {
            val intent=Intent(this@RegistrarPersonasActivity,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}