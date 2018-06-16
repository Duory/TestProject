package victor.makov.testproject.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import victor.makov.testproject.R;
import victor.makov.testproject.data.model.ListItem;
import victor.makov.testproject.di.Injectable;

public class MyListFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_list, container, false);

        assignAndSetupRecycler(root);

        return root;
    }

    private void assignAndSetupRecycler(View root) {
        mRecyclerView = root.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyListAdapter myListAdapter = new MyListAdapter(new ArrayList<>());
        mRecyclerView.setAdapter(myListAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupDataObserve();
    }

    private void setupDataObserve() {
        MyListViewModel myListViewModel = ViewModelProviders.of(this, mViewModelFactory)
                .get(MyListViewModel.class);
        myListViewModel.init();

        LiveData<List<ListItem>> liveData = myListViewModel.getListItems();

        liveData.observe(this, listItems -> {
            if (listItems != null) {
                mRecyclerView.
                        swapAdapter(new MyListAdapter(listItems), false);
            }
        });
    }
}
