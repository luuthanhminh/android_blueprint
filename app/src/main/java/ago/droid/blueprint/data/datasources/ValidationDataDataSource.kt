package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.ValidationDataModel
import kotlinx.coroutines.delay
import javax.inject.Inject

interface ValidationDataDataSource {
    suspend fun getValidationData(): List<ValidationDataModel>;
}

class ValidationDataDataSourceImpl @Inject constructor() : ValidationDataDataSource {
    override suspend fun getValidationData(): List<ValidationDataModel> {
        delay(2000L);
        return buildData();
    }

    private fun buildData(): List<ValidationDataModel> {
        var listValidationData = ArrayList<ValidationDataModel>()
        listValidationData.add(
            ValidationDataModel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ","https://www.google.com/", 67000)
        )

        return listValidationData
    }
}