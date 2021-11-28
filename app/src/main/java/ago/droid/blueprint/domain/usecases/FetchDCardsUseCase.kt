package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.data.models.DCardModel
import ago.droid.blueprint.domain.entities.DCard
import ago.droid.blueprint.domain.repositories.DCardRepository
import androidx.paging.DataSource
import java.lang.Exception
import javax.inject.Inject

class FetchDCardsUseCase constructor(private val dCardRepository: DCardRepository) : BaseUseCase<DataSource.Factory<Int, DCard>, Unit>{

    override fun invoke(params: Unit): DataSource.Factory<Int, DCard> {
        var result: DataSource.Factory<Int, DCard>;
//        try {
            result = dCardRepository.getCards();
//
//        }catch (e: Exception){∂
//        }
        return result;
    }
}