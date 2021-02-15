package com.senne.guests.view.viewHolder

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.senne.guests.R
import com.senne.guests.service.model.GuestModel
import com.senne.guests.view.listener.GuestListener

class GuestViewHolder(itemView: View, private val listener: GuestListener) : RecyclerView.ViewHolder(itemView){

    fun bind(guest: GuestModel) {
       val textName =  itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        textName.setOnClickListener{
            listener.onClick(guest.id)
        }
    }
}