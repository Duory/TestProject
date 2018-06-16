package victor.makov.testproject.ui;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import victor.makov.testproject.R;
import victor.makov.testproject.ui.navigation.BottomNavigationController;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    BottomNavigationController bottomNavigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation(savedInstanceState);
    }

    private void setupBottomNavigation(Bundle savedInstanceState) {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener( item -> {
            switch (item.getItemId()) {
                case R.id.bottom_nav_item_list:
                    bottomNavigationController.switchToList();
                    return true;
                case R.id.bottom_nav_item_scaling:
                    bottomNavigationController.switchToScaling();
                    return true;
                case R.id.bottom_nav_item_parsing:
                    bottomNavigationController.switchToParsing();
                    return true;
                case R.id.bottom_nav_item_map:
                    bottomNavigationController.switchToMap();
                    return true;
            }
            return false;
        });
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.bottom_nav_item_list);
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
