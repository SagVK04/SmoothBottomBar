package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottom = findViewById<BottomNavigationView>(R.id.bottombar)
        bottom.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.item0->{
                    replaceFragment(Dashboard())
                    true
                }
                R.id.item1->{
                    replaceFragment(Leaderboard())
                    true
                }
                R.id.item2->{
                    replaceFragment(Store())
                    true
                }
                R.id.item3->{
                    replaceFragment(Profile())
                    true
                }
                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment){
        var manager = supportFragmentManager //supportFragmentManager
        var tr = manager.beginTransaction() //beginTransaction          //By default BlankFragment will be shown
        tr.replace(R.id.frameLayout1,Fragment()) //replace
        tr.addToBackStack(null) //add to back stack for back button
        tr.commit()
    }
}