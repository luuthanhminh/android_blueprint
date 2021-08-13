package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.domain.entities.Device
import ago.droid.blueprint.domain.repositories.DeviceRepository
import java.lang.Exception

class FetchDevicesUseCase constructor(private val deviceRepository: DeviceRepository) : BaseUseCase<List<Device>, String> {
//    private val repository: DeviceRepository = null;
//    constructor(repository: DeviceRepository) {
//
//    }

    override suspend fun invoke(param: String): List<Device> {
        var result: List<Device> = emptyList();

        try {
            result = deviceRepository.getDevices(param);
        }catch (e : Exception) {
            print(e?.message);
        }

        return result;
    }
}