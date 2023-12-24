package com.example.androidretrofit.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidretrofit.domain.Info

@Entity(tableName = "info")
data class InfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val desc: String,
    val image: String,
    val tag: String,
    val category: String,
    val author: String,
    val date: String,
)

fun InfoEntity.toInfo(): Info {
    return Info(
        title = this.title,
        desc = this.desc,
        image = this.image,
        tag = this.tag,
        category = this.category,
        author = this.author,
        date = this.date
    )
}