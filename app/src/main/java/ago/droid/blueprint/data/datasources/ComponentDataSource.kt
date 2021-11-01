package ago.droid.blueprint.data.datasources

import ago.droid.blueprint.data.database.dao.ComponentDao
import ago.droid.blueprint.data.database.entities.ComponentEntity
import ago.droid.blueprint.data.models.ComponentModel
import kotlinx.coroutines.delay
import javax.inject.Inject

interface ComponentDataSource {
    suspend fun getComponents(): List<ComponentModel>;
}

class ComponentDataSourceImpl @Inject constructor(private val componentDao: ComponentDao) : ComponentDataSource {

    init {
        componentDao.insert(ComponentEntity(0,"DB Lorem ipsum dolor sit amet ","https://www.google.com/"))
        componentDao.insert(ComponentEntity(0,"DB Lorem ipsum dolor sit amet ","https://www.google.com/"))
        componentDao.insert(ComponentEntity(0,"DB Lorem ipsum dolor sit amet ","https://www.google.com/"))
        componentDao.insert(ComponentEntity(0,"DB Lorem ipsum dolor sit amet Facilisi nunc non, luctus fringilla tempus. Curabitur est. ","https://www.google.com/") )
        componentDao.insert(ComponentEntity(0,"DB Lorem ipsum dolor sit amet Ut id vestibulum nisl auctor. ","https://www.google.com/") )
    }
    override suspend fun getComponents(): List<ComponentModel> {
        delay(2000L);
        return buildData();
    }

    private fun buildData(): List<ComponentModel> {
        return componentDao.getAll()
    }
}