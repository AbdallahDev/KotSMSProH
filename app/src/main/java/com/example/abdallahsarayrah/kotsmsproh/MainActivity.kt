package com.example.abdallahsarayrah.kotsmsproh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_send.setOnClickListener {
            val manager = SmsManager.getDefault()
            manager.sendTextMessage(editText_phone.text.toString(), null, editText_text.text.toString(), null, null)
        }
    }
}
