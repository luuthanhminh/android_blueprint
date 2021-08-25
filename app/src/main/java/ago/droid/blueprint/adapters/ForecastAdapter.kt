package ago.droid.blueprint.adapters

import ago.droid.blueprint.R
import ago.droid.blueprint.domain.entities.Forecast
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ForecastAdapter (private var items: List<Forecast>,
                       private val context: Context
) : RecyclerView.Adapter<ForecastAdapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapterHolder {
        return ForecastAdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_card_forecast, parent,false))
    }

    override fun onBindViewHolder(holder: ForecastAdapterHolder, position: Int) {
        val forecast = items[position]
        holder.txtForecastTime.text = forecast.dt_txt
        holder.txtForecastStatus.text = forecast.weathers[0].description
        holder.txtForecastTemperature.text = "${forecast.main.temp}°F"

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ForecastAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
    val txtForecastTime: TextView = view.findViewById(R.id.txtForecastTime)
    val txtForecastStatus: TextView = view.findViewById(R.id.txtForecastStatus)
    val txtForecastTemperature: TextView = view.findViewById(R.id.txtForecastTemperature)
}