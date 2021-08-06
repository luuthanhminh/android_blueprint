package ago.droid.blueprint.viewmodels.home

import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.entities.DCard
import ago.droid.blueprint.domain.usecases.FetchDCardsUseCase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val fetchDCardsUseCase: FetchDCardsUseCase
) : ViewModel() {

    private var _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var _cards = MutableLiveData<List<DCard>>().apply {
        value = ArrayList()
    }
    val cards: LiveData<List<DCard>> = _cards

    init {
        loadData()
    }
    private fun loadData()  {
        viewModelScope.launch {
            val result = fetchDCardsUseCase(Unit)
            _cards.value = result;
        }

    }
}