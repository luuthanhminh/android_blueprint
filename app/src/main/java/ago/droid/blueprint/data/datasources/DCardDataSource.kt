package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.DCardModel
import kotlinx.coroutines.delay

interface DCardDataSource {
    suspend fun getCards(): List<DCardModel>;
}

class DCardDataSourceImpl : DCardDataSource {
    override suspend fun getCards(): List<DCardModel> {
        delay(2000L);
        return emptyList<DCardModel>();
    }

}