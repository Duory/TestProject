package victor.makov.testproject.ui.list;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

import victor.makov.testproject.R;
import victor.makov.testproject.data.model.ListItem;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    private List<ListItem> mListItems;
    private Context mContext;

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final CheckBox checkBox;
        private final ImageView imageView;
        private final View itemView;

        ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.tv_list_item_name);
            checkBox = itemView.findViewById(R.id.cb_list_item);
            imageView = itemView.findViewById(R.id.iv_list_item);
            this.itemView = itemView;
        }
    }

    MyListAdapter(List<ListItem> listItems, Context context) {
        this.mListItems = listItems;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem item = mListItems.get(position);

        holder.textViewName.setText(item.getItemName());

        holder.checkBox.setChecked(item.getChecked());
        holder.checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            int imageId = b ? R.drawable.emoticon_happy : R.drawable.emoticon_sad;
            holder.imageView.setImageResource(imageId);
        });

        int imageId = item.getChecked() ? R.drawable.emoticon_happy : R.drawable.emoticon_sad;
        holder.imageView.setImageResource(imageId);

        holder.itemView.setOnClickListener(view -> {
            startEditActivity(position);
        });

        holder.itemView.setOnCreateContextMenuListener((contextMenu, view, contextMenuInfo) -> {
            PopupMenu popupMenu = new PopupMenu(mContext, view);
            popupMenu.getMenuInflater().inflate(R.menu.list_popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()) {
                    case R.id.lost_popup_menu_edit:
                        startEditActivity(position);
                        break;
                    case R.id.lost_popup_menu_delete:
                        break;
                }
                return true;
            });
            popupMenu.show();
        });
    }

    private void startEditActivity(int position) {
        Intent intent = new Intent(mContext, AddEditActivity.class);
        intent.putExtra(
                mContext.getString(R.string.intent_list_item_extra),
                mListItems.get(position));
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }


}
