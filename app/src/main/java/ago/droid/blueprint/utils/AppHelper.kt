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

const val TAG = "BLUEPRINT LOG";

fun myLog(str: String) {
    var firebaseAnalytics: FirebaseAnalytics = Firebase.analytics
    if(BuildConfig.DEBUG) {
        Log.i(TAG, str);
    } else {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.ITEM_NAME, str)
        }
    }


//    firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM) {
//        param(FirebaseAnalytics.Param.ITEM_NAME, it[0].emailVerification)
//        param(FirebaseAnalytics.Param.ITEM_ID, it[0].purchaseId)
//        param(FirebaseAnalytics.Param.CONTENT, it[0].zipCode)
//    }
}