package com.example.a007

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var data = intent.extras
        if (data != null) {
            var name = data.get("shumshuq")

            text_view_2.text = name.toString()

//            text_view_2.setOnClickListener {
//                var returnIntent = this.intent
//                returnIntent.putExtra("return", "Hello from Main2Activity")
//                setResult(Activity.RESULT_OK, returnIntent)
//                finish()
//            }
        }
    }
}
