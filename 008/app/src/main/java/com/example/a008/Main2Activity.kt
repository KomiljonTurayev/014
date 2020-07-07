package com.example.a008

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text1 = "* Instrumented test, which will execute on an Android device.\n" +
                " *\n" +
                " * See [testing documentation](http://d.android.com/tools/testing)."

        val getIntent = intent.extras?.get("image")
        val main_number = getIntent.toString().toInt()
        if (main_number == 0) {
            image_view2.setImageResource(R.drawable.image1)
            text_view2.text = text1
        } else {
            image_view2.setImageResource(R.drawable.image2)
            text_view2.text = text1

        }


    }
}
