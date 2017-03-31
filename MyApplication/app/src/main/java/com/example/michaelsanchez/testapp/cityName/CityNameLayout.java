package com.example.michaelsanchez.testapp.cityName;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.michaelsanchez.testapp.R;
import com.example.michaelsanchez.testapp.data.weatherData.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
/**
 * Observable pattern for the api call.
 */

public class CityNameLayout extends Subscriber <Weather> {

    private CityNameActivity mCityNameActivity;
    private CityNameLayoutListener mListener;

    @BindView(R.id.city_name_submit) Button submitButton;
    @BindView(R.id.city_name_input)
    EditText cityName;

    public CityNameLayout(CityNameActivity cityNameActivity, CityNameLayoutListener listener) {
        mCityNameActivity = cityNameActivity;
        mListener = listener;
        mCityNameActivity.setContentView(R.layout.activity_city_name);
        ButterKnife.bind(this, mCityNameActivity);
    }

    @OnClick(R.id.city_name_submit)
    void onSubmitButtonClicked() {
        mListener.onSubmitButtonClicked(cityName.getText().toString());

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

    interface CityNameLayoutListener {
        void onSubmitButtonClicked(String city);
    }
}
