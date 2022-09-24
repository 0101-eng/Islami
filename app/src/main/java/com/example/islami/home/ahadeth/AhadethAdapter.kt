package com.example.islami.home.ahadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.home.quran.SuraNamesAdapter

class AhadethAdapter (var list:ArrayList<HadethModel>): RecyclerView.Adapter<AhadethViewHolder>() {
    var onItemClickListener : OnItemClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_name,parent,false)
        return AhadethViewHolder(view)
    }

    override fun onBindViewHolder(holder: AhadethViewHolder, position: Int) {
        var model=this.list.get(position)
        holder.hadeth_tv.text=model.hadethnum
        holder.hadeth_tv.setOnClickListener{
            onItemClickListener?.onItemClickListener(position)
        }
    }
    interface OnItemClickListener{
        fun onItemClickListener(position: Int)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
class AhadethViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
    lateinit  var hadeth_tv :TextView
    init {
        hadeth_tv =itemView.findViewById<TextView>(R.id.item_hadeth_name_title)
    }

}