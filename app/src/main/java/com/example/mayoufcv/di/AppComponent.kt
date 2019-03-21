package com.example.mayoufcv.di

import android.app.Application
import com.example.mayoufcv.common.MayoufCV
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, DatabaseModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {

    fun inject(application: MayoufCV)
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance fun application(application: Application): Builder
    }
}