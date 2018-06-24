package victor.makov.testproject.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuotesResponse{

	@SerializedName("total")
	private int total;

	@SerializedName("last")
	private String last;

	@SerializedName("quotes")
	private List<Quote> quotes;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setLast(String last){
		this.last = last;
	}

	public String getLast(){
		return last;
	}

	public void setQuotes(List<Quote> quotes){
		this.quotes = quotes;
	}

	public List<Quote> getQuotes(){
		return quotes;
	}
}