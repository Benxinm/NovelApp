package com.benxinm.novelapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.benxinm.novelapplication.data.dao.CollectionDao
import com.benxinm.novelapplication.data.dao.ContentDao
import com.benxinm.novelapplication.data.dao.UserDao
import com.benxinm.novelapplication.data.entity.CollectionEntity
import com.benxinm.novelapplication.data.entity.ContentEntity
import com.benxinm.novelapplication.data.entity.UserEntity

@Database(entities = [UserEntity::class, ContentEntity::class,CollectionEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun contentDao(): ContentDao
    abstract fun collectionDao():CollectionDao
    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "app_database")
                .allowMainThreadQueries()//允许占用主线程
                .build().apply {
                    instance = this
                }
        }
    }
}