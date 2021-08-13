package ago.droid.blueprint.viewmodels.dashboard2


import ago.droid.blueprint.domain.entities.Device
import ago.droid.blueprint.domain.usecases.FetchDevicesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Dashboard2ViewModel @Inject constructor(
    private val fetchDevicesUseCase: FetchDevicesUseCase
) : ViewModel() {

    private var _devices = MutableLiveData<List<Device>>().apply {
        value = ArrayList<Device>()
    }
    val devices: LiveData<List<Device>> = _devices

    init {
        loadData()
    }
    private fun loadData()  {
        viewModelScope.launch {
            val result = fetchDevicesUseCase("");
            _devices.value = result
        }

    }
}