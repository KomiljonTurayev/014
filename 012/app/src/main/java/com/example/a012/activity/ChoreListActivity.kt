package com.example.a012.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a012.R
import com.example.a012.adapters.ChoreListAdapter
import com.example.a012.data.ChoresDatabaseHandler
import com.example.a012.models.Chore
import kotlinx.android.synthetic.main.activity_chore_list.*

class ChoreListActivity : AppCompatActivity() {
    private var adapter: ChoreListAdapter? = null
    private var choreList: ArrayList<Chore>? = null
    private var choreListItems: ArrayList<Chore>? = null

    private var layoutManager: RecyclerView.LayoutManager? = null
    var dbHandler: ChoresDatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore_list)

        dbHandler = ChoresDatabaseHandler(this)


        choreList = ArrayList<Chore>()
        choreListItems = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = ChoreListAdapter(choreListItems!!, this)


//        setup list = recyclerView
        recycler_view_id.layoutManager = layoutManager
        recycler_view_id.adapter = adapter

//        load our Chores
        choreList = dbHandler!!.readAChore()


        for (i in choreList!!.iterator()) {
            Log.d("List", i.choreName)
            val chore = Chore()
            chore.assignedTo = i.assignedTo
            chore.assignedBy = i.assignedBy
            chore.choreName = i.choreName

            choreListItems!!.add(chore)
        }
        adapter!!.notifyDataSetChanged()

    }
}
