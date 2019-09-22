package pl.marekvogt.cryptocurrency

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.marekvogt.cryptocurrency.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}