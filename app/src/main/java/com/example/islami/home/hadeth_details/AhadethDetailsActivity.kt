package com.example.islami.home.hadeth_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.islami.R

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var hadethContent:TextView
   // lateinit var hadethNum:TextView
   // lateinit var hadeth:TextView
    //var num:String=""
    var content:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahadeth_details)
        hadethContent=findViewById(R.id.hadeeth_content)
      //  hadethNum=findViewById(R.id.hadeth_num)
       // hadeth=findViewById(R.id.had_details)
        getDataFromIntent()
        hadethContent.text=content
       // hadethNum.text="الحديث رقم "+ num
       // hadeth.text="الحديث رقم "+ num


    }

    private fun getDataFromIntent() {
        content=intent.getStringExtra("content").toString()


    }
}