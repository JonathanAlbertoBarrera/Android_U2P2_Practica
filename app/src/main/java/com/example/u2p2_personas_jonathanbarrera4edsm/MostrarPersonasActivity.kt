package com.example.u2p2_personas_jonathanbarrera4edsm

import android.app.VoiceInteractor
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityMostrarPersonasBinding
import org.json.JSONObject

class MostrarPersonasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val queue = Volley.newRequestQueue(this)
//        binding.btnRegistrarUsuario.setOnClickListener {
//            val url = "http://192.168.107.85:8080/v1/categorias"
//            val metodo = VoiceInteractor.Request.Method.POST
//            val body  = JSONObject()
//            body.put(
//                "nombre",
//                binding.edtNombre.text.toString()
//            )
//            body.put(
//                "descripcion",
//                binding.edtCategoria.text.toString()
//            )
//            val listener = Response.Listener<JSONObject> { resulttado ->
//                val codigo = resulttado.getJSONArray("metadata")
//                    .getJSONObject(0)
//                    .getString("codigo")
//                if(codigo == "00"){
//                    Toast.makeText(this, "Inserción exitosa", Toast.LENGTH_SHORT).show()
//                }else{
//                    Toast.makeText(this, "Algo pasó mal", Toast.LENGTH_SHORT).show()
//                }
//            }
//            val errorListener = Response.ErrorListener { error -> }
//            val request = JsonObjectRequest(metodo, url, body, listener, errorListener)
//            queue.add(request)
//        }
        binding.btnRegistrarUsuario.setOnClickListener {

        }

        binding.btnRegresar.setOnClickListener {
            val intent=Intent(this@MostrarPersonasActivity,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}