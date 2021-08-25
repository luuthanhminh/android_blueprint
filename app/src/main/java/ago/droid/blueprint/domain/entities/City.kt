package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class City (
    @SerializedName("id")
    val id: Float,
    @SerializedName("name")
    val name: String,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("country")
    val country: String,
    @SerializedName("population")
    val population: Float,
    @SerializedName("timezone")
    val timezone: Float,
    @SerializedName("sunrise")
    val sunrise: Float,
    @SerializedName("sunset")
    val sunset: Float
)