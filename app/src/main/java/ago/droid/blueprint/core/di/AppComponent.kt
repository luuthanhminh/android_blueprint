package ago.droid.blueprint.core.di

import ago.droid.blueprint.pages.dashboard2.Dashboard2Fragment
import ago.droid.blueprint.pages.home.HomeFragment
import ago.droid.blueprint.pages.notifications.NotificationsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, UseCaseModule::class, RetrofitModule::class, AppModule::class])
interface  ApplicationComponent  {
    fun inject(target: HomeFragment)
    fun inject(target: NotificationsFragment)
    fun inject(target: Dashboard2Fragment)
}

//// Definition of a custom scope called ActivityScope
//@Scope
//@Retention(value = AnnotationRetention.RUNTIME)
//annotation class ActivityScope