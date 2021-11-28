package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.data.models.DCardModel
import ago.droid.blueprint.domain.entities.DCard
import androidx.paging.DataSource
import androidx.paging.PagingSource

interface DCardRepository {
    fun getCards() : PagingSource<Int, DCardModel>
}