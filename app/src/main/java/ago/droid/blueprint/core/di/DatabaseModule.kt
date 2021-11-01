package ago.droid.blueprint.core.di

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.data.database.BlueprintDatabase
import ago.droid.blueprint.data.database.dao.ComponentDao
import ago.droid.blueprint.data.database.dao.DCardDao
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesBlueprintDatabase(mainApplication: MainApplication): BlueprintDatabase
        = BlueprintDatabase.getInstance(mainApplication.applicationContext)

    @Singleton
    @Provides
    fun provideComponentDao(blueprintDatabase: BlueprintDatabase): ComponentDao {
        return blueprintDatabase.getComponentDao()
    }

    @Singleton
    @Provides
    fun provideDCardDao(blueprintDatabase: BlueprintDatabase): DCardDao {
        return blueprintDatabase.getDCardDao()
    }
}