package com.example.islami.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuraNamesAdapter (val items:List<String>): RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>(){
    var onItemClickListener : OnItemClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
       return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraNameTextView.text=items.get(position)
        holder.suraNameTextView.setOnClickListener{
            onItemClickListener?.onItemClickListener(items.get(position),position)
        }

    }

    interface OnItemClickListener{
        fun onItemClickListener(item:String,index:Int)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val suraNameTextView=itemView.findViewById<TextView>(R.id.item_sura_name_title)

    }
}