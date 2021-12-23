package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var location: EditText
    lateinit var mobile: EditText
    lateinit var eMail: EditText

    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.etName)
        location = findViewById(R.id.etLocation)
        mobile = findViewById(R.id.etMobile)
        eMail = findViewById(R.id.etEMail)
        submit = findViewById(R.id.submitBtn)

        submit.setOnClickListener {
            if (!findViewById<CheckBox>(R.id.checkBox).isChecked) {
                Toast.makeText(applicationContext, "please check the checkBox", Toast.LENGTH_LONG)
                    .show()
            } else {
                startActivity(Intent(this, SecondActivity::class.java)
                    .putExtra("dataPerson", arrayListOf(
                        name.text.toString(),
                        location.text.toString(),
                        mobile.text.toString(),
                        eMail.text.toString()
                    )))
            }
        }
    }
}