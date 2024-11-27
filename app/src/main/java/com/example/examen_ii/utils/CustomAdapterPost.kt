package com.example.examen_ii.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_ii.R
import com.example.examen_ii.data.ApiPost


class CustomAdaptetPost(val posts: List<ApiPost>):
    RecyclerView.Adapter<CustomAdaptetPost.ViewHolder>() {

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
        val idPost = itemView.findViewById<TextView>(R.id.tvCommentId)
        val bodyPost = itemView.findViewById<TextView>(R.id.tvCommentName)
        val titlePost = itemView.findViewById<TextView>(R.id.tvCommentEmail)

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
            LayoutInflater.from(parent.context).inflate(R.layout.posts_list,parent,false)
        return ViewHolder(vista,miListener)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idPost.text = posts[position].id.toString()
        holder.bodyPost.text = posts[position].body
        holder.titlePost.text = posts[position].title
    }

}