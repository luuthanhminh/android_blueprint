package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.ValidationDataModel
import kotlinx.coroutines.delay
import javax.inject.Inject

interface ValidationDataDataSource {
    suspend fun getValidationData(): List<ValidationDataModel>;
}

class ValidationDataDataSourceImpl @Inject constructor() : ValidationDataDataSource {
    override suspend fun getValidationData(): List<ValidationDataModel> {
        delay(5000L);
        return buildData();
    }

    private fun buildData(): List<ValidationDataModel> {
        var listValidationData = ArrayList<ValidationDataModel>()
        listValidationData.add(
            ValidationDataModel("Lorem ipsum dolor sit amet","1234567890123", "67000")
        )
//        listValidationData.add(
//            ValidationDataModel("Lorem ipsum dolor sit amet,","abc", "")
//        )

        return listValidationData
    }
}