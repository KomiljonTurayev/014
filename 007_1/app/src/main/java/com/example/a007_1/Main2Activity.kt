package com.example.a007_1

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var getIntent = intent.extras

        if (getIntent != null) {
            var name = getIntent.get("TTT")
            var age = getIntent.getInt("TTT2")
            var char = getIntent.getChar("TTT3")

            Toast.makeText(this, "$name, $age, $char", Toast.LENGTH_LONG).show()
        }
        text_view2.setOnClickListener {
            var returnIntent = this.intent
            returnIntent.putExtra("return","Hello from Second Activity")
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }
    }
}
