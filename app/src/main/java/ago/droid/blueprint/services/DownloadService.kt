package ago.droid.blueprint.services

import android.app.DownloadManager
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import kotlinx.coroutines.runBlocking
import java.io.File
import javax.inject.Inject

interface DownloadService {
    suspend fun downloadImage(activity: FragmentActivity, url: String) : String
}

class DownloadServiceImpl @Inject constructor() : DownloadService {

    var msg: String? = ""
    var lastMsg = ""

    override suspend fun downloadImage(activity: FragmentActivity, url: String): String {

        val directory = File(Environment.DIRECTORY_PICTURES)
        if (!directory.exists()) {
            directory.mkdirs()
        }
        val fileName = url.substring(url.lastIndexOf("/") + 1)

        var downloadedPath: String = directory.absolutePath + File.separator + fileName

        val downloadManager = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadUri = Uri.parse(url)
        val request = DownloadManager.Request(downloadUri).apply {
            setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false)
                .setTitle(fileName)
                .setDescription("")
                .setDestinationInExternalPublicDir(
                    directory.toString(),
                    fileName
                )
        }

        val downloadId = downloadManager.enqueue(request)
        val query = DownloadManager.Query().setFilterById(downloadId)
        return runBlocking {
            var downloading = true
            while (downloading) {
                val cursor: Cursor = downloadManager.query(query)
                cursor.moveToFirst()
                if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                    downloading = false

                }
                val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                msg = statusMessage(url, directory, status)
                if (msg != lastMsg) {
                    activity?.runOnUiThread {
                        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
                    }
                    lastMsg = msg ?: ""
                }

                cursor.close()
            }
            return@runBlocking downloadedPath;
        }
    }

    private fun statusMessage(url: String, directory: File, status: Int): String? {
        var msg = ""
        msg = when (status) {
            DownloadManager.STATUS_FAILED -> "Download has been failed, please try again"
            DownloadManager.STATUS_PAUSED -> "Paused"
            DownloadManager.STATUS_PENDING -> "Pending"
            DownloadManager.STATUS_RUNNING -> "Downloading..."
            DownloadManager.STATUS_SUCCESSFUL -> "Image downloaded successfully in $directory" + File.separator + url.substring(
                url.lastIndexOf("/") + 1
            )
            else -> "There's nothing to download"
        }
        return msg
    }

}