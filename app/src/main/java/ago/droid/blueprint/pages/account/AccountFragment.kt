package ago.droid.blueprint.pages.account

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.R
import ago.droid.blueprint.databinding.FragmentAccountBinding
import ago.droid.blueprint.viewmodels.account.AccountViewModel
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.coroutines.runBlocking
import java.io.File
import javax.inject.Inject

class AccountFragment : Fragment() {

    @Inject lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity?.application as MainApplication).appComponent.inject(this)
        var binding: FragmentAccountBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_account,
            container,
            false
        )

        binding.url = "https://i.imgur.com/yc3CbKN.jpg"

        binding.accountViewModel = accountViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    private var imageUrl = "https://i.imgur.com/yc3CbKN.jpg"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            var btnDownload: Button = it.findViewById(R.id.btnDownload)
            btnDownload.setOnClickListener {
                this.activity?.let { it1 ->
                    var bitmap: Bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
                    runBlocking {
                        bitmap = accountViewModel.downloadImageSquare(it1, imageUrl, 200)
                    }
//                    Log.i("ss", "Imaddd " + path + File(path).exists());

                    val imageView = it.findViewById<ImageView>(R.id.imgDownloadResult)
                    imageView.setImageBitmap(Bitmap.createBitmap(bitmap))
                }
            }
        }
    }
}