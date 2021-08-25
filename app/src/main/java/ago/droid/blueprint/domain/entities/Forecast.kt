package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class Forecast (
    @SerializedName("dt")
    val dt: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("weather")
    val weathers: List<Weather>,
    @SerializedName("cloud")
    val cloud: Cloud,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("visibility")
    val visibility: String,
//    @SerializedName("pop")
//    val pop: Int,
    @SerializedName("rain")
    val rain: Rain,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("dt_txt")
    val dt_txt: String
)