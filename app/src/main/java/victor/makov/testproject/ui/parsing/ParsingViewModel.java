package victor.makov.testproject.ui.parsing;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import victor.makov.testproject.data.model.Quote;
import victor.makov.testproject.data.source.QuoteRepository;

public class ParsingViewModel extends ViewModel {

    private QuoteRepository mQuoteRepository;

    private LiveData<List<Quote>> mQuotes;

    @Inject
    public ParsingViewModel(QuoteRepository quoteRepository) {
        this.mQuoteRepository = quoteRepository;
    }

    void init() {
        if (mQuotes != null) {
            return;
        }
        mQuotes = mQuoteRepository.getAll();
    }

    public LiveData<List<Quote>> getQuotes() {
        return mQuotes;
    }
}
