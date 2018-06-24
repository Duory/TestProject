package victor.makov.testproject.ui.navigation;

import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import victor.makov.testproject.R;
import victor.makov.testproject.ui.MainActivity;
import victor.makov.testproject.ui.list.MyListFragment;
import victor.makov.testproject.ui.map.MapFragment;
import victor.makov.testproject.ui.parsing.ParsingFragment;
import victor.makov.testproject.ui.scaling.ScalingFragment;
import victor.makov.testproject.ui.settings.SettingsFragment;

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
        mFragmentManager.beginTransaction()
                .replace(mContainerId, new ScalingFragment())
                .commitAllowingStateLoss();
    }

    public void switchToParsing() {
        mFragmentManager.beginTransaction()
                .replace(mContainerId, new ParsingFragment())
                .commitAllowingStateLoss();
    }

    public void switchToMap() {
        mFragmentManager.beginTransaction()
                .replace(mContainerId, new MapFragment())
                .commitAllowingStateLoss();
    }

    public void switchToSettings() {
        mFragmentManager.beginTransaction()
                .replace(mContainerId, new SettingsFragment())
                .commitAllowingStateLoss();
    }
}
