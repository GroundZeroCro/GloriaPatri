package com.groundzero.gloriapatri.data.prayers

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PrayersDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(prayers: List<Prayer>)

  @Query("SELECT * FROM prayers")
  fun getPrayers(): LiveData<List<Prayer>>

  @Query("SELECT * FROM prayers WHERE tag = :tag")
  fun getPrayersPerTag(tag: String): List<Prayer>

  @Query("SELECT * FROM prayers WHERE prayerId = :prayerId LIMIT 1")
  fun getPrayerPerPrayerId(prayerId: String): Prayer
}