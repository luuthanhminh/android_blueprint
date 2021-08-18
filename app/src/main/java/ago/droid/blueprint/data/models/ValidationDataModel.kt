package ago.droid.blueprint.data.models

import ago.droid.blueprint.domain.entities.ValidationData

class ValidationDataModel constructor(emailVerification: String, purchaseId: String, zipCode: String)
    : ValidationData(emailVerification, purchaseId, zipCode) {
}