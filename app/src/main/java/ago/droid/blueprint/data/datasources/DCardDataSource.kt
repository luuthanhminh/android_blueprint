package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.DCardModel
import kotlinx.coroutines.delay
import javax.inject.Inject

interface DCardDataSource {
    suspend fun getCards(): List<DCardModel>;
}

class DCardDataSourceImpl @Inject constructor() : DCardDataSource {
    override suspend fun getCards(): List<DCardModel> {
        delay(2000L);
        return emptyList<DCardModel>();
    }

}