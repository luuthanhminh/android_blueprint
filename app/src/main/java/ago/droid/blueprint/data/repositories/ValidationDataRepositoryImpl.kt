package ago.droid.blueprint.data.repositories

import ago.droid.blueprint.data.datasources.ValidationDataDataSource
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.entities.ValidationData
import ago.droid.blueprint.domain.repositories.ValidationDataRepository
import javax.inject.Inject

class ValidationDataRepositoryImpl @Inject constructor(private val validationDataDataSource: ValidationDataDataSource): ValidationDataRepository {
    override suspend fun getValidationData(): List<ValidationData> {
        val result = validationDataDataSource.getValidationData()
        return result.map { it -> ValidationData(it.emailVerification, it.purchaseId, it.zipCode) };
    }

}