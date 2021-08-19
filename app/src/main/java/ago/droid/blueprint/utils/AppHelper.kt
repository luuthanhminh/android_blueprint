package ago.droid.blueprint.utils

import ago.droid.blueprint.BuildConfig
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

fun isNumber(str: String): Boolean {
    return try {
        str.toFloat()
        true
    } catch (ex: NumberFormatException) {
        Log.i("BLUEPRINT LOG", "${ex.message}")

        false
    }
}