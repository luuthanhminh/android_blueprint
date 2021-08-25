package ago.droid.blueprint.core.di

import ago.droid.blueprint.data.remote.OpenWeatherApi
import ago.droid.blueprint.data.remote.WebApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    //region Main API
    @Singleton
    @Provides
    @Named("retrofit_main")
    fun provideRetrofit(@Named("ohc_main") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://5e510330f2c0d300147c034c.mockapi.io/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(@Named("retrofit_main") retrofit: Retrofit): WebApi {
        return retrofit.create(WebApi::class.java)
    }

    @Singleton
    @Provides
    @Named("ohc_main")
    fun provideOkHttpClient(
        @Named("interceptors_main") interceptors: ArrayList<Interceptor>
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }


    @Singleton
    @Provides
    @Named("interceptors_main")
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        interceptors.add(loggingInterceptor)
        val herderInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("authentication-token", "token")
                .header("language", "vi")
                .build()
            request.let { req ->
                chain.proceed(req)
            }
        }
        interceptors.add(herderInterceptor)
        return interceptors
    }
    //endregion

    //region Open Weather API
    @Singleton
    @Provides
    @Named("retrofit_open_weather")
    fun provideRetrofitOpenWeather(@Named("ohc_open_weather") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://community-open-weather-map.p.rapidapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiOpenWeather(@Named("retrofit_open_weather") retrofit: Retrofit): OpenWeatherApi {
        return retrofit.create(OpenWeatherApi::class.java)
    }

    @Singleton
    @Provides
    @Named("ohc_open_weather")
    fun provideOkHttpClientOpenWeather(
        @Named("interceptors_open_weather") interceptors: ArrayList<Interceptor>
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }


    @Singleton
    @Provides
    @Named("interceptors_open_weather")
    fun provideInterceptorsOpenWeather(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        interceptors.add(loggingInterceptor)
        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .header("x-rapidapi-key", "418af48c7bmshfd42286e56aede1p1b6c5ajsn20e7fd9103fc")
                .build()
            request.let { req ->
                chain.proceed(req)
            }
        }
        interceptors.add(headerInterceptor)
        return interceptors
    }

    //endregion
}