package com.example.u2p2_personas_jonathanbarrera4edsm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.ActivityMostrarPersonasBinding

class MostrarPersonasActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMostrarPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}