package ago.droid.blueprint.pages.home

import ago.droid.blueprint.MainApplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ago.droid.blueprint.R
import ago.droid.blueprint.viewmodels.home.HomeViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        (activity?.application as MainApplication).appComponent.inject(this)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}