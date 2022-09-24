package com.example.islami.home.ahadeth

import android.content.Intent
import android.os.Bundle
import android.system.Os.open
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.home.hadeth_details.AhadethDetailsActivity
import com.example.islami.home.quran.SuraNamesAdapter
import com.example.islami.sura_details.SuraDetailsActivity

class AhadethFragment :Fragment() {
    lateinit var hadethNamesRecyclerView: RecyclerView
    lateinit var hadethNamesAdapter: AhadethAdapter
    var list:ArrayList<HadethModel> =CreateAhadethList()

    private fun CreateAhadethList(): ArrayList<HadethModel> {
     val list=java.util.ArrayList<HadethModel>()
        for(i in 1 .. 40){
            val s=" الحديث رقم $i   "
            list.add(HadethModel(s))
        }
        return list
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hadethNamesRecyclerView=view.findViewById(R.id.hadeth_name_recycler_view)
        hadethNamesAdapter= AhadethAdapter(list)
        hadethNamesAdapter.onItemClickListener=object :AhadethAdapter.OnItemClickListener{
            override fun onItemClickListener(position:Int) {
              val content:String =readHadethContentFromFile(position)
                val intent: Intent = Intent(requireContext(), AhadethDetailsActivity::class.java)
                intent.putExtra("hadeeth_num",position.toString())
                intent.putExtra("content",content)
                startActivity(intent)
            }

        }
        hadethNamesRecyclerView.adapter=hadethNamesAdapter
    }

    private fun readHadethContentFromFile(position: Int): String {
          val fileName="h${position+1}.txt"
        val fileContent=resources.assets.open(fileName).bufferedReader().use{(it.readText())}
        return  fileContent


    }
}



