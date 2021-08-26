package ago.droid.blueprint.data.repositories

import ago.droid.blueprint.data.datasources.WeatherApiSource
import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import ago.droid.blueprint.domain.repositories.WeatherRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApiSource: WeatherApiSource) : WeatherRepository {
    override fun getWeather(q: String): Single<CityWeather> {
        return weatherApiSource.getWeather(q);
    }

    override fun getForecast(q: String): Observable<CityForecast> {
        return weatherApiSource.getForecast(q);
    }
}