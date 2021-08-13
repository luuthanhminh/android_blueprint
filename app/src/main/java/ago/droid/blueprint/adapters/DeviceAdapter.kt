package ago.droid.blueprint.adapters

import ago.droid.blueprint.R
import ago.droid.blueprint.domain.entities.Device
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import java.net.URI

class DeviceAdapter(private var item : List<Device>, private val context: Context ) :
    RecyclerView.Adapter<DevicesAdapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevicesAdapterHolder {
        return DevicesAdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_device_card, parent, false))
    }

    override fun onBindViewHolder(holder: DevicesAdapterHolder, position: Int) {
        val device: Device = item[position];
        holder.txtDeviceName.text = device.name;

        holder.txtCode.text = device.code;
        holder.txtWarrantyStatus.text = device.warrantyStatus;

        val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
        Glide.with(context)
            .load(device.image)
            .override(300, 300)
            .transition(DrawableTransitionOptions.withCrossFade(factory))
            .into(holder.imgDevice)
    }

    override fun getItemCount(): Int {
        return item.size;
    }
}

class DevicesAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
    val txtDeviceName: TextView = view.findViewById(R.id.txtDeviceName)
    val imgDevice: ImageView = view.findViewById(R.id.imgDevice)
    val txtCode: TextView = view.findViewById(R.id.txtCode)
    val txtWarrantyStatus: TextView = view.findViewById(R.id.txtWarrantyStatus)
}