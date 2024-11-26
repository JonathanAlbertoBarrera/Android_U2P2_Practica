package com.example.u2p2_personas_jonathanbarrera4edsm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.u2p2_personas_jonathanbarrera4edsm.adapter.PersonAdapter
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityMostrarPersonasBinding
import com.example.u2p2_personas_jonathanbarrera4edsm.model.Person

class MostrarPersonasActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMostrarPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista= listOf(
            Person("Jonathan","Barrera Calderon","2004-02-07","MorelosYork"),
            Person("Alan","Dragon Blo","2005-06-08","CaleraYork")
        )

        val adaptador=PersonAdapter(lista)
        adaptador.onItemClick={persona ->
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
}