package ago.droid.blueprint.data.repositories

import ago.droid.blueprint.data.datasources.DevicesDataSource
import ago.droid.blueprint.domain.entities.Device
import ago.droid.blueprint.domain.repositories.DeviceRepository
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(private val devicesDataSource: DevicesDataSource): DeviceRepository{
    override suspend fun getDevices(param: String): List<Device> {
        var list: List<Device> = emptyList();
        list = if(param.isNullOrBlank()){
            devicesDataSource.getDevices();
        } else {
            emptyList();
        }

        return list;
    }
}