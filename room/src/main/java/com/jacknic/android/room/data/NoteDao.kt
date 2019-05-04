package com.jacknic.android.room.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author Jacknic
 * @date 2019/05/04
 */
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg noteBean: Note)

    @Update
    fun update(vararg notes: Note)

    @Query("SELECT * FROM note ORDER BY id")
    fun getAll(): LiveData<List<Note>>

    @Delete
    fun delete(noteList: List<Note>)

    @Query("SELECT * FROM note WHERE id=:noteId")
    fun findById(noteId: Long): LiveData<Note>

}