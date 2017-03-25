package com.example.michaelsanchez.testapp.network.component;
import com.example.michaelsanchez.testapp.network.module.AppModule;
import com.example.michaelsanchez.testapp.network.module.NetModule;
import javax.inject.Singleton;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Create an interface to implement retrofit.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class}) // components are interfaces.

public interface NetComponent {
    Retrofit retrofit();
}
