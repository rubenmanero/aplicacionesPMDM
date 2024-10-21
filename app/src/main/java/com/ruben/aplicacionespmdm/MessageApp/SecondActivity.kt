package com.ruben.aplicacionespmdm.MessageApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ruben.aplicacionespmdm.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var messageText = findViewById<TextView>(R.id.tvText)
        var text: String = intent.extras?.getString("extra_text").orEmpty()
        messageText.text = "$text"

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etUserText)

        btnSend.setOnClickListener{
            var text = userText.text.toString()
            if (text.isNotEmpty()){
                var textIntent = Intent(this, MainActivity::class.java)
                textIntent.putExtra("extra_reply",text)
                startActivity(textIntent)
            }
        }
    }
}