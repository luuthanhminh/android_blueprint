package ago.droid.blueprint.viewmodels.account

import ago.droid.blueprint.services.DownloadService
import ago.droid.blueprint.services.ImageService
import android.graphics.Bitmap
import android.os.Environment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    private val downloadService: DownloadService,
    private val imageService: ImageService
    ) : ViewModel() {

    suspend fun downloadImageSquare(activity: FragmentActivity, url: String, width: Int) : Bitmap {
        var path = "";
        runBlocking {
             path = downloadService.downloadImage(activity, url)
        }

        return imageService.cropImage(path, 0, 0, width, width);
    }
}