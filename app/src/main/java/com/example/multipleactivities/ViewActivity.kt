package com.example.multipleactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.system.exitProcess
import android.view.Menu
import android.view.MenuItem

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val infoList = intent.extras?.getStringArrayList("dataPerson")
        val rvMain = findViewById<RecyclerView>(R.id.rvMain)

        if(!infoList.isNullOrEmpty()){
            rvMain.adapter = RVAdapter(infoList)
            rvMain.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun showAlert() {
        AlertDialog.Builder(this)
            .setTitle("Where Do You Want To Go?")
            .setMessage("Select Destination...")
            .setPositiveButton("Home") { _, _ ->
                startActivity(Intent(this, MainActivity::class.java))
            }.setNegativeButton("Exit") { _, _ ->
                exitProcess(1)
            }.show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.goToMenu -> {
                showAlert()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}