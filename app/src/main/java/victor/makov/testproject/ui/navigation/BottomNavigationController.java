package victor.makov.testproject.ui.navigation;

import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import victor.makov.testproject.R;
import victor.makov.testproject.ui.MainActivity;

public class BottomNavigationController {

    private final int containerId;
    private final FragmentManager fragmentManager;

    @Inject
    BottomNavigationController(MainActivity mainActivity) {
        containerId = R.id.container;
        fragmentManager = mainActivity.getSupportFragmentManager();
    }

    public void switchToList() {

    }

    public void switchToScaling() {

    }

    public void switchToParsing() {

    }

    public void switchToMap() {

    }
}
