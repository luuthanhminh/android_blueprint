package ago.droid.blueprint.data.database.dao

import ago.droid.blueprint.data.models.ComponentModel
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.*


@Dao
abstract class ComponentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(components: ComponentModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg components: ComponentModel)

    @Delete
    abstract fun delete(component: ComponentModel)

    @Query("SELECT * FROM ComponentModel")
    abstract fun getAll(): PagingSource<Int, ComponentModel>
}