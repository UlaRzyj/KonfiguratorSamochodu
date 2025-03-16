package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var modelAuta: String = ""
    private var klimatyzacja: String = "Nie"
    private var skorzaneSiedzenia: String = "Nie"
    private var podgrzewaneFotele: String = "Nie"

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
        val auta = findViewById<RadioGroup>(R.id.carModels)
        auta.setOnCheckedChangeListener { _, checkedId ->
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

        val klimatyzacjaCheckBox = findViewById<CheckBox>(R.id.klimatyzacja)
        val skorzaneSiedzeniaCheckBox = findViewById<CheckBox>(R.id.skorzaneSiedzenia)
        val podgrzewaneFoteleCheckBox = findViewById<CheckBox>(R.id.podgrzewaneFotele)
        klimatyzacjaCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                klimatyzacja = "Tak"
            } else {
                klimatyzacja = "Nie"
            }
        }
        skorzaneSiedzeniaCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                skorzaneSiedzenia = "Tak"
            } else {
                skorzaneSiedzenia = "Nie"
            }
        }
        podgrzewaneFoteleCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                podgrzewaneFotele = "Tak"
            } else {
                podgrzewaneFotele = "Nie"
            }
        }

        val podsumowanieButton = findViewById<Button>(R.id.przyciskPodsumowanie)

        podsumowanieButton.setOnClickListener {
            val podsumowanie = findViewById<TextView>(R.id.podsumowanie)
            val podsumowanieText = "Podsumowanie:\n" +
                    "Wybrany model auta: $modelAuta\n" +
                    "Klimatyzacja: $klimatyzacja\n" +
                    "Skórzane siedzenia: $skorzaneSiedzenia\n" +
                    "Podgrzewane fotele: $podgrzewaneFotele"

            podsumowanie.text = podsumowanieText
        }


    }
}