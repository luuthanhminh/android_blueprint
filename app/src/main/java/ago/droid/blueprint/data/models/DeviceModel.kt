package ago.droid.blueprint.data.models

import ago.droid.blueprint.domain.entities.Device

class DeviceModel(name: String, image: String, code: String, warrantyStatus: String ): Device( name, image, code, warrantyStatus ){
    public val isExpired: String = "";

}