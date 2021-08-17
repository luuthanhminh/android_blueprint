package ago.droid.blueprint.pages

import ago.droid.blueprint.R
import ago.droid.blueprint.pages.base.BaseActivity
import android.app.Activity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications
        ))
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController: NavController = findNavController(R.id.nav_host_fragment);

        navView.setOnNavigationItemSelectedListener { menuItem ->
            navView.menu.findItem(menuItem.itemId).isChecked = true
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    navController.setGraph(R.navigation.mobile_navigation)
                    true

                }
                R.id.navigation_dashboard -> {
                    navController.setGraph(R.navigation.dashboard_navigation)
                    true

                }
                R.id.navigation_notifications -> {
                    navController.setGraph(R.navigation.notification_navigation)
                    true
                }
                R.id.navigation_account -> {

                }
            }
            false
        }
    }

}