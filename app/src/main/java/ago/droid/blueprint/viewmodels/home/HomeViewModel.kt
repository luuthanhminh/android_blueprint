package ago.droid.blueprint.viewmodels.home

import ago.droid.blueprint.data.remote.WebApi
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.entities.DCard
import ago.droid.blueprint.domain.entities.ValidationData
import ago.droid.blueprint.domain.usecases.FetchDCardsUseCase
import ago.droid.blueprint.domain.usecases.FetchValidationDataUseCase
import ago.droid.blueprint.navigation.Navigator
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel @Inject constructor(
    private val fetchDCardsUseCase: FetchDCardsUseCase,
    private val navigator : Navigator
) : ViewModel() {

    private val _openTaskEvent = MutableLiveData<Unit>()
    val openTaskEvent: LiveData<Unit> = _openTaskEvent

    private var _cards = MutableLiveData<List<DCard>>().apply {
        value = ArrayList()
    }
    val cards: LiveData<List<DCard>> = _cards

    init {
        loadData()
    }
    private fun loadData()  {
        viewModelScope.launch {
            val cardResult = fetchDCardsUseCase(Unit)
            _cards.value = cardResult;
        }
    }

    fun navigateToFragment(navId: Int, fragmentId:Int){
        navigator.navigateByNavController(navId, fragmentId)
    }

}