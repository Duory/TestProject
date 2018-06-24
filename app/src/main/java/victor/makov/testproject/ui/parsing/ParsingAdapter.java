package victor.makov.testproject.ui.parsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import victor.makov.testproject.R;
import victor.makov.testproject.data.model.Quote;

public class ParsingAdapter extends RecyclerView.Adapter<ParsingAdapter.ViewHolder> {

    private List<Quote> mQuotes;
    private Context mContext;

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTime;
        private final TextView textViewDescription;
        private final TextView textViewRating;

        ViewHolder(View itemView) {
            super(itemView);

            textViewTime = itemView.findViewById(R.id.tv_quote_time);
            textViewDescription = itemView.findViewById(R.id.tv_quote_description);
            textViewRating = itemView.findViewById(R.id.tv_quote_rating);
        }
    }

    ParsingAdapter(List<Quote> quotes, Context context) {
        this.mQuotes = quotes;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_quote_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewTime.setText(mQuotes.get(position).getTime());
        holder.textViewDescription.setText(Html.fromHtml(mQuotes.get(position).getDescription()));
        holder.textViewRating.setText(String.format("%s: %s", mContext.getString(R.string.quote_rating), String.valueOf(mQuotes.get(position).getRating())));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }


}
