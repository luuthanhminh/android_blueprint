package ago.droid.blueprint.core.di

import ago.droid.blueprint.domain.repositories.ComponentRepository
import ago.droid.blueprint.domain.repositories.DCardRepository
import ago.droid.blueprint.domain.repositories.ValidationDataRepository
import ago.droid.blueprint.domain.repositories.WeatherRepository
import ago.droid.blueprint.domain.usecases.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideFetchDCardUseCase(dCardRepository: DCardRepository) : FetchDCardsUseCase = FetchDCardsUseCase(dCardRepository)

    @Provides
    @Singleton
    fun provideFetchComponentUseCase(componentRepository: ComponentRepository) : FetchComponentsUseCase = FetchComponentsUseCase(componentRepository)

    @Provides
    @Singleton
    fun provideFetchValidationDataUseCase(validationDataRepository: ValidationDataRepository) : FetchValidationDataUseCase = FetchValidationDataUseCase(validationDataRepository)

    @Provides
    @Singleton
    fun provideFetchWeatherUseCase(weatherRepository: WeatherRepository) : FetchWeatherUseCase = FetchWeatherUseCase(weatherRepository)

    @Provides
    @Singleton
    fun provideFetchForecastUseCase(weatherRepository: WeatherRepository) : FetchForecastUseCase = FetchForecastUseCase(weatherRepository)
}