package ago.droid.blueprint.core.di

import ago.droid.blueprint.pages.MainActivity
import ago.droid.blueprint.pages.account.AccountFragment
import ago.droid.blueprint.pages.home.HomeFragment
import ago.droid.blueprint.pages.notifications.NotificationsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, UseCaseModule::class, RetrofitModule::class, AppModule::class, ServiceModule::class])
interface  ApplicationComponent  {
    fun inject(target: HomeFragment)
    fun inject(target: NotificationsFragment)
    fun inject(target: MainActivity)
    fun inject(target: AccountFragment)
}

//// Definition of a custom scope called ActivityScope
//@Scope
//@Retention(value = AnnotationRetention.RUNTIME)
//annotation class ActivityScope