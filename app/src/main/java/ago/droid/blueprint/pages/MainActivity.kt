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
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var mainViewModel: MainViewModel
//    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).appComponent.inject(this)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(
            layoutInflater
        )

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_home,
//            R.id.navigation_dashboard,
//            R.id.navigation_notifications
//        ))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController)

        mainViewModel.listValidationData.observe(this, Observer { it ->

            when( it.size!! > 0 && !it[0]?.emailVerification?.isNullOrBlank() &&
                    it[0]?.purchaseId?.length == 13 && isNumber(it[0]?.purchaseId) &&
                    !it[0]?.zipCode?.isNullOrBlank() ) {


                true -> navView.menu.forEach { itm -> itm.isEnabled = true }
                else -> navView.menu.forEach { itm -> itm.isEnabled = false }

            }
        })
    }

}