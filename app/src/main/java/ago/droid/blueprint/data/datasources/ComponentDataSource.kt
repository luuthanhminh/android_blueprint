package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.database.dao.ComponentDao
import ago.droid.blueprint.data.models.ComponentModel
import androidx.paging.DataSource
import androidx.paging.PagingSource
import kotlinx.coroutines.delay
import javax.inject.Inject

interface ComponentDataSource {
    fun getComponents(): PagingSource<Int, ComponentModel>;
}

class ComponentDataSourceImpl @Inject constructor(private val componentDao: ComponentDao) : ComponentDataSource {

    init {
        componentDao.insert(ComponentModel(1,"DB Lorem ipsum dolor sit amet ","https://www.google.com/"))
        componentDao.insert(ComponentModel(2,"DB Lorem ipsum dolor sit amet ","https://www.google.com/"))
        componentDao.insert(ComponentModel(3,"DB Lorem ipsum dolor sit amet ","https://www.google.com/"))
        componentDao.insert(ComponentModel(4,"DB Lorem ipsum dolor sit amet Facilisi nunc non, luctus fringilla tempus. Curabitur est. ","https://www.google.com/") )
        componentDao.insert(ComponentModel(5,"DB Lorem ipsum dolor sit amet Ut id vestibulum nisl auctor. ","https://www.google.com/") )
    }
    override fun getComponents(): PagingSource<Int, ComponentModel> {
//        delay(2000L);
        return buildData();
    }

    private fun buildData(): PagingSource<Int, ComponentModel> {
        return componentDao.getAllPaging()
    }
}