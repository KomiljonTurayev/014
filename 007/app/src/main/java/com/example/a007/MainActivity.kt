package com.example.a007

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        text_view.setOnClickListener {
//            var intent = Intent(this, Main2Activity::class.java)
//            intent.putExtra("shumshuq", "Komiljon")
//            intent.putExtra("shurtumshuq", 12)
//
//            startActivity(intent)
//        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
////        if (requestCode == REQUEST_CODE) {
////                if (resultCode == Activity.RESULT_OK) {
////                    var result = data!!.extras!!.get("return")
////    //                text_view.text = result
////                Toast.makeText(this, "$result", Toast.LENGTH_LONG).show()
////            }
////        }
//    }
}
