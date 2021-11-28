package ago.droid.blueprint.adapters.diffutils

import ago.droid.blueprint.domain.entities.Component
import androidx.recyclerview.widget.DiffUtil

object ComponentDiffUtil : DiffUtil.ItemCallback<Component>() {
    override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
        // text is unique.
        return oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem.text == newItem.text && oldItem.url == newItem.url
    }
}
