package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.domain.entities.Device

interface DeviceRepository {
    suspend fun getDevices(param: String = "") : List<Device>
}