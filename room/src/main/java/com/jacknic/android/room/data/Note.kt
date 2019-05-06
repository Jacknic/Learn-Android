package com.jacknic.android.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Jacknic
 * @date 2019/05/04
 */
@Entity(tableName = "note")
data class Note(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id") var id: Long = 0,
        var title: String,
        var content: String,
        var time: Long = System.currentTimeMillis()
)