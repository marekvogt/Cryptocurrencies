package pl.marekvogt.cryptocurrency.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.ui.detail.CryptoCurrencyDetailsFragment
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyListFragment
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyListModule

@Module
interface FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [CryptoCurrencyListModule::class])
    fun bindCryptoCurrencyListFragment(): CryptoCurrencyListFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun bindCryptoCurrencyDetailsFragment(): CryptoCurrencyDetailsFragment
}