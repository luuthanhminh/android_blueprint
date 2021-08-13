package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.DeviceModel
import kotlinx.coroutines.delay
import javax.inject.Inject

interface DevicesDataSource {
   suspend fun getDevices() : List<DeviceModel>;

}

class DeviceDataSourceImpl @Inject constructor() : DevicesDataSource {
    override suspend fun getDevices(): List<DeviceModel> {
        var result: ArrayList<DeviceModel> = ArrayList();

        result.add(DeviceModel("Macbook M1", "https://i.imgur.com/dEp3rQF.jpeg", "MMMMM", "Active Wanrranty"));
        result.add(DeviceModel("Macbook M1s", "https://i.imgur.com/dEp3rQF.jpeg", "SSSSS", "Active Wanrranty"));
        result.add(DeviceModel("DELL XPS", "https://i.imgur.com/jml6UJE.jpeg", "XPSXSPX", "Active Wanrranty"));

        return result;
    }
}

//class DeviceDataSourceApiImpl @Inject constructor() : DevicesDataSource {
//    override suspend fun getDevices(): List<DeviceModel> {
//        var result: ArrayList<DeviceModel> = ArrayList();
//        delay(2000L);
//
//        result.add(DeviceModel("Macbook M1(ONLINE)", "https://imgur.com/a/d5Qm29R", "MMMMM", "Active Wanrranty"));
//        result.add(DeviceModel("Macbook M1s(ONLINE)", "https://imgur.com/a/d5Qm29R", "SSSSS", "Active Wanrranty"));
//        result.add(DeviceModel("DELL XPS(ONLINE)", "https://imgur.com/a/d5Qm29R", "XPSXSPX", "Active Wanrranty"));
//
//        return result;
//    }
//}