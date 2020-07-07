package com.example.a012.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a012.R
import com.example.a012.models.Chore

class ChoreListAdapter(
    private val data: ArrayList<Chore>,
    private val context: Context
) :
    RecyclerView.Adapter<ChoreListAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var choreName = itemView.findViewById(R.id.listChoreName) as TextView
        var assignedBy = itemView.findViewById(R.id.listAssignedBy) as TextView
        var assignedTime = itemView.findViewById(R.id.listData) as TextView
        var assignedTo = itemView.findViewById(R.id.listAssignedTo) as TextView

        fun bind(chore: Chore) {
            choreName.text = chore.choreName
            assignedBy.text = chore.assignedBy
            assignedTime.text = chore.showHumanData(timeAs = 1)
            assignedTo.text = chore.assignedTo
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
}
