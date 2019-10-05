package com.groundzero.gloriapatri.di.modules

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    fun providePrayersCollection(fb: FirebaseFirestore): CollectionReference =
        fb.collection(PRAYERS_COLLECTION)

    @Singleton
    @Provides
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    companion object {
        private const val PRAYERS_COLLECTION = "prayers"
    }
}