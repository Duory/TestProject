package victor.makov.testproject.data.source;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;
import victor.makov.testproject.data.model.Quote;
import victor.makov.testproject.data.model.QuotesResponse;
import victor.makov.testproject.data.source.remote.QuoteApiService;
import victor.makov.testproject.util.AppExecutors;

public class QuoteRepository {

    private QuoteApiService mQuoteApiService;
    private AppExecutors mExecutors;

    @Inject
    public QuoteRepository(QuoteApiService quoteApiService, AppExecutors executors) {
        this.mQuoteApiService = quoteApiService;
        this.mExecutors = executors;
    }

    public LiveData<List<Quote>> getAll() {
        MutableLiveData<List<Quote>> liveData = new MutableLiveData<>();
        mExecutors.getmNetworkIO().execute(() -> {
            try {
                Response response = mQuoteApiService.getAllQuotes().execute();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        QuotesResponse quotesResponse = (QuotesResponse) response.body();
                        if (quotesResponse != null) {
                            liveData.postValue(quotesResponse.getQuotes());
                        }
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        return liveData;
    }
}
