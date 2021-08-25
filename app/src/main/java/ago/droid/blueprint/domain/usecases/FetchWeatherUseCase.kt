package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.domain.entities.CityWeather
import ago.droid.blueprint.domain.repositories.WeatherRepository
import android.util.Log
import io.reactivex.Observable
import java.lang.Exception

class FetchWeatherUseCase constructor(private val weatherRepository: WeatherRepository) : BaseUseCase<Observable<CityWeather>, String>{
    override suspend fun invoke(param: String): Observable<CityWeather> {
        Log.d("BLUEPRINT", "BLUU" + "FetchWeatherUseCase")

        return weatherRepository.getWeather(param);
    }
}