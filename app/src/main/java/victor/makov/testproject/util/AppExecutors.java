package victor.makov.testproject.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppExecutors {

    private final Executor mDiskIO;

    private final Executor mNetworkIO;

    private AppExecutors(Executor diskIO, Executor networkIO) {
        this.mDiskIO = diskIO;
        this.mNetworkIO = networkIO;
    }

    @Inject
    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3));
    }

    public Executor getDiskIO() {
        return mDiskIO;
    }

    public Executor getmNetworkIO() {
        return mNetworkIO;
    }
}
