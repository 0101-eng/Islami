package com.example.islami.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.home.ahadeth.AhadethFragment
import com.example.islami.home.quran.QuranFragment
import com.example.islami.home.radio.RadioFragment
import com.example.islami.home.sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.home_bottom_navigation_view)
        showFragment(QuranFragment())
        bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.ic_quran) {
              showFragment(QuranFragment())
            } else if (item.itemId == R.id.ic_hadeth) {
                showFragment(AhadethFragment())
            } else if (item.itemId == R.id.ic_sebha) {
                showFragment(SebhaFragment())
            } else{
                showFragment(RadioFragment())
        }
        return@setOnItemSelectedListener true
        }
    }
    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }
}