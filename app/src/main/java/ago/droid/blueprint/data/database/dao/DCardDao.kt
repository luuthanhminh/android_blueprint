package ago.droid.blueprint.data.database.dao

import ago.droid.blueprint.data.database.entities.DCardEntity
import androidx.room.*

@Dao
abstract class DCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(dCards: DCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg dCards: DCardEntity)

    @Delete
    abstract fun delete(dCard: DCardEntity)

    @Query("SELECT * FROM DCardEntity")
    abstract fun getAll(): List<DCardEntity>
}