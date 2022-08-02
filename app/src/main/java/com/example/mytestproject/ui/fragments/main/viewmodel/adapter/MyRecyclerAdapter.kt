package com.example.mytestproject.ui.fragments.main.viewmodel.adapter

import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.mytestproject.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Person


class MyPersonsRecyclerAdapter (): RecyclerView.Adapter<MyPersonViewHolder>() {
     var persons : List<Person> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person, parent, false)
        return MyPersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyPersonViewHolder, position: Int) {
        Log.i("test", "onBindViewHolder")
        placePersons(holder, position)
    }


    override fun getItemCount(): Int = persons.size

    private fun placePersons(holder: MyPersonViewHolder, position: Int) {
        Log.i("test", "placeProducts")


        val person = persons[position]
        holder.name.text = person.name
        holder.id.text = person._id
        holder.birth.text = person.birth.toString()


        if (person.death != null) {
            holder.death.text = person.death.toString()
        }


        Glide.with(holder.image.context)
            .load(person.picture)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.image)


    }

}
