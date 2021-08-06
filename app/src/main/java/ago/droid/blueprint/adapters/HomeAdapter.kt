package ago.droid.blueprint.adapters

import ago.droid.blueprint.R
import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.entities.DCard
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

class HomeAdapter(private var items: List<DCard>,
                       private val context: Context
) : RecyclerView.Adapter<HomeAdapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterHolder {
        return HomeAdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_card_single_view, parent,false))
    }

    override fun onBindViewHolder(holder: HomeAdapterHolder, position: Int) {
        val component = items[position]
        holder.tvHeader.text = component.header
        holder.tvDescription.text = component.description
        val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
        Glide.with(context)
            .load(component.images[0])
            .transition(DrawableTransitionOptions.withCrossFade(factory))
            .into(holder.ivPhoto)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class HomeAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvHeader: TextView = view.findViewById(R.id.tvHeader)
    val tvDescription: TextView = view.findViewById(R.id.tvDescription)
    val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
}