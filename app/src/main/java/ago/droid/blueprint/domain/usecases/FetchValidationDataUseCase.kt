package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.domain.entities.ValidationData
import ago.droid.blueprint.domain.repositories.ComponentRepository
import ago.droid.blueprint.domain.repositories.ValidationDataRepository
import java.lang.Exception

class FetchValidationDataUseCase constructor(private val validationDataRepository: ValidationDataRepository): BaseUseCase<List<ValidationData>, Unit> {
    override suspend fun invoke(param: Unit): List<ValidationData> {
        var result: List<ValidationData> = emptyList();
        try {
            result = validationDataRepository.getValidationData();
        } catch (e: Exception) {

        }
        return result;
    }
}