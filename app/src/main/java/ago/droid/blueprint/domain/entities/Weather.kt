package ago.droid.blueprint.domain.entities

import com.google.gson.annotations.SerializedName

class Weather (
    @SerializedName("id")
    val id: Float,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)