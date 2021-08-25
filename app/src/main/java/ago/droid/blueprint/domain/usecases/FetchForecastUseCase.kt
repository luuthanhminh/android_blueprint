package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.repositories.WeatherRepository
import android.util.Log
import io.reactivex.Observable
import java.lang.Exception
import javax.inject.Inject

class FetchForecastUseCase constructor(private val weatherRepository: WeatherRepository) : BaseUseCase<Observable<CityForecast>, String>{
    override suspend fun invoke(param: String): Observable<CityForecast> {
        Log.d("BLUEPRINT", "BLUU" + "FetchForecastUseCase")

        return weatherRepository.getForecast(param);
    }
}