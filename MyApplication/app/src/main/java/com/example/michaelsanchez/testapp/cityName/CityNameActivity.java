package com.example.michaelsanchez.testapp.cityName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.michaelsanchez.testapp.R;

public class CityNameActivity extends AppCompatActivity {

    private CityNameController mCityNameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCityNameController = new CityNameController(this);
    }
}
