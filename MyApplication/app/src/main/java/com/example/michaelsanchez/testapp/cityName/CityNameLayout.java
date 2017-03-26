package com.example.michaelsanchez.testapp.cityName;

import android.util.Log;
import android.widget.Toast;

import com.example.michaelsanchez.testapp.R;
import com.example.michaelsanchez.testapp.data.weatherData.Weather;

import rx.Subscriber;
/**
 * Observable pattern for the api call.
 */

public class CityNameLayout extends Subscriber <Weather> {

    private CityNameActivity mCityNameActivity;

    public CityNameLayout(CityNameActivity cityNameActivity) {
        mCityNameActivity = cityNameActivity;
        mCityNameActivity.setContentView(R.layout.activity_city_name);
    }

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) {
        Log.d("ERROR: ", e.getMessage());
    }

    @Override
    public void onNext(Weather weather) {
        Toast.makeText(mCityNameActivity.getApplicationContext(), weather.getClouds().toString()
                        ,Toast.LENGTH_SHORT).show();
    }
}
