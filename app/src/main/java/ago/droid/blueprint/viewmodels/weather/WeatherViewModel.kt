package ago.droid.blueprint.viewmodels.weather

import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import ago.droid.blueprint.domain.repositories.WeatherRepository
import ago.droid.blueprint.domain.usecases.FetchForecastUseCase
import ago.droid.blueprint.domain.usecases.FetchWeatherUseCase
import ago.droid.blueprint.navigation.Navigator
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val navigator : Navigator

): ViewModel() {
    private var _weather = MutableLiveData<CityWeather>().apply {
        value = null
    }
    val weather: LiveData<CityWeather> = _weather

    init {
        Log.d("BLUEPRINT", "BLUU" + "VM")
        loadData()
    }
    private fun loadData()  {
        Log.d("BLUEPRINT", "BLUU" + "loadData")
        viewModelScope.launch {
            val getWeather = fetchWeatherUseCase("ho chi minh")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    Log.d("BLUEPRINT", "BLUUMAIN" + it.id?.toString())
                    _weather.value = it;
                }
                .subscribe {
                }
        }

    }

    fun navigateToFragment(navId: Int, fragmentId:Int){
        navigator.navigateByNavController(navId, fragmentId)
    }

}