package ago.droid.blueprint.domain.usecases

import ago.droid.blueprint.data.models.DCardModel
import ago.droid.blueprint.domain.entities.DCard
import ago.droid.blueprint.domain.repositories.DCardRepository
import androidx.paging.DataSource
import androidx.paging.PagingSource
import java.lang.Exception
import javax.inject.Inject

class FetchDCardsUseCase constructor(private val dCardRepository: DCardRepository) : BaseUseCase<PagingSource<Int, DCardModel>, Unit>{

    override fun invoke(params: Unit): PagingSource<Int, DCardModel> {
        var result: PagingSource<Int, DCardModel>;
//        try {
            result = dCardRepository.getCards();
//
//        }catch (e: Exception){∂
//        }
        return result;
    }
}