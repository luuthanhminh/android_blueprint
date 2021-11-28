package ago.droid.blueprint.data.database.dao

import ago.droid.blueprint.data.models.DCardModel
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.*

@Dao
abstract class DCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(dCards: DCardModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg dCards: DCardModel)

    @Delete
    abstract fun delete(dCard: DCardModel)

    @Query("SELECT * FROM DCardModel")
    abstract fun getAllPaging(): PagingSource<Int, DCardModel> //List<DCardModel>
}