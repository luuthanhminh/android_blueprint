package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import io.reactivex.Observable

interface WeatherRepository {
    fun getWeather(q: String): Observable<CityWeather>

    fun getForecast(q: String): Observable<CityForecast>

}