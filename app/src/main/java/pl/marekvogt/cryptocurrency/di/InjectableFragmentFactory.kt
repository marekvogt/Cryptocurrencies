package pl.marekvogt.cryptocurrency.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass


class InjectableFragmentFactory @Inject constructor(
    private val creator: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        return creator[fragmentClass]?.get() ?: super.instantiate(classLoader, className)
    }
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)