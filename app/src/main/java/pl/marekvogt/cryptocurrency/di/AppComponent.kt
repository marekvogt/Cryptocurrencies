package pl.marekvogt.cryptocurrency.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import pl.marekvogt.cryptocurrency.App
import pl.marekvogt.cryptocurrency.data.DataModule
import pl.marekvogt.cryptocurrency.data.network.NetworkModule
import pl.marekvogt.cryptocurrency.ui.common.UiModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    FragmentModule::class,
    ViewModelFactoryModule::class,
    NetworkModule::class,
    DataModule::class,
    UiModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}