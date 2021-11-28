package ago.droid.blueprint.data.repositories

import ago.droid.blueprint.data.datasources.DCardDataSource
import ago.droid.blueprint.data.models.DCardModel
import ago.droid.blueprint.domain.entities.DCard
import ago.droid.blueprint.domain.repositories.DCardRepository
import androidx.paging.DataSource
import androidx.paging.PagingSource
import javax.inject.Inject

class DCardRepositoryImpl @Inject constructor(private val dCardDataSource: DCardDataSource) : DCardRepository {
    override fun getCards(): PagingSource<Int, DCardModel> {
        return dCardDataSource.getCards()
    }

}