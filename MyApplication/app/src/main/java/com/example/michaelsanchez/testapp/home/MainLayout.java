package com.example.michaelsanchez.testapp.home;

import com.example.michaelsanchez.testapp.R;

/**
 * Layout for the {@link MainActivity} .
 */

public class MainLayout {

    private MainActivity mMainActivity;

    public MainLayout(MainActivity mainActivity) {
            mMainActivity = mainActivity;
            mMainActivity.setContentView(R.layout.activity_main);
    }
}
