package pl.marekvogt.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLocale(): Locale = Locale.getDefault()

    @Provides
    @Singleton
    fun provideIOCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}