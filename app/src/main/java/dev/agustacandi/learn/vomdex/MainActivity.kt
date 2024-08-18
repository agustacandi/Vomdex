package dev.agustacandi.learn.vomdex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dev.agustacandi.learn.core.utils.ext.gone
import dev.agustacandi.learn.core.utils.ext.show
import dev.agustacandi.learn.vomdex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navigationDestination = listOf(R.id.homeFragment, R.id.searchFragment, R.id.aboutFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navHostBottomBar =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navControllerBottomBar = navHostBottomBar.navController

        with(binding) {
            mainBottomNavigation.setupWithNavController(navControllerBottomBar)
            navControllerBottomBar.addOnDestinationChangedListener { _, destination, _ ->
                if (navigationDestination.contains(destination.id)) {
                    mainBottomNavigation.show()
                } else {
                    mainBottomNavigation.gone()
                }
            }
        }
    }
}