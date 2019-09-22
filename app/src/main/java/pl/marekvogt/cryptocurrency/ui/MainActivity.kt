package pl.marekvogt.cryptocurrency.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import pl.marekvogt.cryptocurrency.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
