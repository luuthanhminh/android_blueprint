package ago.droid.blueprint.core.di

import ago.droid.blueprint.pages.home.HomeFragment
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, UseCaseModule::class])
interface  ApplicationComponent  {
    fun inject(target: HomeFragment)
}

//// Definition of a custom scope called ActivityScope
//@Scope
//@Retention(value = AnnotationRetention.RUNTIME)
//annotation class ActivityScope