package com.example.u2p2_personas_jonathanbarrera4edsm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityMostrarPersonasBinding

class MostrarPersonasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrarUsuario.setOnClickListener {

        }

        binding.btnRegresar.setOnClickListener {
            val intent=Intent(this@MostrarPersonasActivity,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}