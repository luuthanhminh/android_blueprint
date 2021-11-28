package ago.droid.blueprint.data.repositories

import ago.droid.blueprint.data.datasources.ComponentApiSource
import ago.droid.blueprint.data.datasources.ComponentDataSource
import ago.droid.blueprint.data.models.ComponentModel
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.repositories.ComponentRepository
import ago.droid.blueprint.domain.usecases.FetchComponentsUseCase
import android.util.Log
import androidx.paging.PagingSource
import javax.inject.Inject

class ComponentRepositoryImpl @Inject constructor(private val componentDataSource: ComponentDataSource) : ComponentRepository {
    private val TAG = ComponentRepositoryImpl::class.java.simpleName

    override fun getComponents(): PagingSource<Int, ComponentModel> {
        val result = componentDataSource.getComponents()
        Log.i(TAG, "aaaa: $result")

        return result;
    }
}