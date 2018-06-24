package victor.makov.testproject.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import victor.makov.testproject.ui.list.MyListViewModel;
import victor.makov.testproject.ui.parsing.ParsingViewModel;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyListViewModel.class)
    abstract ViewModel myListViewModel(MyListViewModel myListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ParsingViewModel.class)
    abstract ViewModel parsingViewModel (ParsingViewModel parsingViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
