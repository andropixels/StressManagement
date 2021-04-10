package com.rahul.stressmanagement.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.rahul.stressmanagement.R

class SignIn : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var  btn_signin:Button
    lateinit var chkbox:CheckBox
    lateinit var txt_createaccount:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_in)
        email=findViewById(R.id.usermail2)
        password=findViewById(R.id.userpassword2)
       txt_createaccount=findViewById(R.id.txt_createaccount)
        btn_signin=findViewById(R.id.signup_btn2)
        txt_createaccount.setOnClickListener {

//            startActivity(Intent(this,MainActivity::class.java))
        }
        btn_signin.setOnClickListener {
            val progressdialog= ProgressDialog(this@SignIn)
            progressdialog.setTitle("sigining up...")
            progressdialog.setMessage("this may take while")
            progressdialog.setCanceledOnTouchOutside(false)
            progressdialog.show()
            val email=email.text.toString()
            val password=password.text.toString()
            val mauth= FirebaseAuth.getInstance()
            mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener {task ->
                if (task.isSuccessful){
                    progressdialog.dismiss()
                    if(chkbox.isChecked){
                        val intent= Intent(this,Dashboard::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"please ceck box", Toast.LENGTH_LONG).show()

                    }


                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)

                    finish()
                }else{
                    val toaast=task.exception
                    Toast.makeText(this,"$toaast", Toast.LENGTH_LONG).show()

                }

            }
        }






    }
}