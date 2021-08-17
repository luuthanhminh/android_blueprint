package ago.droid.blueprint.viewmodels.main

import ago.droid.blueprint.domain.entities.ValidationData
import ago.droid.blueprint.domain.usecases.FetchValidationDataUseCase
import ago.droid.blueprint.navigation.Navigator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(
    private val fetchValidationDataUseCase: FetchValidationDataUseCase,
    private val navigator : Navigator

) : ViewModel() {

    private var _listValidationData = MutableLiveData<List<ValidationData>>().apply {
        value = ArrayList<ValidationData>()
    }
    val listValidationData: LiveData<List<ValidationData>> = _listValidationData

    init {
        loadData()
    }
    private fun loadData()  {
        viewModelScope.launch {
            val result = fetchValidationDataUseCase(Unit)
            _listValidationData.value = result
        }
    }

    fun navigateToFragment(navId: Int, fragmentId:Int){
        navigator.navigateByNavController(navId, fragmentId)
    }
}