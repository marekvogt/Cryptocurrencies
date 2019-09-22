package pl.marekvogt.cryptocurrency.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.marekvogt.cryptocurrency.di.scope.ActivityScope
import pl.marekvogt.cryptocurrency.ui.MainActivity

@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}