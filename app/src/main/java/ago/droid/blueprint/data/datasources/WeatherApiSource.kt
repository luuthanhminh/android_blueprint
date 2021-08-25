package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.remote.OpenWeatherApi
import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import android.util.Log
import io.reactivex.Observable
import javax.inject.Inject

interface WeatherApiSource {
    fun getWeather(q: String): Observable<CityWeather>
    fun getForecast(q: String): Observable<CityForecast>
}

class OpenWeatherApiSource @Inject constructor(
    private val openWeatherApi: OpenWeatherApi) : WeatherApiSource {
    override fun getWeather(q: String): Observable<CityWeather> {
        Log.d("BLUEPRINT", "BLUU" + "getWAPI")
        return openWeatherApi.getWeather(q)
    }

    override fun getForecast(q: String): Observable<CityForecast> {
        return openWeatherApi.getForecast(q)
    }

}