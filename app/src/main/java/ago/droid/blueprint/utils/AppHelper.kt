package ago.droid.blueprint.utils

import android.util.Log

fun isNumber(str: String): Boolean {
    return try {
        str.toFloat()
        true
    } catch (ex: NumberFormatException) {
        Log.i("BLUEPRINT LOG", "${ex.message}")

        false
    }
}