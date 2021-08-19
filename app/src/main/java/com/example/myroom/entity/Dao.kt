package com.example.myroom.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * from students")
    fun getAll(): List<Student>

    @Insert
    fun insert(vararg books: Student)

    @Delete
    fun delete(student: Student)

    @Query("DELETE FROM students")
    fun deleteAll()

    @Query("UPDATE students SET name =:studentName, nim =:studentNim, gender =:studentGen WHERE id =:studentId")
    fun update(studentId: Long, studentName: String, studentNim: String, studentGen: String)
}