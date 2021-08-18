package ago.droid.blueprint.core.di

import ago.droid.blueprint.MainApplication
import android.app.Activity
import android.app.Application
import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesApplication(): MainApplication = MainApplication.instance
}