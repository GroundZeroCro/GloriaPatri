package com.groundzero.gloriapatri.di.coremodules

import com.groundzero.gloriapatri.di.modules.PersistenceModule
import com.groundzero.gloriapatri.di.modules.RemoteModule
import com.groundzero.gloriapatri.di.modules.ViewModelModule
import dagger.Module

@Module(includes = [PersistenceModule::class, ViewModelModule::class, RemoteModule::class])
interface AppModule