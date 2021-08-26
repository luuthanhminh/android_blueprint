package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import io.reactivex.Observable
import io.reactivex.Single

interface WeatherRepository {
    fun getWeather(q: String): Single<CityWeather>

    fun getForecast(q: String): Observable<CityForecast>

}