package com.example.myquatsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class Quotes_Adapter (val context: Context,val quotesList: ArrayList<model_class>) :
RecyclerView.Adapter<Quotes_Adapter.Quotes_holder>(){

    class Quotes_holder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val quotesTxt : TextView = itemView.findViewById(R.id.Quotestxt)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Quotes_Adapter.Quotes_holder {
        val view = LayoutInflater.from(context).inflate(R.layout.quates_tile,parent,false)
        return Quotes_holder(view)

    }


    override fun onBindViewHolder(holder: Quotes_Adapter.Quotes_holder, position: Int) {
       holder.quotesTxt.text =quotesList[position].quotes
//        holder.img_save.setImageResource(R.drawable.save)
//        holder.img_heart.setImageResource(R.drawable.heart)

    }

    override fun getItemCount(): Int {
        return quotesList.size
    }
}