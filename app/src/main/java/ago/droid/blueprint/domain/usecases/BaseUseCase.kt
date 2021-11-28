package ago.droid.blueprint.domain.usecases

interface BaseUseCase<TResponse, TParam> {
    operator fun invoke(params: TParam) : TResponse
}