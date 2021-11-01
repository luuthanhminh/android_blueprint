package ago.droid.blueprint.data.database.entities

import ago.droid.blueprint.data.models.ComponentModel
import androidx.room.Entity
import androidx.room.PrimaryKey
import lombok.Data

@Entity
@Data
class ComponentEntity(@PrimaryKey(autoGenerate = true) val id: Int,
                      text: String,
                      url: String) : ComponentModel(text, url)