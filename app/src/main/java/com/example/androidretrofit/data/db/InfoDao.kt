package com.example.androidretrofit.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInfo(movies: List<InfoEntity>)

    @Query("SELECT * FROM info")
    suspend fun getInfo(): List<InfoEntity>
}