package ago.droid.blueprint.pages.dashboard2

import ago.droid.blueprint.MainApplication
import ago.droid.blueprint.R
import ago.droid.blueprint.adapters.DeviceAdapter
import ago.droid.blueprint.viewmodels.dashboard2.Dashboard2ViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import javax.inject.Inject

class Dashboard2Fragment: Fragment() {
    @Inject
    lateinit var dashboard2ViewModel: Dashboard2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as MainApplication).appComponent.inject(this)

        val root = inflater.inflate(R.layout.fragment_dashboard2, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lvDashboard2: RecyclerView = view.findViewById(R.id.lvDashboard2)

        lvDashboard2.layoutManager = LinearLayoutManager(activity?.applicationContext);

        dashboard2ViewModel.devices.observe(viewLifecycleOwner, Observer {
            var adapder = activity?.let { it1 -> DeviceAdapter(it, it1.applicationContext) }

            lvDashboard2.adapter = adapder


        })

    }
}