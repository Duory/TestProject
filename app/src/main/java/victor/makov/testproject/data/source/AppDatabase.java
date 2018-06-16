package victor.makov.testproject.data.source;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import victor.makov.testproject.data.model.ListItem;

@Database(entities = {ListItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ListItemDao listItemDao();
}
