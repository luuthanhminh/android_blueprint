package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.data.models.ComponentModel
import ago.droid.blueprint.domain.entities.Component
import androidx.paging.PagingSource

interface ComponentRepository {
    fun getComponents() : PagingSource<Int, ComponentModel>
}