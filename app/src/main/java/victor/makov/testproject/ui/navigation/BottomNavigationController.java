package victor.makov.testproject.ui.navigation;

import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import victor.makov.testproject.R;
import victor.makov.testproject.ui.MainActivity;
import victor.makov.testproject.ui.list.MyListFragment;

public class BottomNavigationController {

    private final int mContainerId;
    private final FragmentManager mFragmentManager;

    @Inject
    BottomNavigationController(MainActivity mainActivity) {
        mContainerId = R.id.container;
        mFragmentManager = mainActivity.getSupportFragmentManager();
    }

    public void switchToList() {
        mFragmentManager.beginTransaction()
                .replace(mContainerId, new MyListFragment())
                .commitAllowingStateLoss();
    }

    public void switchToScaling() {

    }

    public void switchToParsing() {

    }

    public void switchToMap() {

    }
}
