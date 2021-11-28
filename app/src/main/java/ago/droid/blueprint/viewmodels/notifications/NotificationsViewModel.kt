package ago.droid.blueprint.viewmodels.notifications

import ago.droid.blueprint.data.models.ComponentModel
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.repositories.ComponentRepository
import ago.droid.blueprint.domain.usecases.FetchComponentsUseCase
import ago.droid.blueprint.domain.usecases.FetchDCardsUseCase
import ago.droid.blueprint.pages.notifications.NotificationsFragment
import android.util.Log
import androidx.lifecycle.*
import androidx.paging.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationsViewModel @Inject constructor(
    private val fetchComponentsUseCase: FetchComponentsUseCase
) : ViewModel() {
    private val TAG = NotificationsViewModel::class.java.simpleName

    private var _components = MutableLiveData<PagingData<Component>>().apply {
        value = null
    }
    val components: MutableLiveData<PagingData<Component>> = MutableLiveData()

    init {
        loadData()
    }
    private fun loadData()  {
        try {
            val result = Pager(
                // Configure how data is loaded by passing additional properties to
                // PagingConfig, such as prefetchDistance.
                PagingConfig(pageSize = 20)
            ) {
                fetchComponentsUseCase(Unit)
            }.flow
                .cachedIn(viewModelScope)

            viewModelScope.launch {
                result.collect {
                    Log.i(TAG, "aaaaf: $it")
                    components.postValue(it.map { it1 -> Component(it1.text, it1.url) })
                }
            }
        } catch (e: Exception) {
            Log.i(TAG, "aaaaa: $e")
        }

    }
}