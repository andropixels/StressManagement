package com.rahul.stressmanagement.tabactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.stressmanagement.R

class focous : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ThemeStressManagement)

        setContentView(R.layout.activity_focous)
    }
}