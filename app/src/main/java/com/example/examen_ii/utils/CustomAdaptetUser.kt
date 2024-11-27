package com.example.examen_ii.utils


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_ii.R
import com.example.examen_ii.data.ApiUser

class CustomAdaptetUser(val users: List<ApiUser>):
    RecyclerView.Adapter<CustomAdaptetUser.ViewHolder>() {

    // Despues inicializamos la variable
    private lateinit var miListener: onItemClickListener

    // Para detectar el click y longClick
    interface onItemClickListener {
        // Despues define el metodo
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }

    // Para que exterior se comunique con el interior
    // Este mediti si existe en el ListView - No Recycler
    fun onSetClickListener(listener: onItemClickListener){
        miListener = listener
    }

    // Internamente requerimos una clase
    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        // Referencia a los elementos de mi diseño
        val idUsuario = itemView.findViewById<TextView>(R.id.tvCommentId)
        val username = itemView.findViewById<TextView>(R.id.tvCommentName)
        val NombreUsuario = itemView.findViewById<TextView>(R.id.tvCommentEmail)
        val emailUser = itemView.findViewById<TextView>(R.id.tvUserEmail)
        val direccion = itemView.findViewById<TextView>(R.id.tvAddress)
        val compania = itemView.findViewById<TextView>(R.id.tvCompany)


        // Para confirmar que se crearon las vistas
        // Pero antes de terminar el constructor
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
            itemView.setOnLongClickListener {
                listener.onItemLongClick(adapterPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Crear la vista inflate
        val vista: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(vista,miListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val address = "${users[position].address.suite}, ${users[position].address.street}, ${users[position].address.zipcode}, ${users[position].address.city}, Geo-localización:(${users[position].address.geo.lat}, ${users[position].address.geo.lng})"
        val company = "${users[position].company.name}, ${users[position].company.catchPhrase}, ${users[position].company.bs}"
        // Bind - Unir - los datos con la vista
        holder.idUsuario.text = users[position].id.toString()
        holder.username.text = users[position].username
        holder.NombreUsuario.text = users[position].name
        holder.emailUser.text = users[position].email
        holder.direccion.text = address
        holder.compania.text = company
    }

    }