package com.example.islami.home.sebha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.example.islami.R
import java.util.Collections.rotate


class SebhaFragment :Fragment() {
lateinit var imageView: ImageView
lateinit var counter:Button
lateinit var zekr:Button
var generalCounter=0
var count=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        counter = view.findViewById<Button>(R.id.counter)
        zekr = view.findViewById<Button>(R.id.zekr)
        imageView = view.findViewById(R.id.sebha_logo_iv)
        zekr.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate)
            imageView.startAnimation(animation)
            count++
            generalCounter++
            if (generalCounter == 3) {
                imageView.startAnimation(animation)
                count = 0
                zekr.setText("لا حول ولا قوة الا بالله")
            } else if (generalCounter == 6) {
                imageView.startAnimation(animation)
                count=0
                zekr.setText("لا اله الا الله ")

            } else if (generalCounter == 9) {
                imageView.startAnimation(animation)
                count = 0
                zekr.setText("الله اكبر")
                generalCounter=0
            }
                counter.setText(count.toString())
            }
        }
    }



