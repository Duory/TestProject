package victor.makov.testproject.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import victor.makov.testproject.data.source.AppDatabase;

@Module
class AppModule {

    @Singleton
    @Provides
    AppDatabase provideAppDb(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "testproject.db").build();
    }
}
