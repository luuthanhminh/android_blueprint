package ago.droid.blueprint.core.di

import ago.droid.blueprint.navigation.Navigator
import ago.droid.blueprint.navigation.NavigatorImpl
import ago.droid.blueprint.services.AppLoggerService
import ago.droid.blueprint.services.LocalLoggerService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun provideAppLoggerService(localLoggerService: LocalLoggerService): AppLoggerService
}