package com.rahul.stressmanagement.tabactivities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.rahul.stressmanagement.R
import com.rahul.stressmanagement.utils.botresponces
import com.rahul.stressmanagement.utils.constants.CALL
import com.rahul.stressmanagement.utils.constants.OPEN_SEARCH
import com.rahul.stressmanagement.utils.constants.PLAY
import java.util.*

class chatbot : AppCompatActivity() {
    lateinit var mTTS:TextToSpeech
    lateinit var OPEN:String
    val RQ_SPEECH_REC=102
    lateinit var btnmespeak: Button
    lateinit var mespeaking:TextView
    lateinit var botspeaking:TextView
    lateinit var sekbar:SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ThemeStressManagement)

        setContentView(R.layout.activity_chatbot)
        btnmespeak=findViewById(R.id.btnmespeak)
        mespeaking=findViewById(R.id.mespeaking)
        botspeaking=findViewById(R.id.botspeaking)
        sekbar=findViewById(R.id.spedseekbar)
        btnmespeak.setOnClickListener {
            val i= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT,"speak something")
            startActivityForResult(i,RQ_SPEECH_REC)

        }

        mTTS= TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->

            if (status!= TextToSpeech.ERROR){

                mTTS.language= Locale.US
            }
        })
        sendmessege()

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==RQ_SPEECH_REC && resultCode== Activity.RESULT_OK){

            val result=data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            mespeaking.text=result?.get(0).toString()


            sendmessege()
        }

    }

    private fun sendmessege(){

        val messege=  mespeaking.text.toString()
        val responce= botresponces.responces(messege)

        when(responce){

            OPEN_SEARCH->{

                val term:String?=messege.substringAfter("search")
                val site= Intent(Intent.ACTION_VIEW)
                site.data= Uri.parse("https://www.google.com/search?q=$term")
                startActivity(site)

            }

            CALL->{

                val term:String?=messege.substringAfter("call")
                val dial="tel:"+term

                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial.toString() )))
            }
            PLAY->{

                val term:String?=messege.substringAfter("play")
                val site= Intent(Intent.ACTION_VIEW)
                site.data= Uri.parse("https://www.youtube.com/results?search_query=$term")
                startActivity(site)}
        }

        botspeaking.setText(responce)
        botspeak()




    }
    fun botspeak(){


        val botresponceextracted=botspeaking.text.toString()


        mTTS.speak(botresponceextracted,TextToSpeech.QUEUE_FLUSH,null)
        val speed=sekbar.progress/50.toFloat()
        mTTS.setSpeechRate(speed)
    }
}