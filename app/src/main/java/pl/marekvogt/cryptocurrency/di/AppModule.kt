package pl.marekvogt.cryptocurrency.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import pl.marekvogt.cryptocurrency.App
import java.util.*
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindApplication(app: App): Application

    @Singleton
    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideLocale(): Locale = Locale.getDefault()
    }
}