package com.example.a011

import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS_NAME = "myPrefs"
    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_id.setOnClickListener {
            myPref = getSharedPreferences(PREFS_NAME, 0)
            val editor: SharedPreferences.Editor = myPref!!.edit()

            if (!TextUtils.isEmpty(edit_id.text.toString())) {
                val message = edit_id.text.toString()
                editor.putString("message", message)
                editor.apply()
            } else {
                Toast.makeText(this, "Please write anything     ", Toast.LENGTH_SHORT).show()
            }

            //    get cDATA
            var dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)
            if (dataBack.contains("message")) {
                var getTextt = dataBack.getString("message", "I cannot find")
                text_id.text = getTextt
            }
        }
    }
}
