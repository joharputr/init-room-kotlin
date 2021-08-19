package com.example.myroom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myroom.entity.Student
import com.example.myroom.entity.StudentDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var db: StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db =
            Room.databaseBuilder(applicationContext, StudentDatabase::class.java, "studentdata-db").build()

        //menggunakan coroutine
        GlobalScope.launch {
            db.studentDao().deleteAll()//<--
            initData()
            diplayData()
        }
    }

    private fun diplayData() {
        val books: List<Student> = db.studentDao().getAll()
        var displayText = ""
        for (book in books) {
            displayText += "${book.id} | ${book.name} | ${book.gender} | Hal : ${book.nim}\n"
        }
        textDb.text = displayText
    }

    private fun initData() {
        val book1 = Student("Ada Apa dengan Hujan", "Andre Senja", "30")
        val book2 = Student("Malam setelah Sore", "Andi Bisa", "40")
        val book3 = Student("Pecahkan Mentari", "Dera", "20")
        //insert data ke database
        db.studentDao().insert(book1, book2, book3)
    }
}