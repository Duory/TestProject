package victor.makov.testproject.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import victor.makov.testproject.ui.list.MyListFragment;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract MyListFragment contributeListFragment();
}
