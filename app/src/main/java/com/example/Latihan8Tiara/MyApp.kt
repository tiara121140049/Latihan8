package com.example.Latihan8Tiara

import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this, AppDatabase::class.java, "my_database")
            .build()

        Thread {
            val userDao = database.userDao()
            userDao.insertUser(User(
                username = "Tiara", email = "tiara@example.com"))
            userDao.insertUser(User(
                username = "Putri", email = "putri@example.com"))
            userDao.insertUser(User(
                username = "Elisa", email = "elisa@example.com"))
        }.start()
    }
}