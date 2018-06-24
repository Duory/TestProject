package victor.makov.testproject.data.model;

import com.google.gson.annotations.SerializedName;

public class Quote {

	@SerializedName("rating")
	private int rating;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("time")
	private String time;

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}
}