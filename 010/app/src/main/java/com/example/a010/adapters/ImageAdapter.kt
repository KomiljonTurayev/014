package com.example.a010.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.a010.R
import com.example.a010.models.ImageModel

class ImageAdapter(var data: ArrayList<ImageModel>, var context: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(imageView: ImageModel) {

            var holderName: TextView = itemView.findViewById(R.id.text_view) as TextView
            var holderImage: ImageView = itemView.findViewById(R.id.image_view) as ImageView

            holderName.text = imageView.name
            imageView.imageName?.let { holderImage.setImageResource(it) }

            itemView.setOnClickListener {
                Toast.makeText(context, "${holderName.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_list, null, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
}
