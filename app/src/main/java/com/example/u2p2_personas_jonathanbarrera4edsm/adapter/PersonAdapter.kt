package com.example.u2p2_personas_jonathanbarrera4edsm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.u2p2_personas_jonathanbarrera4edsm.databinding.LayoutPersonasBinding
import com.example.u2p2_personas_jonathanbarrera4edsm.model.Person

class PersonAdapter(var lista: List<Person>):RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    var onItemClick: ((Person) -> Unit)?=null
    class ViewHolder(val binding:LayoutPersonasBinding):RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutPersonasBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person=lista[position]
        with(holder.binding){
            txtNombre.text=person.nombre
            txtApellidos.text=person.apellidos
            txtFechaNacimiento.text=person.fechaNacimiento.toString()
            txtEstado.text=person.estadoNacimiento

            holder.itemView.setOnClickListener{
                onItemClick?.invoke(person)
            }
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}