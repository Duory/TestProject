package victor.makov.testproject.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import victor.makov.testproject.data.model.ListItem;
import victor.makov.testproject.data.source.ListItemRepository;

public class MyListViewModel extends ViewModel {

    private ListItemRepository mListItemRepository;

    private LiveData<List<ListItem>> mListItems;

    @Inject
    public MyListViewModel(ListItemRepository listItemRepository) {
        this.mListItemRepository = listItemRepository;
    }
    void init() {
        if (mListItems != null) {
            return;
        }
        mListItems = mListItemRepository.getAll();
    }

    public LiveData<List<ListItem>> getListItems() {
        return mListItems;
    }
}
