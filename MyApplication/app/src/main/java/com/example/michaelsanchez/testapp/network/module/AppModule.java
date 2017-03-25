package com.example.michaelsanchez.testapp.network.module;
import android.app.Application;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Makes on instance of our Application.
 */

@Module
public class AppModule {
    Application mApplication; // an instance of your app.

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
