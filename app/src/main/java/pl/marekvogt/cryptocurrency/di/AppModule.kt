package pl.marekvogt.cryptocurrency.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import pl.marekvogt.cryptocurrency.App
import java.util.*
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindApplication(app: App): Application

    @Singleton
    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideLocale(): Locale = Locale.getDefault()

        @Provides
        @Singleton
        @JvmStatic
        fun provideIOCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}