package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.domain.entities.Component

interface ComponentRepository {
    suspend fun getComponents() : List<Component>
}