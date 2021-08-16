package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.models.ComponentModel
import ago.droid.blueprint.data.remote.WebApi
import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import javax.inject.Inject


interface ComponentApiSource {
    suspend fun getComponents(): List<ComponentModel>;
}

class ComponentApiSourceImpl @Inject constructor(private val webApi: WebApi) : ComponentApiSource {
    override suspend fun getComponents(): List<ComponentModel> {

        val deferred = CoroutineScope(Dispatchers.IO).async {
             webApi.getPeopleAsync()
        }
        var data = deferred.await()
        Log.d("getPeopleAsync:", data.size.toString())


        val disposables = CompositeDisposable()
        disposables.add(webApi.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {Log.d("doOnSubscribe", "Loading")}
            .doFinally { Log.d("doOnSubscribe", "Loading")}
            .subscribe(
                {

                },{

                }
            ))
        
        return ArrayList()
        /*webApi.getPeople().enqueue(object :Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {

            }

            override fun onFailure(call: Call<String>, t: Throwable) {

            }

        })*/

    }
}