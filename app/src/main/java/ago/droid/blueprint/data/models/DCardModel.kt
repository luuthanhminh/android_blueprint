package ago.droid.blueprint.data.models

import ago.droid.blueprint.domain.entities.DCard
import androidx.room.Entity
import androidx.room.PrimaryKey
import lombok.Data

@Entity
@Data
open class DCardModel(@PrimaryKey(autoGenerate = true) val id: Int, header: String,
                      description: String, images: MutableList<String>) : DCard(header, description, images)