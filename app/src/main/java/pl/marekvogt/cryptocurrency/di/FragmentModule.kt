package pl.marekvogt.cryptocurrency.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.ui.detail.CryptoCurrencyDetailsFragment
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyListFragment

@Module
interface FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeCryptoCurrencyListFragment(): CryptoCurrencyListFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeCryptoCurrencyDetailsFragment(): CryptoCurrencyDetailsFragment
}