package com.example.u2p2_personas_jonathanbarrera4edsm

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.u2p2_personas_jonathanbarrera4edsm.adapter.PersonAdapter
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityMostrarPersonasBinding
import com.example.u2p2_personas_jonathanbarrera4edsm.model.Person
import org.json.JSONObject

class MostrarPersonasActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMostrarPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val lista= listOf(
            Person("Jonathan","Barrera Calderon","2004-02-07","MorelosYork"),
            Person("Alan","Dragon Blo","2005-06-08","CaleraYork")
        )*/
        //------------PARA PETICION
        val queue = Volley.newRequestQueue(this)

        val url = "http://192.168.1.87:8080/api/personas"
        val metodo = Request.Method.GET
        val body = null
        val listener = Response.Listener<JSONObject> { resultado ->
            val lista = mutableListOf<Person>()
            val arreglo = resultado.getJSONArray("data")
            for(i in 0 until arreglo.length()){
                lista.add(
                    Person(nombre =arreglo.getJSONObject(i).getString("nombre"),
                        apellidos = arreglo.getJSONObject(i).getString("apellidos"),
                        fechaNacimiento = arreglo.getJSONObject(i).getString("fechaNacimiento"),
                        estadoNacimiento = arreglo.getJSONObject(i).getString("estadoNacimiento") )
                )
            }

            //--PARA RECYCLER VIEW
            val adaptador=PersonAdapter(lista)
            adaptador.onItemClick={ persona ->
                val intent= Intent(this@MostrarPersonasActivity,DetallePersona::class.java);
                intent.putExtra("nombre",persona.nombre)
                intent.putExtra("apellidos",persona.apellidos)
                intent.putExtra("fechaNacimiento",persona.fechaNacimiento)
                intent.putExtra("estadoNacimiento",persona.estadoNacimiento)
                startActivity(intent)
            }

            binding.rvPersonas.adapter=adaptador
            binding.rvPersonas.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        }

        val errorListener = Response.ErrorListener { error ->

        }

        val request = JsonObjectRequest(metodo, url, body, listener, errorListener)
        queue.add(request)


    }
}