package victor.makov.testproject.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import victor.makov.testproject.data.model.ListItem;

@Database(entities = {ListItem.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ListItemDao listItemDao();
}
