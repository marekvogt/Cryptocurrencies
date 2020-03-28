package pl.marekvogt.cryptocurrency.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.ui.detail.CryptoCurrencyDetailsFragment
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyListFragment

@Module
interface FragmentFactoryModule {

    @Binds
    fun bindFragmentFactory(fragmentFactory: DaggerFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(CryptoCurrencyListFragment::class)
    fun bindCryptoCurrencyListFragment(fragment: CryptoCurrencyListFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(CryptoCurrencyDetailsFragment::class)
    fun bindCryptoCurrencyDetailsFragment(fragment: CryptoCurrencyDetailsFragment): Fragment
}