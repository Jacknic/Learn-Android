package com.jacknic.android.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jacknic.android.room.data.Note
import com.jacknic.android.room.data.NoteDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = NoteDatabase.create(this, false)
        val noteDao = database.getNoteDao()
        val note = Note(title = "测试标题", content = "测试是内容")
        Thread {
            noteDao.insert(note)
        }.start()
    }
}
