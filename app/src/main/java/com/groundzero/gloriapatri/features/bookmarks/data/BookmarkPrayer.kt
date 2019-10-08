package com.groundzero.gloriapatri.features.bookmarks.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.groundzero.gloriapatri.features.prayers.data.Prayer

@Entity(tableName = "bookmark_prayers")
data class BookmarkPrayer(
  @TypeConverters(BookmarkConverter::class)
  val prayer: Prayer
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0
}