package com.groundzero.gloriapatri.di.modules

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.groundzero.gloriapatri.di.modules.LanguageModule.Companion.NAMED_LOCALE_CODE
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RemoteModule {

  @Provides
  fun providePrayersCollection(
    fireStore: FirebaseFirestore,
    @Named(NAMED_LOCALE_CODE) locale: String
  ): CollectionReference =
    fireStore.collection(locale)

  @Singleton
  @Provides
  fun provideFireStore(): FirebaseFirestore = Firebase.firestore
}