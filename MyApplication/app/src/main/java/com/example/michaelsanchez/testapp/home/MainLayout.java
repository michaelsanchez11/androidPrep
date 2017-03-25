package com.example.michaelsanchez.testapp.home;

import android.widget.Button;

import com.example.michaelsanchez.testapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Layout for the {@link MainActivity}.
 * Layout is in charge of how things are displayed in the activity.
 */

public class MainLayout {

    private MainActivity mMainActivity;
    private MainLayoutListener mMainLayoutListener;

    @BindView(R.id.city_name_button)
    Button mCityNameButton;

    public MainLayout(MainActivity mainActivity, MainLayoutListener listener) {
        mMainActivity = mainActivity;
        mMainLayoutListener = listener;
        mMainActivity.setContentView(R.layout.activity_main);
        ButterKnife.bind(this,mainActivity);
    }

    @OnClick(R.id.city_name_button)
    void onCityNameButtonClicked(){
        mMainLayoutListener.onCityNameButtonClicked();
    }

    interface MainLayoutListener {
        void onCityNameButtonClicked();
    }
}
