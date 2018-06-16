package victor.makov.testproject.data.source;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import victor.makov.testproject.data.model.ListItem;

@Dao
public interface ListItemDao {

    @Query("SELECT * FROM listitem")
    List<ListItem> getAll();

    @Query("SELECT * FROM listitem WHERE id = :id")
    ListItem getById(long id);

    @Insert
    void insert(ListItem listItem);

    @Update
    void update(ListItem listItem);

    @Delete
    void delete(ListItem listItem);
}
