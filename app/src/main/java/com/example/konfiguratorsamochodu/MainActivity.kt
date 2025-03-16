package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var modelAuta: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val zdjecia = findViewById<ImageView>(R.id.images)
        val image = listOf(
            R.drawable.sedan,
            R.drawable.suv,
            R.drawable.hatchback
        )
        val kawy = findViewById<RadioGroup>(R.id.carModels)
        kawy.setOnCheckedChangeListener { _, checkedId ->
            val kawa = findViewById<RadioButton>(checkedId)
            if (kawa.text == "Sedan") {
                zdjecia.setImageResource(image[0])
                modelAuta = "Sedan"
            } else if (kawa.text == "SUV") {
                modelAuta = "SUV"
                zdjecia.setImageResource(image[1])
            } else if (kawa.text == "Hatchback") {
                modelAuta = "Hatchback"
                zdjecia.setImageResource(image[2])
            }
        }




    }
}