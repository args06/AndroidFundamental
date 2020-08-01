package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject : TextView = findViewById(R.id.tv_object_received)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
        val text = "Hello guys, Namaku ${person.name.toString()}, umurku " +
                "${person.age.toString()} tahun, dan aku tinggal di ${person.city.toString()}. " +
                "Kalau ingin menghubungiku bisa melalui \nE-Mail : ${person.email.toString()}"
        tvObject.text = text
    }
}