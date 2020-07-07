package com.example.a009

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayList = arrayListOf("shumshuq1","shumshuq2","shumshuq3","shumshuq4","shumshuq5","shumshuq6","shumshuq7","shumshuq8","shumshuq9"
        ,"shumshuq1","shumshuq2","shumshuq3","shumshuq4","shumshuq5","shumshuq6","shumshuq7","shumshuq8","shumshuq9"
        )

        var nameAdapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList)
        list_view.adapter = nameAdapter

        list_view.setOnItemClickListener { parent, view, position, id ->

            var itemName:String = list_view.getItemAtPosition(position).toString()
            Toast.makeText(this, itemName,Toast.LENGTH_SHORT ).show()

        }
    }
}
