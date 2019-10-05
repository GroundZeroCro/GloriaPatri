package com.groundzero.gloriapatri.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.groundzero.gloriapatri.data.prayers.Prayer
import com.groundzero.gloriapatri.data.prayers.PrayersDao

@Database(entities = [Prayer::class], exportSchema = false, version = 1)
abstract class PersistenceDatabase : RoomDatabase() {

    abstract fun getPrayersDao(): PrayersDao

    companion object {

        @Volatile
        private var instance: PersistenceDatabase? = null

        fun getInstance(context: Context): PersistenceDatabase =
            instance
                ?: buildDatabase(
                    context
                ).also { instance = it }

        private fun buildDatabase(context: Context): PersistenceDatabase {
            return Room.databaseBuilder(
                context, PersistenceDatabase::class.java,
                PRAYERS_DATABASE_NAME
            )
                .allowMainThreadQueries()
                .createFromAsset(ASSETS_PRAYERS_PATH)
                .build()
        }

        private const val PRAYERS_DATABASE_NAME = "prayers_database"
        private const val ASSETS_PRAYERS_PATH = "database/prayers.db"
    }
}