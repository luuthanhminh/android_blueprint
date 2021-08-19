package ago.droid.blueprint.services

import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import javax.inject.Inject

interface AppLoggerService {

    fun logNavigation(screenName: String)
}

class LocalLoggerService @Inject constructor() : AppLoggerService {
    private val navigationTag = "Blueprint Navigation"

    override fun logNavigation(screenName: String) {
        Log.i(navigationTag, "Navigating $screenName");
    }

}

class FirebaseLoggerService @Inject constructor(private val firebaseAnalytics: FirebaseAnalytics) : AppLoggerService {

    override fun logNavigation(screenName: String) {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.ITEM_NAME, screenName)
        }
    }

}