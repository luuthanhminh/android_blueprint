package ago.droid.blueprint.pages

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.R
import ago.droid.blueprint.databinding.ActivityMainBinding
import ago.droid.blueprint.databinding.FragmentHomeBinding
import ago.droid.blueprint.pages.base.BaseActivity
import ago.droid.blueprint.utils.isNumber
import ago.droid.blueprint.viewmodels.main.MainViewModel
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.view.forEach
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(
            layoutInflater
        )

        binding.homeGraphId = R.navigation.mobile_navigation
        binding.dashboardGraphId = R.id.dashboard_navigation
        binding.notifyGraphId = R.navigation.notification_navigation
//        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)


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
        (application as MainApplication).appComponent.inject(this)



        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController: NavController = findNavController(R.id.nav_host_fragment);
        Log.i("BLUEPRINT LOG", "init")

        mainViewModel.listValidationData.observe(this, Observer { it ->

            when( it.size!! > 0 && !it[0]?.emailVerification?.isNullOrBlank() &&
                    it[0]?.purchaseId?.length == 13 && isNumber(it[0]?.purchaseId) &&
                    !it[0]?.zipCode?.isNullOrBlank() ) {


                true -> navView.menu.forEach { itm -> itm.isEnabled = true }
                else -> navView.menu.forEach { itm -> itm.isEnabled = false }

            }
        })

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

    @BindingAdapter("onNavigationItemSelected")
    public fun setOnNavigationItemSelected(
        navView: BottomNavigationView,
        listener: BottomNavigationView
    ) {
        navView.setOnNavigationItemSelectedListener { menuItem ->
            navView.menu.findItem(menuItem.itemId).isChecked = true
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    R.navigation.mobile_navigation

                }
                R.id.navigation_dashboard -> {
                    R.navigation.dashboard_navigation

                }
                R.id.navigation_notifications -> {
                    R.navigation.notification_navigation
                }
                R.id.navigation_account -> {

                }
            }
            false
        }
    }
}