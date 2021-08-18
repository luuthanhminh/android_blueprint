package ago.droid.blueprint.pages

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.R
import ago.droid.blueprint.pages.base.BaseActivity
import ago.droid.blueprint.utils.isNumber
import ago.droid.blueprint.viewmodels.main.MainViewModel
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

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
        (application as MainApplication).appComponent.inject(this)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController: NavController = findNavController(R.id.nav_host_fragment);
        Log.i("BLUEPRINT LOG", "init")

        mainViewModel.listValidationData.observe(this, Observer { it ->
            if(it.size!! > 0) {
                Log.i("BLUEPRINT LOG",
                    "${it.size!! > 0} " +
                            "${it?.get(0)?.emailVerification?.isNullOrBlank()} " +
                            "${it?.get(0)?.purchaseId?.length == 13} ${isNumber(it[0]?.purchaseId)} " +
                            "${it?.get(0)?.zipCode?.isNullOrBlank()}"
                )

                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM) {
                    param(FirebaseAnalytics.Param.ITEM_NAME, it[0].emailVerification)
                    param(FirebaseAnalytics.Param.ITEM_ID, it[0].purchaseId)
                    param(FirebaseAnalytics.Param.CONTENT, it[0].zipCode)
                }
            }

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

    override fun onStart() {
        super.onStart()

    }

}