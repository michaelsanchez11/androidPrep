package com.example.michaelsanchez.testapp.home;

import android.content.Intent;
import android.widget.Toast;

import com.example.michaelsanchez.testapp.cityName.CityNameActivity;

/**
 * Controller for {@link MainActivity}.
 */

public class MainController implements MainLayout.MainLayoutListener{

    private MainActivity mMainActivity;
    private MainLayout mMainLayout;

    public MainController(MainActivity mainActivity, MainLayout.MainLayoutListener listener) {
        mMainActivity = mainActivity;
        mMainLayout = new MainLayout(mMainActivity,this);
    }

    @Override
    public void onCityNameButtonClicked(){
        Intent intent = new Intent(mMainActivity, CityNameActivity.class);
        mMainActivity.startActivity(intent);
    }


}
