package victor.makov.testproject.data.source;

import android.arch.lifecycle.LiveData;

import java.util.List;

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
        if (liveData.getValue() == null) {
            mExecutors.getDiskIO().execute(() -> {
                for (int i = 0; i < 9; i+=1) {
                    ListItem item =
                            new ListItem("Элемент номер " + i, (i & 2) == 0);
                    mListItemDao.insert(item);
                }
            });
        }
        return liveData;
    }
}
