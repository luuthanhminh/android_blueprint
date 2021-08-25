package ago.droid.blueprint.pages.forecast

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.R
import ago.droid.blueprint.adapters.ForecastAdapter
import ago.droid.blueprint.adapters.HomeAdapter
import ago.droid.blueprint.viewmodels.forecast.ForecastViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class ForecastFragment : Fragment() {

    @Inject
    lateinit var forecastViewModel: ForecastViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).appComponent.inject(this)

        val root = inflater.inflate(R.layout.fragment_forecast, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("BLUEPRINT", "BLUU" + "WAO")

         val lvForecast: RecyclerView = view.findViewById(R.id.lvForecast)
         lvForecast.layoutManager = LinearLayoutManager(activity?.applicationContext)

         forecastViewModel.forecast.observe(viewLifecycleOwner, Observer {


             when(it){
                 null -> {}
                 else -> {
                     var adapter = activity?.let { it1 -> ForecastAdapter(it.forecasts, it1.applicationContext) }
                     lvForecast.adapter = adapter
                 }
             }

         })



    }
}