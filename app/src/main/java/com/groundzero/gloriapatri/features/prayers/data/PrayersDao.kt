package com.groundzero.gloriapatri.features.prayers.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PrayersDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(prayers: List<Prayer>)

  @Query("SELECT * FROM prayers")
  fun getPrayers(): LiveData<List<Prayer>>

  @Query("SELECT * FROM prayers WHERE tag = :tag")
  fun getPrayersPerTag(tag: String): List<Prayer>

  @Query("SELECT * FROM prayers WHERE prayerId = :prayerId LIMIT 1")
  fun getPrayerPerPrayerIdLive(prayerId: String): LiveData<Prayer>

  @Query("SELECT * FROM prayers WHERE prayerId = :prayerId LIMIT 1")
  fun getPrayerPerPrayerId(prayerId: String): Prayer

  @Query("SELECT * FROM prayers WHERE isBookmarked = 1")
  fun getBookmarkedPrayers(): LiveData<List<Prayer>>

  @Update
  fun changeBookmarkState(prayer: Prayer)
}