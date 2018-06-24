package victor.makov.testproject.ui.parsing;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import victor.makov.testproject.R;
import victor.makov.testproject.data.model.Quote;
import victor.makov.testproject.di.Injectable;

public class ParsingFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_parsing, container, false);

        assignAndSetupViews(root);

        return root;
    }

    private void assignAndSetupViews(View root) {
        progressBar = root.findViewById(R.id.progressBar);
        recyclerView = root.findViewById(R.id.rv_quotes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        ParsingAdapter parsingAdapter = new ParsingAdapter(new ArrayList<>(), getContext());
        recyclerView.setAdapter(parsingAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupDataObserve();
    }

    private void setupDataObserve() {
        ParsingViewModel parsingViewModel = ViewModelProviders.of(this, mViewModelFactory)
                .get(ParsingViewModel.class);
        parsingViewModel.init();
        progressBar.setVisibility(View.VISIBLE);
        LiveData<List<Quote>> liveData = parsingViewModel.getQuotes();

        liveData.observe(this, quotes -> {
            if (quotes != null) {
                progressBar.setVisibility(View.GONE);
                ParsingAdapter parsingAdapter = new ParsingAdapter(quotes, getContext());
                recyclerView.swapAdapter(parsingAdapter, false);
            }
        });
    }
}
