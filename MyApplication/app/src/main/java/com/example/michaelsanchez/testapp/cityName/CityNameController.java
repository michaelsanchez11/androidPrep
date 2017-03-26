package com.example.michaelsanchez.testapp.cityName;

import com.example.michaelsanchez.testapp.WeatherApp;
import com.example.michaelsanchez.testapp.network.component.NetComponent;
import com.example.michaelsanchez.testapp.util.PerController;
import com.example.michaelsanchez.testapp.weatherApi.WeatherAPI;
import javax.inject.Inject;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Hitting Weather API end point.
 */

public class CityNameController{

    private CityNameActivity mCityNameActivity;

    @Inject CityNameLayout mCityNameLayout;
    @Inject Retrofit retrofit;

    public CityNameController(CityNameActivity cityNameActivity){

        mCityNameActivity = cityNameActivity;

        DaggerCityNameController_CityNameControllerComponent.builder()
                .netComponent(((WeatherApp) mCityNameActivity.getApplicationContext()).getNetComponent())
                .cityNameControllerModule(new CityNameControllerModule(mCityNameActivity))
                .build()
                .inject(this);

        retrofit.create(WeatherAPI.class)
                .getWeather("9dd263d0405171a8127527ff014f258a","Salinas")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mCityNameLayout);
    }

    @PerController
    @Component(dependencies = NetComponent.class, modules = CityNameControllerModule.class)
            // dependencies = components, modules = module
    interface CityNameControllerComponent{
        void inject(CityNameController cityNameController);
    }

    @Module // Creator of things in Dagger.
    static class CityNameControllerModule{

        private final CityNameActivity mCityNameActivity;

        public CityNameControllerModule(CityNameActivity activity){
            mCityNameActivity = activity;
        }

        @PerController
        @Provides
            // this method provides something.
        CityNameLayout providesCityNameLayout(){ // good programming practice, but name does not matter.
            return new CityNameLayout(mCityNameActivity);
        }
    }
}
