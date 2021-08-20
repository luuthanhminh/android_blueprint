package ago.droid.blueprint.core.di

import ago.droid.blueprint.navigation.Navigator
import ago.droid.blueprint.navigation.NavigatorImpl
import ago.droid.blueprint.services.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun provideAppLoggerService(localLoggerService: LocalLoggerService): AppLoggerService

    @Binds
    @Singleton
    abstract fun provideDownloadService(downloadServiceImpl: DownloadServiceImpl): DownloadService

    @Binds
    @Singleton
    abstract fun provideImageService(imageServiceImpl: ImageServiceImpl): ImageService
}