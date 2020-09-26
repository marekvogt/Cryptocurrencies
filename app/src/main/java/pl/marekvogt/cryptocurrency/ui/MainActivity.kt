package pl.marekvogt.cryptocurrency.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import kotlinx.android.synthetic.main.main_activity.*
import pl.marekvogt.cryptocurrency.R


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface MainActivityEntryPoint {
        val fragmentFactory: FragmentFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val entryPoint = EntryPointAccessors.fromActivity(this, MainActivityEntryPoint::class.java)
        supportFragmentManager.fragmentFactory = entryPoint.fragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController = (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean = navigateUp(navController, appBarConfiguration)
}
