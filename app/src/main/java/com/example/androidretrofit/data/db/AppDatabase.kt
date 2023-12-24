package com.example.androidretrofit.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Singleton
@Database(entities = [InfoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun infoDao(): InfoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "info_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
