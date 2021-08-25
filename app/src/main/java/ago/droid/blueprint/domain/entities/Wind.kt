package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class Wind (
    @SerializedName("speed")
    val speed: Float,
    @SerializedName("deg")
    val deg: Int
)