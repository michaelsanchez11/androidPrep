package com.example.michaelsanchez.testapp.home;
import android.content.Intent;
import com.example.michaelsanchez.testapp.cityName.CityNameActivity;
import com.example.michaelsanchez.testapp.util.PerController;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Controller for {@link MainActivity}.
 * Controller is in charge of the logic.
 */

public class MainController implements MainLayout.MainLayoutListener{

    private MainActivity mMainActivity;
    @Inject MainLayout mMainLayout; // this replaces the private MainLayout mMainLayout line.

    public MainController(MainActivity mainActivity, MainLayout.MainLayoutListener listener) {
        mMainActivity = mainActivity;

        // this is the call to connect the whole dagger Module, Provides things together and creates the things we want.
        DaggerMainController_MainControllerComponent.builder()
                .mainControllerModule(new MainControllerModule(mMainActivity,this)) // we use (this) because MainController implements the listener, therefore MainController is a listener too.
                .build()
                .inject(this);
    }

    @Override
    public void onCityNameButtonClicked(){
        Intent intent = new Intent(mMainActivity, CityNameActivity.class);
        mMainActivity.startActivity(intent);
    }

    /*
        Dagger starts here. Modules are always a static class.
            - This is the code to replace the initialization in the constructor of MainController.
    */
    // this maps MainController module to this component.

    @PerController
    @Component(modules = MainControllerModule.class)
    interface MainControllerComponent{
        void inject(MainController mainController);
    }

    @Module // Creator of things in Dagger.
    static class MainControllerModule{
        private MainActivity mMainActivity;
        private MainLayout.MainLayoutListener mMainLayoutListener;

        public MainControllerModule(MainActivity activity,MainLayout.MainLayoutListener listener){
            mMainActivity = activity;
            mMainLayoutListener = listener;
        }

        @PerController
        @Provides // this method provides something.
        MainLayout providesMainLayout(){ // good programming practice, but name does not matter.
            return new MainLayout(mMainActivity, mMainLayoutListener);
        }
    }
    /*
        Dagger ends here.
    */
}
