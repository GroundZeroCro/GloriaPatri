package com.groundzero.gloriapatri.di.components

import android.app.Application
import com.groundzero.gloriapatri.base.App
import com.groundzero.gloriapatri.di.coremodules.ActivityModule
import com.groundzero.gloriapatri.di.coremodules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}