package com.example.a012.models

class Chore() {
    fun showHumanData(timeAs: Long): CharSequence? {
        return timeAs.toString()
    }

    var choreName: String? = null
    var assignedBy: String? = null
    var assignedTo: String? = null
    var assignedTime: Long? = null
    var id: Int? = null

    constructor(
        choreName: String, assignedBy: String,
        assignedTo: String, assignedTime: Long, id: Int
    ) : this() {
        this.choreName = choreName
        this.assignedBy = assignedBy
        this.assignedTo = assignedTo
        this.assignedTime = assignedTime
        this.id = id

    }
}
