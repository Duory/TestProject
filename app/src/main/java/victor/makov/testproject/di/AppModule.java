package victor.makov.testproject.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import victor.makov.testproject.data.source.local.AppDatabase;
import victor.makov.testproject.data.source.local.ListItemDao;
import victor.makov.testproject.data.source.remote.QuoteApiService;

@Module (includes = ViewModelModule.class)
class AppModule {

    @Singleton
    @Provides
    QuoteApiService provideQuoteApiService() {
        return new Retrofit.Builder()
                .baseUrl("http://quotes.zennex.ru/api/v3/bash/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuoteApiService.class);
    }

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
