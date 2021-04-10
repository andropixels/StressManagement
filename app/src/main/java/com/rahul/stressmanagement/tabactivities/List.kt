package com.rahul.stressmanagement.tabactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.stressmanagement.R

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setTheme(R.style.ThemeStressManagement)

    }
}