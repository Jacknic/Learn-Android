package com.jacknic.android.room

import android.util.Log.d
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jacknic.android.room.data.Note
import com.jacknic.android.room.data.NoteDao
import com.jacknic.android.room.data.NoteDatabase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * 基本数据库测试
 * */
@RunWith(AndroidJUnit4::class)
class SimpleDatabaseTest {

    private lateinit var noteDao: NoteDao
    private val listSize = 30
    private val tag = "DatabaseTest"
    private val testNote = Note(title = "测试数据标题", content = "测试数据内容，测试数据内容")


    /**
     * 初始化数据库
     */
    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val noteDatabase = NoteDatabase.create(context, true)
        noteDao = noteDatabase.getNoteDao()
    }

    /**
     * 插入数据
     */
    @Test
    fun insert() {
        d(tag, "插入数据")
        noteDao.insert(testNote)
        val noteDb = noteDao.findById(1)
        Assert.assertNotNull(noteDb)
    }

    /**
     * 查询数据
     */
    @Test
    fun query() {
        d(tag, "查询数据")
        writeList()
        val note = noteDao.findById((listSize / 2).toLong())
        Assert.assertNotNull(note)
        d(tag, "查询到的数据note={${note.id},${note.title},${note.content},${note.time}}")
    }

    /**
     * 写入数据列表到数据库
     */
    private fun writeList() {
        val noteList = arrayListOf<Note>()
        for (i in 0 until listSize) {
            noteList.add(Note(title = testNote.title + i, content = testNote.content + i))
        }
        noteDao.insertAll(noteList)
    }

    /**
     * 更新数据
     */
    @Test
    fun update() {
        d(tag, "更新数据")
        noteDao.insert(testNote)
        val note = noteDao.findById(1)
        val text = "修改后的内容"
        note.content = text
        noteDao.update(note)
        val noteDb = noteDao.findById(1)
        Assert.assertEquals(text, noteDb.content)
    }

    /**
     * 删除数据
     */
    @Test
    fun delete() {
        d(tag, "删除数据")
        writeList()
        noteDao.deleteById((listSize / 2).toLong())
        Assert.assertEquals(noteDao.getAll().size, listSize - 1)
    }
}
