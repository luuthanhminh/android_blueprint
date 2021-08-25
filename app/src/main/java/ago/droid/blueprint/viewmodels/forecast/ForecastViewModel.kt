package ago.droid.blueprint.viewmodels.forecast

import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import ago.droid.blueprint.domain.usecases.FetchForecastUseCase
import ago.droid.blueprint.domain.usecases.FetchWeatherUseCase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForecastViewModel @Inject constructor(
    private val fetchForecastUseCase: FetchForecastUseCase
): ViewModel() {

    private var _forecast = MutableLiveData<CityForecast>().apply {
        value = null
    }
    val forecast: LiveData<CityForecast> = _forecast

    init {
        Log.d("BLUEPRINT", "BLUU" + "VM")
        loadData()
    }

    private fun loadData() {
        Log.d("BLUEPRINT", "BLUU" + "loadData")
        viewModelScope.launch {
            val getWeather = fetchForecastUseCase("ho chi minh")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    Log.d("BLUEPRINT", "BLUUMAIN" + it.forecasts.size)
                    _forecast.value = it;
                }
                .subscribe {
                }
        }
    }

}