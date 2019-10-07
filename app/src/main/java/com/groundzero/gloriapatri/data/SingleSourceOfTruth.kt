@file:Suppress("UNCHECKED_CAST")

package com.groundzero.gloriapatri.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.groundzero.gloriapatri.data.prayers.Prayer
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.tasks.await

fun <T> resultLiveData(
  dataQuery: suspend () -> LiveData<T>,
  networkCall: suspend () -> Task<QuerySnapshot>,
  saveCallResult: suspend (T) -> Unit
): LiveData<Result<T>> =
  liveData(IO) {
    emit(Result.loading())

    val source = dataQuery.invoke().map {
      Result.success(it)
    }
    try {
      val snapshot: QuerySnapshot = networkCall.invoke().await()
      val prayers = snapshot.toObjects(Prayer::class.java)
      saveCallResult.invoke(prayers as T)
    } catch (e: FirebaseFirestoreException) {
      emit(Result.error(e.message!!))
    }
    emitSource(source)
  }