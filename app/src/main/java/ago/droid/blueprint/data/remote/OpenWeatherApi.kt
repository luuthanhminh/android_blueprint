package ago.droid.blueprint.data.remote

import ago.droid.blueprint.domain.entities.CityForecast
import ago.droid.blueprint.domain.entities.CityWeather
import io.reactivex.Observable
import retrofit2.http.*

interface OpenWeatherApi {
    @GET("weather")
    fun getWeather(@Query("q") q: String): Observable<CityWeather>

    @GET("forecast")
    fun getForecast(@Query("q") q: String): Observable<CityForecast>

//    @FormUrlEncoded
//    @POST("update-user-locatin")
//    fun configure(@Field("province_id") province_id: String): Call<String>
//
//    @Multipart
//    @POST("profile")
//    fun updateProfileV2(@Part filePart: MultipartBody.Part?,
//                        @Part("first_name") firstName: RequestBody
//    ): Call<String>
}