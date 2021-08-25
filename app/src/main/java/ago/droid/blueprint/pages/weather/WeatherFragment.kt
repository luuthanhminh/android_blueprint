package ago.droid.blueprint.pages.weather

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.R
import ago.droid.blueprint.databinding.FragmentHomeBinding
import ago.droid.blueprint.databinding.FragmentWeatherBinding
import ago.droid.blueprint.viewmodels.weather.WeatherViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class WeatherFragment : Fragment() {

    @Inject
    lateinit var weatherViewModel: WeatherViewModel

//    @Inject
//    lateinit var weatherRepository: WeatherRepository


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).appComponent.inject(this)
//        activity.let {
//            val navView: BottomNavigationView? = it?.findViewById(R.id.nav_view)
//            navView?.visibility = View.GONE
//
//            val navController = it?.findNavController(R.id.nav_host_fragment)
//
//            if (navController != null) {
//                navView?.setupWithNavController(navController)
//            }
//
//        }

        var binding: FragmentWeatherBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather,
            container,
            false
        )

        binding.forecastId = R.id.navigation_forecast
        binding.weatherViewModel = weatherViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("BLUEPRINT", "BLUU" + "WAO")

        val txtWeatherCity: TextView = view.findViewById(R.id.txtWeatherCity)
        val txtTemperatureMain: TextView = view.findViewById(R.id.txtTemperatureMain)
        val txtHumidity: TextView = view.findViewById(R.id.txtHumidity)
        val txtmmWater: TextView = view.findViewById(R.id.txtmmWater)
        val txtHeat: TextView = view.findViewById(R.id.txtHeat)
        val txtWindSpeed: TextView = view.findViewById(R.id.txtWindSpeed)
        val txtDirection: TextView = view.findViewById(R.id.txtDirection)

        weatherViewModel.weather.observe(viewLifecycleOwner, Observer {
//            var adapter = activity?.let { it1 -> ComponentAdapter(it, it1.applicationContext) }

            when(it) {
                null -> {
                }
                else -> {
                    txtWeatherCity.text = it.name
                    txtTemperatureMain.text = "${it?.main?.temp}°F"
                    txtHumidity.text = "${it?.cloud?.all}"
//                    txtmmWater.text = it?.rain
                    txtHeat.text = "${it?.main?.pressure}"
                    txtWindSpeed.text = "${it?.wind?.speed}"
                    txtDirection.text = "${it?.wind?.deg}"
                }
            }
        })
    }
}