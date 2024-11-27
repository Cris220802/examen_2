package com.example.examen_ii.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examen_ii.entity.CommentEntity
import com.example.examen_ii.entity.PostEntity
import com.example.examen_ii.entity.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class, CommentEntity::class], version = 2)
abstract class Db: RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun postDAO(): PostDAO
    abstract fun commentDAO(): CommentDAO

    companion object {
        @Volatile
        private var INSTANCE: Db? = null

        fun getDatabase(context: Context): Db {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "mascota_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }

}