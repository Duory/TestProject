package victor.makov.testproject.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ListItem {

    @PrimaryKey
    private long id;

    private String itemName;

    private boolean isChecked;

    public ListItem(long id, String itemName, boolean isChecked) {
        this.id = id;
        this.itemName = itemName;
        this.isChecked = isChecked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}