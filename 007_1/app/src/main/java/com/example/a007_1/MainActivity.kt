package com.example.a007_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    private var REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.setOnClickListener {
            var intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("TTT", "komiljon")
            intent.putExtra("TTT2", 23)
            intent.putExtra("TTT3", 'a')
            startActivityForResult(intent, REQUEST_CODE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                var s = data?.extras?.get("return").toString()
                text_view.text = s

            }
        }
    }
}
