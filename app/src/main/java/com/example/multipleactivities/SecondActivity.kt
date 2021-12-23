package com.example.multipleactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView



class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val infoList = intent.extras?.getStringArrayList("dataPerson")
        val personalData: TextView = findViewById(R.id.tvData)

        for (i in infoList!!) {
            personalData.text = "${personalData.text} $i \n"
        }

        val confirmBtn: Button = findViewById(R.id.confirmBtn)
        confirmBtn.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java)
                .putExtra("dataPerson", infoList))
        }
    }
}