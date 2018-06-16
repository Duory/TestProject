package victor.makov.testproject.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import victor.makov.testproject.data.source.local.AppDatabase;
import victor.makov.testproject.data.source.local.ListItemDao;

@Module (includes = ViewModelModule.class)
class AppModule {

    @Singleton
    @Provides
    AppDatabase provideAppDb(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "testproject.db").build();
    }

    @Singleton
    @Provides
    ListItemDao provideListItemDao(AppDatabase appDatabase) {
        return appDatabase.listItemDao();
    }
}
