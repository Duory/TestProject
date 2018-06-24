package victor.makov.testproject.data.source.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import victor.makov.testproject.data.model.Quote;
import victor.makov.testproject.data.model.QuotesResponse;

public interface QuoteApiService {

    @GET("quotes?sort=time")
    Call<QuotesResponse> getAllQuotes();
}
