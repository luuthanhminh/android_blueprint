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
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import kotlinx.coroutines.*
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

//    private var _cards = MutableLiveData<PagedList<DCardModel>>().apply {
//        value = emptyList()
//    }
    lateinit var cards: LiveData<PagedList<DCard>>// = _cards
    val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(5).build()

    init {
        loadData()
    }
    private fun loadData() {
        viewModelScope.launch {
            val result = fetchDCardsUseCase(Unit)
            Log.i(TAG, "loadData: $result")
            cards = LivePagedListBuilder(result, pagedListConfig)
                .build()
        }
    }

    fun navigateToFragment(navId: Int, fragmentId:Int){
        navigator.navigateByNavController(navId, fragmentId)
    }

}