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


class MyPersonsRecyclerAdapter (private val onClick: (productId : String) -> Unit): RecyclerView.Adapter<MyPersonViewHolder>() {
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
        placeProducts(holder, position)
    }


    override fun getItemCount(): Int = persons.size

    private fun placeProducts(holder: MyPersonViewHolder, position: Int) {
        Log.i("test", "placeProducts")


        val person = persons[position]
        holder.name.text = person.name
        holder.id.text = person._id
        //@TODO
//        Glide.with(holder.image.context)
//            .load(person.image)
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .into(holder.image)
//

    }

}
class SpacesItemDecoration(private val space: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        if (parent.getChildLayoutPosition(view) % 2 == 1 )
            outRect.left = 0
        else
            outRect.left = space




        outRect.right = space
        outRect.bottom = space



        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1) {
            outRect.top = space
        } else {
            outRect.top = 0
        }
    }
}

