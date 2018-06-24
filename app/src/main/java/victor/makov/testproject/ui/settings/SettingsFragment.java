package victor.makov.testproject.ui.settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

import victor.makov.testproject.R;
import victor.makov.testproject.di.Injectable;
import victor.makov.testproject.util.LocaleHelper;

public class SettingsFragment extends Fragment implements Injectable {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        assignAndSetupViews(root);

        return root;
    }

    private void assignAndSetupViews(View root) {
        Button buttonEnglish = root.findViewById(R.id.btn_english);
        buttonEnglish.setOnClickListener(view -> {
            LocaleHelper.setLocale(getContext(), "en");
            getActivity().recreate();
        });

        Button buttonRussian = root.findViewById(R.id.btn_russian);
        buttonRussian.setOnClickListener(view -> {
            LocaleHelper.setLocale(getContext(), "ru");
            getActivity().recreate();
        });
    }
}
