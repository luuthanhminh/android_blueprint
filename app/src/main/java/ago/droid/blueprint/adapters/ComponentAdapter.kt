package ago.droid.blueprint.adapters

import ago.droid.blueprint.R
import ago.droid.blueprint.data.models.ComponentModel
import ago.droid.blueprint.domain.entities.Component
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ComponentAdapter(private var diffCallback: DiffUtil.ItemCallback<Component>,
                       private val context:Context) : PagingDataAdapter<Component, ComponentAdapterHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentAdapterHolder {
        return ComponentAdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_info_view, parent,false))
    }

    override fun onBindViewHolder(holder: ComponentAdapterHolder, position: Int) {
        val component = getItem(position)
        if (component != null) {
            holder.tvTitle.text = component.text
        }

    }

//    override fun getItemCount(): Int {
//        return itemCount
//    }
}

class ComponentAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
}

