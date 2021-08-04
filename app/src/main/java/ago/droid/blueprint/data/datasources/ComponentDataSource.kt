package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.ComponentModel
import kotlinx.coroutines.delay
import javax.inject.Inject

interface ComponentDataSource {
    suspend fun getComponents(): List<ComponentModel>;
}

class ComponentDataSourceImpl @Inject constructor() : ComponentDataSource {
    override suspend fun getComponents(): List<ComponentModel> {
        delay(2000L);
        return emptyList<ComponentModel>();
    }

}