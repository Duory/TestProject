package victor.makov.testproject.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import victor.makov.testproject.ui.list.MyListFragment;
import victor.makov.testproject.ui.map.MapFragment;
import victor.makov.testproject.ui.parsing.ParsingFragment;
import victor.makov.testproject.ui.scaling.ScalingFragment;
import victor.makov.testproject.ui.settings.SettingsFragment;

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract MyListFragment contributeListFragment();

    @ContributesAndroidInjector
    abstract ParsingFragment contributeParsingFragment();

    @ContributesAndroidInjector
    abstract MapFragment contributeMapFragment();

    @ContributesAndroidInjector
    abstract ScalingFragment contributeScalingFragment();

    @ContributesAndroidInjector
    abstract SettingsFragment contributeSettingsFragment();
}
