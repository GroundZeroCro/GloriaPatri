package com.groundzero.gloriapatri.features.prayers.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.Exclude

@Entity(tableName = "prayers")
data class Prayer(
  @Exclude
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0,
  var title: String = "",
  var text: String = "",
  var prayerId: String = "",
  var tag: String = "",
  @Exclude
  var isBookmarked: Boolean = false
)