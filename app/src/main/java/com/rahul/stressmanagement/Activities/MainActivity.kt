package com.rahul.stressmanagement

import android.app.ProgressDialog
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.rahul.stressmanagement.Activities.Dashboard
import com.rahul.stressmanagement.Activities.login

class MainActivity : AppCompatActivity() {
    lateinit var username:EditText
    lateinit var usermail:EditText
    lateinit var password:EditText
    lateinit var alredyaccount:TextView
    lateinit var checkbox:CheckBox
    lateinit var sign_btnL:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ThemeStressManagement)

        setContentView(R.layout.activity_main)
        username=findViewById(R.id.username)
        usermail=findViewById(R.id.usermail)
        password=findViewById(R.id.userpassword)
        alredyaccount=findViewById(R.id.txt_alreadyaccount)
        checkbox=findViewById(R.id.checkBox)
        sign_btnL=findViewById(R.id.signup_btn)
        var email=usermail.text.toString()
        var pass=password.text.toString()

        sign_btnL.setOnClickListener {
            if (checkbox.isChecked && usermail.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                signup(username.text.toString(),usermail.text.toString(),  password.text.toString())

            } else {
                Toast.makeText(this, "agree to privacy policy", Toast.LENGTH_LONG).show()
            }
        }

        alredyaccount.setOnClickListener {

       startActivity(Intent(this,login::class.java))
        }
    }



    private fun signup(username: String, useremail: String, password: String) {

        val firebaseauth = FirebaseAuth.getInstance()
        firebaseauth.createUserWithEmailAndPassword(useremail, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val progressdialog = ProgressDialog(this@MainActivity)
                    progressdialog.setTitle("sigining up...")
                    progressdialog.setMessage("this may take while")
                    progressdialog.setCanceledOnTouchOutside(false)
                    progressdialog.show()
                    //if user with entered email and password get athunticated we will get to n]know through the task (add on complete listener)
                    //now if the user is authnticated we wil post data on realtime database

                    storedata(username, useremail, password, progressdialog)
                } else {
                   var e=task.exception
                    Toast.makeText(this, "$e", Toast.LENGTH_LONG).show()

                }
            }

    }

    private fun storedata(
        username: String,
        useremail: String,
        password: String,
        progressdialog: ProgressDialog
    ) {
        val usermap = HashMap<String, String>()
        usermap["username"] = username
        usermap["useremail"] = useremail
        usermap["password"] = password
        val currentuser = FirebaseAuth.getInstance().currentUser!!.uid

        val dataref = FirebaseDatabase.getInstance().getReference().child("users")

        dataref.child(currentuser).setValue(usermap).addOnCompleteListener {


            if (it.isSuccessful) {



              val intent= Intent(this, Dashboard::class.java)
                startActivity(intent)

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)

                finish()



                progressdialog.dismiss()


            }

        }


    }
}

