package com.groundzero.gloriapatri.features.bookmarks.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.groundzero.gloriapatri.features.prayers.data.Prayer

class BookmarkConverter {

  @TypeConverter
  fun toString(prayer: Prayer): String = Gson().toJson(prayer)

  @TypeConverter
  fun fromString(data: String): Prayer = Gson().fromJson(data, object : TypeToken<Prayer>() {}.type)
}