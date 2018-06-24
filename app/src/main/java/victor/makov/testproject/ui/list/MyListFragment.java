package victor.makov.testproject.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_list, container, false);

        assignAndSetupViews(root);

        return root;
    }

    private void assignAndSetupViews(View root) {
        assignAndSetupRecycler(root);
        assignAndSetupFab(root);
    }

    private void assignAndSetupRecycler(View root) {
        recyclerView = root.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyListAdapter myListAdapter = new MyListAdapter(new ArrayList<>(), getContext(), null);
        recyclerView.setAdapter(myListAdapter);
    }


    private void assignAndSetupFab(View root) {
        FloatingActionButton fabAdd = root.findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), AddEditActivity.class));
        });
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
                recyclerView.swapAdapter(
                        new MyListAdapter(listItems, getContext(), myListViewModel),
                        false);
            }
        });
    }
}
