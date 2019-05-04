package com.jacknic.android.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author Jacknic
 * @date 2019/05/04
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        private const val DB_NAME = "note_db"

        /**
         * 创建数据库
         */
        fun create(context: Context, memoryOnly: Boolean): NoteDatabase {
            return if (memoryOnly) {
                Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java).build()
            } else {
                Room.databaseBuilder(context, NoteDatabase::class.java, DB_NAME).build()
            }
        }
    }
}