package ago.droid.blueprint.domain.repositories

import ago.droid.blueprint.domain.entities.ValidationData

interface ValidationDataRepository {
    suspend fun getValidationData() : List<ValidationData>
}