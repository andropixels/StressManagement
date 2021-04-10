package com.rahul.stressmanagement.Activities

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.rahul.stressmanagement.R
import com.rahul.stressmanagement.tabactivities.Favourite
import com.rahul.stressmanagement.tabactivities.List
import com.rahul.stressmanagement.tabactivities.chatbot

class Dashboard : AppCompatActivity() {
    lateinit var myfavimage:ImageView
    lateinit var mydiet:ImageView
    lateinit var focous:ImageView
lateinit var todoimge:ImageView
lateinit var chatbotimg:ImageView
lateinit var Home:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ThemeStressManagement)

        setContentView(R.layout.activity_dashboard)
        myfavimage=findViewById(R.id.img_myfav)
        mydiet=findViewById(R.id.img_mydiet)
        focous=findViewById(R.id.img_focous)
        todoimge=findViewById(R.id.imag_todo)
        chatbotimg=findViewById(R.id.img_chatbot)
        Home=findViewById(R.id.img_homme)


        chatbotimg.setOnClickListener {
            startActivity(Intent(this,chatbot::class.java))
        }
        myfavimage.setOnClickListener {
            startActivity(Intent(this,Favourite::class.java))
        }
        mydiet.setOnClickListener {
            startActivity(Intent(this,com.rahul.stressmanagement.tabactivities.focous::class.java))
        }
        focous.setOnClickListener {
            startActivity(Intent(this,com.rahul.stressmanagement.tabactivities.Home::class.java))
        }
        todoimge.setOnClickListener {
            startActivity(Intent(this,List::class.java))
        }
        Home.setOnClickListener {
            startActivity(Intent(this,com.rahul.stressmanagement.tabactivities.Home::class.java))
        }



    }
}