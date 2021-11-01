package ago.droid.blueprint.data.database

import ago.droid.blueprint.data.database.converter.Converters
import ago.droid.blueprint.data.database.dao.ComponentDao
import ago.droid.blueprint.data.database.dao.DCardDao
import ago.droid.blueprint.data.database.entities.ComponentEntity
import ago.droid.blueprint.data.database.entities.DCardEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [ComponentEntity::class, DCardEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class BlueprintDatabase : RoomDatabase() {
    abstract fun getComponentDao() : ComponentDao
    abstract fun getDCardDao() : DCardDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: BlueprintDatabase? = null

        fun getInstance(context: Context): BlueprintDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }
        // Create and pre-populate the database. See this article for more details:
        private fun buildDatabase(context: Context): BlueprintDatabase {

            return Room.databaseBuilder(context, BlueprintDatabase::class.java, "BlueprintDatabase")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                .allowMainThreadQueries() // FIXME(JJ): Shouldn't be getting data on main thread
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}