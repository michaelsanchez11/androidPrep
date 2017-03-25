package com.example.michaelsanchez.testapp.home;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MainController mMainController; // naming convention for variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainController = new MainController(this, mMainController); // initializes the main controller
    }
}
