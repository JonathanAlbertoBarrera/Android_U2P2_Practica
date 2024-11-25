package com.example.u2p2_personas_jonathanbarrera4edsm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val intent= Intent(this@MainActivity,RegistrarPersonasActivity::class.java)
            startActivity(intent)
        }

        binding.btnMostrar.setOnClickListener {
            val intent=Intent(this@MainActivity,MostrarPersonasActivity::class.java)
            startActivity(intent)
        }

        binding.btnSalir.setOnClickListener {
            finish()
        }

    }
}