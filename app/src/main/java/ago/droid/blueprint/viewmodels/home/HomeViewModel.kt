package ago.droid.blueprint.viewmodels.home

import ago.droid.blueprint.data.models.DCardModel
import ago.droid.blueprint.data.remote.WebApi
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.entities.DCard
import ago.droid.blueprint.domain.usecases.FetchDCardsUseCase
import ago.droid.blueprint.navigation.Navigator
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel @Inject constructor(
    private val fetchDCardsUseCase: FetchDCardsUseCase,
    private val navigator : Navigator
) : ViewModel() {

    private val TAG: String = HomeViewModel::class.java.simpleName
    private val _openTaskEvent = MutableLiveData<Unit>()
    val openTaskEvent: LiveData<Unit> = _openTaskEvent

    var cards: MutableLiveData<PagingData<DCard>> = MutableLiveData()// = _cards


    init {
        loadData()
    }
    private fun loadData() {

        try {
            val result = Pager(
                // Configure how data is loaded by passing additional properties to
                // PagingConfig, such as prefetchDistance.
                PagingConfig(pageSize = 20)
            ) {
                fetchDCardsUseCase(Unit)
            }.flow
                .cachedIn(viewModelScope)

            viewModelScope.launch {
                result.collect {
                    Log.i(TAG, "loadData: $it")
                    cards.postValue(it.map { it1 -> DCard(it1.header, it1.description, it1.images) })
                }
            }
        } catch (e: Exception) {
            Log.i(TAG, "aaaaa: $e")
        }

//        viewModelScope.launch {
//            val result = fetchDCardsUseCase(Unit)
//            Log.i(TAG, "loadData: $result")
//            cards = LivePagedListBuilder(result, pagedListConfig)
//                .build()
//        }
    }

    fun navigateToFragment(navId: Int, fragmentId:Int){
        navigator.navigateByNavController(navId, fragmentId)
    }

}