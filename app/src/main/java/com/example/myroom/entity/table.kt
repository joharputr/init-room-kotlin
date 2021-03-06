package com.example.myroom.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "students")
data class Student(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "nim") var nim: String,
    @ColumnInfo(name = "gender") var gender: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0
) : Parcelable
//collumn use @CollumnInfo Annotation
//You can aslo declare the primary key by adding @PrimaryKey Annotation