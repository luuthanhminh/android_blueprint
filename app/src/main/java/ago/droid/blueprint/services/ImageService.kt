package ago.droid.blueprint.services

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import javax.inject.Inject

interface ImageService {
    fun cropImage(path: String, x: Int, y: Int, width: Int, height: Int) : Bitmap
}

class ImageServiceImpl @Inject constructor() : ImageService {
    override fun cropImage(path: String, x: Int, y: Int, width: Int, height: Int) : Bitmap {
        var bitmap: Bitmap = BitmapFactory.decodeFile(path)
        var cropImg = Bitmap.createBitmap(bitmap, x, y, width, height)
        
        return cropImg;
    }

}