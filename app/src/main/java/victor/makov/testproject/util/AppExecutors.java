package victor.makov.testproject.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppExecutors {

    private final Executor mDiskIO;

    private AppExecutors(Executor diskIO) {
        this.mDiskIO = diskIO;
    }

    @Inject

    public AppExecutors() {
        this(Executors.newSingleThreadExecutor());
    }

    public Executor getDiskIO() {
        return mDiskIO;
    }
}
