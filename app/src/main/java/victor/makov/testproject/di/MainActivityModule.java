package victor.makov.testproject.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import victor.makov.testproject.ui.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
