package io.justdev.droiderapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(private val context: Context) {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(): Context {
        return context
    }
}