package com.ruben.aplicacionespmdm.MessageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ruben.aplicacionespmdm.R

class MessageSending : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_sending)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etMsg)

        btnSend.setOnClickListener {
            var message = userText.text.toString()
            if (message.isNotEmpty()) {
                var intent = Intent(this, ReplySending::class.java)
                intent.putExtra("extra_message", message)
                startActivity(intent)
            }
        }

        var textReceived = findViewById<TextView>(R.id.tvReply)
        var tvReplyReceived = findViewById<TextView>(R.id.tvReplyReceived)

        var reply: String = intent.extras?.getString("extra_reply").orEmpty()

        if(reply.isNotEmpty()) {
            textReceived.text = reply
            tvReplyReceived.text = "Reply received!"
        }
    }
}