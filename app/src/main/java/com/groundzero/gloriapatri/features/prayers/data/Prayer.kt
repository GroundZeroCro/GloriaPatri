package com.groundzero.gloriapatri.features.prayers.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prayers")
data class Prayer(
  @PrimaryKey
  var id: Int = 0,
  var title: String = "",
  var text: String = "",
  var prayerId: String = "",
  var tag: String = ""
)