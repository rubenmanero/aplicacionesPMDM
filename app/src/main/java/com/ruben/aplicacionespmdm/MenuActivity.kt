package com.ruben.aplicacionespmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ruben.aplicacionespmdm.BoardgamesApp.BoardgameActivity
import com.ruben.aplicacionespmdm.ColorsApp.ColorsActivity
import com.ruben.aplicacionespmdm.HelloApp.MainActivity
import com.ruben.aplicacionespmdm.IMCApp.IMCcalculator
import com.ruben.aplicacionespmdm.MessageApp.MessageSending
import com.ruben.aplicacionespmdm.R.id.btnIMCApp
import com.ruben.aplicacionespmdm.SuperheroApp.SuperheroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        var btnBoardgameApp = findViewById<Button>(R.id.btnBoardgameApp)
        var btnColorsApp = findViewById<Button>(R.id.btnColorsApp)
        var btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)

        btnHelloApp.setOnClickListener{ navigateToHelloApp() }
        btnMessageApp.setOnClickListener{ navigateToMessageApp() }
        btnIMCApp.setOnClickListener{ navigateToIMCApp() }
        btnBoardgameApp.setOnClickListener{ navigateToBoardgameApp() }
        btnSuperheroApp.setOnClickListener{ navigateToSuperheroApp() }

    }
    //Fuera de la función onCreate()
    private fun navigateToHelloApp(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp(){
        var intent = Intent(this, MessageSending::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
        var intent = Intent(this, IMCcalculator::class.java)
        startActivity(intent)
    }

    private fun navigateToBoardgameApp() {
        var intent = Intent(this, BoardgameActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToColorsApp(){
        var intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperheroApp(){
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }
}