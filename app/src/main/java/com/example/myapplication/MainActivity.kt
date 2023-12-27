package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var buttonSendText: Button
    private lateinit var editTextPhone: EditText
    private lateinit var buttonMakeCall: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        buttonSendText = findViewById(R.id.buttonSendText)
        editTextPhone = findViewById(R.id.editTextPhone)
        buttonMakeCall = findViewById(R.id.buttonMakeCall)

        buttonSendText.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java)
                .putExtra("text", editText.text.toString()))
        }

        buttonMakeCall.setOnClickListener {
            val phoneNumber = editTextPhone.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

    }
}