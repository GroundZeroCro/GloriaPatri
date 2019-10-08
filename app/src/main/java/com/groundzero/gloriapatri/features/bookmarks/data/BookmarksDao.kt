package com.groundzero.gloriapatri.features.bookmarks.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookmarksDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addBookmark(bookmarkPrayer: BookmarkPrayer)

  @Delete
  fun removeBookmark(bookmarkPrayer: BookmarkPrayer)

  @Query("SELECT * FROM bookmark_prayers")
  fun getBookmarks(): LiveData<List<BookmarkPrayer>>
}