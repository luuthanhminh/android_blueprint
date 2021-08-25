package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class CityWeather (
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("weather")
    val weathers: List<Weather>,
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("wind")
    val wind: Wind,
//    @SerializedName("rain")
//    val rain: Rain,
    @SerializedName("clouds")
    val cloud: Cloud,
    @SerializedName("dt")
    val dt: String,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: Float,
    @SerializedName("id")
    val id: Float,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val cod: Int
)