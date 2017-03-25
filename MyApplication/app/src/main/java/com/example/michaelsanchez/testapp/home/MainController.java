package com.example.michaelsanchez.testapp.home;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.example.michaelsanchez.testapp.WeatherApp;
import com.example.michaelsanchez.testapp.cityName.CityNameActivity;
import com.example.michaelsanchez.testapp.network.component.NetComponent;
import com.example.michaelsanchez.testapp.util.PerController;
import javax.inject.Inject;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Controller for {@link MainActivity}.
 * Controller is in charge of the logic.
 */

public class MainController implements MainLayout.MainLayoutListener{

    private MainActivity mMainActivity;
    @Inject MainLayout mMainLayout; // this replaces the private MainLayout mMainLayout line.
    @Inject Retrofit mRetrofit;

    public MainController(@NonNull MainActivity mainActivity) {
        // when we use @nonNull, we state that this param will never be null.
        mMainActivity = mainActivity;

        // this is the call to connect the whole dagger Module,
        // Provides things together and creates the things we want.
        //// we use (this) on .mainController... because MainController implements the listener,
        /// therefore MainController is a listener too.
        DaggerMainController_MainControllerComponent.builder()
                .netComponent(((WeatherApp) mMainActivity.getApplicationContext()).getNetComponent())
                .mainControllerModule(new MainControllerModule(mMainActivity,this))
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
    @Component(dependencies = NetComponent.class, modules = MainControllerModule.class)
            // dependencies = components, modules = module
    interface MainControllerComponent{
        void inject(MainController mainController);
    }

    @Module // Creator of things in Dagger.
    static class MainControllerModule{
        private final MainActivity mMainActivity;
        private final MainLayout.MainLayoutListener mMainLayoutListener;

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
