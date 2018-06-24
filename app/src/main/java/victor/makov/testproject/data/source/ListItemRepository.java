package victor.makov.testproject.data.source;

import android.arch.lifecycle.LiveData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

import victor.makov.testproject.data.model.ListItem;
import victor.makov.testproject.data.source.local.ListItemDao;
import victor.makov.testproject.util.AppExecutors;

@Singleton
public class ListItemRepository {

    private ListItemDao mListItemDao;
    private AppExecutors mExecutors;

    @Inject
    public ListItemRepository (ListItemDao listItemDao, AppExecutors executors) {
        this.mListItemDao = listItemDao;
        this.mExecutors = executors;
    }

    public LiveData<List<ListItem>> getAll() {
        LiveData<List<ListItem>> liveData = mListItemDao.getAll();
        mExecutors.getDiskIO().execute(() -> {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss.SSS", Locale.getDefault());
            ListItem item =
                    new ListItem(format.format(calendar.getTime()), (calendar.getTimeInMillis() & 1) == 0);
            mListItemDao.insert(item);
        });
        return liveData;
    }

    public void addListItem(ListItem listItem) {
        mExecutors.getDiskIO().execute(() -> {
            mListItemDao.insert(listItem);
        });
    }

    public void updateListItem(ListItem listItem) {
        mExecutors.getDiskIO().execute(() -> {
            mListItemDao.update(listItem);
        });
    }

    public void deleteListItem(ListItem listItem) {
        mExecutors.getDiskIO().execute(() -> {
            mListItemDao.delete(listItem);
        });
    }
}
