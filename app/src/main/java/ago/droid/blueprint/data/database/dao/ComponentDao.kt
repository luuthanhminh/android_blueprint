package ago.droid.blueprint.data.database.dao

import ago.droid.blueprint.data.database.entities.ComponentEntity
import androidx.room.*


@Dao
abstract class ComponentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(components: ComponentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg components: ComponentEntity)

    @Delete
    abstract fun delete(component: ComponentEntity)

    @Query("SELECT * FROM ComponentEntity")
    abstract fun getAll(): List<ComponentEntity>
}