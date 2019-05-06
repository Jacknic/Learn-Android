package com.jacknic.android.room.data

import androidx.room.*

/**
 * @author Jacknic
 * @date 2019/05/04
 */
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg noteBean: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(noteList: List<Note>)

    @Update
    fun update(vararg notes: Note)

    @Query("SELECT * FROM note ORDER BY id")
    fun getAll(): List<Note>

    @Delete
    fun delete(noteList: List<Note>)

    @Query("delete from note where id=:id")
    fun deleteById(id: Long)

    @Query("SELECT * FROM note WHERE id=:noteId")
    fun findById(noteId: Long): Note

}