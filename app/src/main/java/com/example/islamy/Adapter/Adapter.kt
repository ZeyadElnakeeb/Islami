package com.example.islamy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.R


class Adapter(var suraNames: List<String>):RecyclerView.Adapter<com.example.islamy.Adapter.Adapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name_rv,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int =suraNames.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
var items=suraNames[position]

holder.suraName.text=items

        holder.itemView.setOnClickListener{

                onItemClick.onClick(position,items)

        }

    }
    lateinit var onItemClick:SetOnItemClickListener

    interface SetOnItemClickListener{

        fun onClick(position: Int,item:String)
    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var suraName:TextView=itemView.findViewById(R.id.item_name)

    }
}