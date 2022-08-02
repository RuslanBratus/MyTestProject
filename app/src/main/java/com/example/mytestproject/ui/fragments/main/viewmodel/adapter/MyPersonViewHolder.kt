package com.example.mytestproject.ui.fragments.main.viewmodel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestproject.R

class MyPersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name : TextView = itemView.findViewById(R.id.person_name)
    val image : ImageView = itemView.findViewById(R.id.person_image)
    val id : TextView = itemView.findViewById(R.id.person_id)
    val description : TextView = itemView.findViewById(R.id.description)
    val birth : TextView = itemView.findViewById(R.id.birth)
    val death : TextView = itemView.findViewById(R.id.death)


}

