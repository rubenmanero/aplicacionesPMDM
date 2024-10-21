package com.ruben.aplicacionespmdm.MessageApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ruben.aplicacionespmdm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var replyText = findViewById<TextView>(R.id.tvText)
        var reply: String = intent.extras?.getString("extra_reply").orEmpty()
        replyText.text = "$reply"
        if(reply.isNotEmpty()) {
            var title = findViewById<TextView>(R.id.tvReply)
            title.text = "Reply received"
        }

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etUserText)

        btnSend.setOnClickListener{
            var text = userText.text.toString()
            if (text.isNotEmpty()){
                var textIntent = Intent(this, SecondActivity::class.java)
                textIntent.putExtra("extra_text",text)
                startActivity(textIntent)
            }
        }
    }
}