package victor.makov.testproject.ui.list;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import victor.makov.testproject.R;
import victor.makov.testproject.data.model.ListItem;
import victor.makov.testproject.di.Injectable;

public class AddEditActivity extends AppCompatActivity implements Injectable{

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private MyListViewModel mMyListViewModel;

    private EditText editTextItemName;

    private ListItem listItem;
    private Mode mode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().hasExtra(getString(R.string.intent_list_item_extra))) {
            mode = Mode.EDIT;
            listItem =
                    (ListItem) getIntent().getSerializableExtra(getString(R.string.intent_list_item_extra));
        } else {
            mode = Mode.ADD;
        }

        setContentView(R.layout.activity_add_edit_list);

        mMyListViewModel =
                ViewModelProviders.of(this, mViewModelFactory).get(MyListViewModel.class);

        assignAndSetupViews();
    }

    private void assignAndSetupViews() {
        editTextItemName = findViewById(R.id.et_item_name);
        FloatingActionButton fabCheck = findViewById(R.id.fab_check);

        switch (mode) {
            case ADD:
                fabCheck.setOnClickListener(view -> {
                    if (editTextItemName.getText().toString().matches("")) {
                        Toast.makeText(this, "Enter item name.", Toast.LENGTH_SHORT).show();
                        editTextItemName.requestFocus();
                    } else {
                        addListItem();
                        finish();
                    }
                });
                break;
            case EDIT:
                editTextItemName.setText(listItem.getItemName());

                fabCheck.setOnClickListener(view -> {
                    if (editTextItemName.getText().toString().matches("")) {
                        Toast.makeText(this, "Item name is empty.", Toast.LENGTH_SHORT).show();
                        editTextItemName.requestFocus();
                    } else {
                        updateListItem();
                        finish();
                    }
                });
                break;
        }

    }

    @Override
    public void onBackPressed() {
        String newItemName = editTextItemName.getText().toString();
        switch (mode) {
            case ADD:
                if (newItemName.matches("")) {
                    super.onBackPressed();
                } else {
                    createAlertDialog();
                }
                break;
            case EDIT:
                if (listItem.getItemName().equals(newItemName)) {
                    super.onBackPressed();
                } else {
                    createAlertDialog();
                }
                break;
        }
    }

    private void createAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.save_dialog_message);
        builder.setPositiveButton(R.string.yes, (dialog, id) -> {
            switch (mode) {
                case ADD:
                    addListItem();
                    break;
                case EDIT:
                    updateListItem();
                    break;
            }
            super.onBackPressed();
        });
        builder.setNegativeButton(R.string.no,(dialog, id) -> {
            super.onBackPressed();
        });
        builder.create().show();
    }

    private void addListItem() {
        ListItem newListItem = new ListItem(editTextItemName.getText().toString());
        mMyListViewModel.addListItem(newListItem);
    }

    private void updateListItem() {
        listItem.setItemName(editTextItemName.getText().toString());
        mMyListViewModel.updateListItem(listItem);
    }

    private enum Mode {
        ADD, EDIT
    }
}
