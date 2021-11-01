package ago.droid.blueprint.data.database.entities

import ago.droid.blueprint.data.models.DCardModel
import androidx.room.Entity
import androidx.room.PrimaryKey
import lombok.Data

@Entity
@Data
class DCardEntity(@PrimaryKey(autoGenerate = true) val id: Int,
                  header: String,
                  description: String,
                  images: MutableList<String>): DCardModel(header, description, images)