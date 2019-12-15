package com.tamimattafi.qtask.model.entities.tasks

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.tamimattafi.qtask.model.database.DatabaseValues.Tables.TASKS_TABLE

@Entity(tableName = TASKS_TABLE)
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    var name: String? = null,
    var owner: Long? = null,
    var description: String? = null,
    @SerializedName("can_edit")
    var canEdit: Int = 0,
    var date: Long = 0,
    var friends: String = "",
    var important: Int = 0
) {
    object Sortables {
        const val DATE = "date"
        const val ID = "id"
    }


}