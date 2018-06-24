package victor.makov.testproject.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import victor.makov.testproject.ui.list.AddEditActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AddEditActivity contributeAddEditActivity();
}
