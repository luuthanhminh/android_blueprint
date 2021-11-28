package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.data.models.ComponentModel
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.repositories.ComponentRepository
import ago.droid.blueprint.viewmodels.notifications.NotificationsViewModel
import android.util.Log
import androidx.paging.DataSource
import androidx.paging.PagingSource
import java.lang.Exception
import javax.inject.Inject

class FetchComponentsUseCase constructor(private val componentRepository: ComponentRepository)
    : BaseUseCase<PagingSource<Int, ComponentModel>, Unit>{
    private val TAG = FetchComponentsUseCase::class.java.simpleName

    override fun invoke(params: Unit): PagingSource<Int, ComponentModel> {
        var result : PagingSource<Int, ComponentModel>;//= emptyList<Component>();
//        try {
            result = componentRepository.getComponents();
//        }catch (e: Exception){
//
//        }
        Log.i(TAG, "aaaa: $result")

        return result;
    }

}