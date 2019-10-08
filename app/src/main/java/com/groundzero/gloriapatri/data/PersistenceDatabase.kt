package com.groundzero.gloriapatri.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.groundzero.gloriapatri.features.bookmarks.data.BookmarkConverter
import com.groundzero.gloriapatri.features.bookmarks.data.BookmarkPrayer
import com.groundzero.gloriapatri.features.bookmarks.data.BookmarksDao
import com.groundzero.gloriapatri.features.prayers.data.Prayer
import com.groundzero.gloriapatri.features.prayers.data.PrayersDao

@Database(entities = [Prayer::class, BookmarkPrayer::class], exportSchema = false, version = 1)
@TypeConverters(BookmarkConverter::class)
abstract class PersistenceDatabase : RoomDatabase() {

  abstract fun getPrayersDao(): PrayersDao
  abstract fun getBookmarkDao(): BookmarksDao

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