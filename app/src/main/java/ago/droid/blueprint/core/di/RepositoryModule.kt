package ago.droid.blueprint.core.di

import ago.droid.blueprint.data.datasources.*
import ago.droid.blueprint.data.repositories.ComponentRepositoryImpl
import ago.droid.blueprint.data.repositories.DCardRepositoryImpl
import ago.droid.blueprint.domain.repositories.ComponentRepository
import ago.droid.blueprint.domain.repositories.DCardRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideDCardDataSource(dCardDataSourceImpl: DCardDataSourceImpl): DCardDataSource

    @Binds
    @Singleton
    abstract fun provideComponentDataSource(componentDataSourceImpl: ComponentDataSourceImpl): ComponentDataSource

    @Binds
    @Singleton
    abstract fun provideComponentApiSource(componentApiSourceImpl: ComponentApiSourceImpl): ComponentApiSource

    @Binds
    @Singleton
    abstract fun provideDCardRepository(dCardRepositoryImpl: DCardRepositoryImpl): DCardRepository

    @Binds
    @Singleton
    abstract fun provideComponentRepository(componentRepositoryImpl: ComponentRepositoryImpl): ComponentRepository

}