package ago.droid.blueprint.adapters.diffutils

import ago.droid.blueprint.domain.entities.Component
import ago.droid.blueprint.domain.entities.DCard
import androidx.recyclerview.widget.DiffUtil

object DCardDiffUtil : DiffUtil.ItemCallback<DCard>() {
    override fun areItemsTheSame(oldItem: DCard, newItem: DCard): Boolean {
        return oldItem.header.equals(newItem.header) && oldItem.description.equals(newItem.description)
    }

    override fun areContentsTheSame(oldItem: DCard, newItem: DCard): Boolean {
        return oldItem.description.equals(newItem.description)
    }
}