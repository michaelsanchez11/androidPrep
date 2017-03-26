package com.example.michaelsanchez.testapp;
import android.app.Application;
import com.example.michaelsanchez.testapp.network.component.DaggerNetComponent;
import com.example.michaelsanchez.testapp.network.component.NetComponent;
import com.example.michaelsanchez.testapp.network.module.AppModule;
import com.example.michaelsanchez.testapp.network.module.NetModule;

/**
 * Builds NetComponent.
 */

public class WeatherApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://api.openweathermap.org/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
