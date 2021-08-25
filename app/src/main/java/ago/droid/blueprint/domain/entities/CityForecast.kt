package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class CityForecast (
    @SerializedName("list")
    val forecasts: List<Forecast>,
    @SerializedName("city")
    val city: City
)