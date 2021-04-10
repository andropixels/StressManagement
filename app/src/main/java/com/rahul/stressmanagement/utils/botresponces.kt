package com.rahul.stressmanagement.utils

import com.rahul.stressmanagement.utils.constants.CALL
import com.rahul.stressmanagement.utils.constants.OPEN_SEARCH
import com.rahul.stressmanagement.utils.constants.PLAY

object botresponces {
    fun responces(mess:String):String{

        val random=(0..2).random()
        val argumess=mess.toLowerCase()
        return when{



            argumess.contains("call")->{
                CALL


            }

            argumess.contains("search")->{
                OPEN_SEARCH


            }

            argumess.contains("play")->{
                PLAY


            }
            argumess.contains("hello" ) -> {

                when(random){
                    0-> "hey rahul "
                    1 ->"hello rahul "
                    2->"hello rahul"
                    else ->"error"
                }
            }

            argumess.contains("good morning" )  -> {

                when(random){
                    0-> "good morning  rahul "
                    1 ->" good morniing rahul "
                    2->"good morning "
                    else ->"error"
                }
            }
            argumess.contains("सुभ सकाळ") -> {

                when(random){
                    0-> "सुभ सकाळ राहुल "
                    1 ->"सुभ सकाळ राहुल "
                    2->"सुभ सकाळ राहुल"
                    else ->"error"
                }
            }
            argumess.contains("fine") -> {

                when(random){
                    0-> "goood "
                    1 ->"goood "
                    2->"goood"
                    else ->"error"
                }
            }



            argumess.contains("how are you")->{
                when(random){

                    0->"i am good , how about you"
                    1->"very good , what about you"
                    2->"very good , what about you"

                    else -> "error"
                }
            }

            argumess.contains("who are you") -> {

                when(random){
                    0-> "my name is pixel i am a  chatbot,  what can i do for you?  "
                    1-> "my name is pixel i am a  chatbot,  what can i do for you? "
                    2-> "my name is pixel i am a  chatbot,  what can i do for you?"



                    else ->"error"
                }
            }
            argumess.contains("my name is")  -> {

                when(random){
                    0-> " nice to meet you"
                    1-> " nice to meet you"
                    2-> " nice to meet you"



                    else ->"error"
                }
            }
            argumess.contains("tell me about yourself")  -> {

                when(random){
                    0-> " i am a static chatbot, and my name is pixel   ,  what can i do for you?"
                    1-> " i am a static chatbot, and my name is pixel  , what can i do for you?"
                    2-> " i am a static chatbot, and my name is pixel  ,  what can i do for you?"



                    else ->"error"
                }
            }

            argumess.contains("sing for me")  -> {

                when(random){
                    0-> "sorry i cant sing, but  ,  which song do you like to play"
                    1-> "sorry i cant sing, but  ,which song do you like to play"
                    2-> "sorry i cant sing ,but ,  which song do you like to play"



                    else ->"error"
                }
            }
            argumess.contains("time") ->{
                time.timestamp()//
            }
            else ->{
                when(random){

                    0->"i didn't get that"
                    1->"i dont know"
                    2->"excuse me"
                    else -> "error"
                }
            }
        }
    }
}