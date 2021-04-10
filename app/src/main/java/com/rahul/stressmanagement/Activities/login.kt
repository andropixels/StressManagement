package com.rahul.stressmanagement.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.rahul.stressmanagement.MainActivity
import com.rahul.stressmanagement.R

class login : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var  btn_signin: Button
    lateinit var chkbox: CheckBox
    lateinit var txt_createaccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ThemeStressManagement)

        setContentView(R.layout.activity_login)
        email=findViewById(R.id.usermail2)
        password=findViewById(R.id.userpassword2)
        txt_createaccount=findViewById(R.id.txt_createaccount)
        btn_signin=findViewById(R.id.signup_btn2)
        txt_createaccount.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}