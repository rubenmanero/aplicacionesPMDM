package com.ruben.aplicacionespmdm.MessageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ruben.aplicacionespmdm.R

class ReplySending : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reply_sending)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etMsg)

        btnSend.setOnClickListener {
            var reply = userText.text.toString()
            if (reply.isNotEmpty()) {
                var intent = Intent(this, MessageSending::class.java)
                intent.putExtra("extra_reply", reply)
                startActivity(intent)
            }
        }

        var textReceived = findViewById<TextView>(R.id.tvMsg)

        var message: String = intent.extras?.getString("extra_message").orEmpty()
        textReceived.text = message
    }
}