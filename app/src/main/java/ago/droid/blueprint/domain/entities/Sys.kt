package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class Sys (
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: Float,
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Float,
    @SerializedName("sunset")
    val sunset: Float
)