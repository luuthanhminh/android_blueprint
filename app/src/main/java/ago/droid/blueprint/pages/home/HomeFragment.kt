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
import ago.droid.blueprint.adapters.ComponentAdapter
import ago.droid.blueprint.adapters.HomeAdapter
import ago.droid.blueprint.viewmodels.home.HomeViewModel
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
        setupListAdapter()
        setupButtons()
    }

    private fun setupButtons(){
        activity?.let {
            val btnDashboard: LinearLayout = it.findViewById(R.id.btnDashboard)
            btnDashboard.setOnClickListener {
                openDashScreen()
            }

            val btnNotification: LinearLayout = it.findViewById(R.id.btnNotification)
            btnNotification.setOnClickListener {
                openComponentScreen()
            }
        }
    }

    private fun setupListAdapter() {
        activity?.let {
            val progressBar : ProgressBar = it.findViewById(R.id.progressBar)
            val lvCard: RecyclerView = it.findViewById(R.id.lvCard)
            lvCard.layoutManager = LinearLayoutManager(activity?.applicationContext)
            
            homeViewModel.cards.observe(viewLifecycleOwner, Observer {
                var adapter = activity?.let { it1 -> HomeAdapter(it, it1.applicationContext) }
                lvCard.adapter = adapter
                when(it.size){
                    0 -> progressBar.visibility = View.VISIBLE
                    else -> progressBar.visibility = View.GONE
                }

            })
        }
    }

    private fun setupNavigation() {
    }

    private fun openDashScreen(){
        activity?.findNavController(R.id.fr_home)?.navigate(R.id.action_navigation_home_to_navigation_dashboard)
//        view?.let {
//            it.findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
//        }
    }

    private fun openComponentScreen(){
        view?.let {
            it.findNavController().navigate(R.id.action_navigation_home_to_navigation_notifications)
        }
    }

}