package com.ruben.aplicacionespmdm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ruben.aplicacionespmdm.BoardgamesApp.BoardgamesActivity
import com.ruben.aplicacionespmdm.IMCapp.IMCactivity
import com.ruben.aplicacionespmdm.MessageApp.MainActivity

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnIMCApp = findViewById<Button>(R.id.btnIMCapp)
        var btnBoardgamesApp = findViewById<Button>(R.id.btnBoardgamesApp)

        btnMessageApp.setOnClickListener { navigateToMessageApp() }
        btnIMCApp.setOnClickListener { navigateToIMCapp() }
        btnBoardgamesApp.setOnClickListener { navigateToBoardgamesApp() }

    }

    private fun navigateToMessageApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCapp() {
        var intent = Intent(this, IMCactivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBoardgamesApp() {
        var intent = Intent(this, BoardgamesActivity::class.java)
        startActivity(intent)
    }
}