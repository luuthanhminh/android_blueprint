package ago.droid.blueprint.data.models

import ago.droid.blueprint.domain.entities.Component
import androidx.room.Entity
import androidx.room.PrimaryKey
import lombok.Data

@Entity
@Data
open class ComponentModel (@PrimaryKey(autoGenerate = true) val id: Int, text: String, url: String) : Component(text, url)