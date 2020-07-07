@file:Suppress("DEPRECATION")

package com.example.a012.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a012.R
import com.example.a012.adapters.ChoreListAdapter
import com.example.a012.data.ChoresDatabaseHandler
import com.example.a012.models.Chore
import kotlinx.android.synthetic.main.activity_chore_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dbHandler: ChoresDatabaseHandler? = null
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressDialog = ProgressDialog(this)
//        progressDialog

        dbHandler = ChoresDatabaseHandler(this)

        saveChore.setOnClickListener {
            progressDialog!!.setTitle("Saving...")
            progressDialog!!.show()

            if (!TextUtils.isEmpty(enterChoreId.toString()) && !TextUtils.isEmpty(assignedById.toString())
                && !TextUtils.isEmpty(assignedToId.toString())
            ) {

//                save to database
                val chore = Chore()
                val enterChore = enterChoreId.text.toString()
                val assignedBy = assignedToId.text.toString()
                val assignedTo = assignedById.text.toString()
                chore.choreName = enterChore
                chore.assignedTo = assignedBy
                chore.assignedBy = assignedTo

                saveToDb(chore)
                progressDialog!!.cancel()
                startActivity(Intent(this, ChoreListActivity::class.java))
            } else {
                Toast.makeText(this, "Please enter a chore!!!", Toast.LENGTH_SHORT).show()
            }
        }


//        var chore = Chore()
//        chore.choreName = "Shumshuq2"
//        chore.assignedTo = "James 2"
//        chore.assignedBy = "Carlos2"
//
////        dbHandler!!.createChore(chore)
//
////        Read from database
//        val chores: ArrayList<Chore> = dbHandler!!.readAChore()
//        Log.d("Item", chores[1].choreName )

    }

    fun saveToDb(chore: Chore) {
        dbHandler!!.createChore(chore)
    }
}
