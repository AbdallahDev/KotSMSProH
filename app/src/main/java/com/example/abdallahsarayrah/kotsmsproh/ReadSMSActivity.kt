package com.example.abdallahsarayrah.kotsmsproh

import android.annotation.SuppressLint
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_read_sms.*

class ReadSMSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_sms)

        var list = ArrayList<String>()

        val uri = Uri.parse("content://sms//inbox")
        val fields = arrayOf("address", "body")
        val cur = contentResolver.query(uri, fields, null, null, null)

        cur.moveToFirst()
        while (!cur.isAfterLast) {
            list.add(cur.getString(0) + "\n" + cur.getString(1))
            cur.moveToNext()
        }

        val adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adp
    }
}
