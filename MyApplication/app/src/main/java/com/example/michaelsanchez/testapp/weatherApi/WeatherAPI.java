package com.example.michaelsanchez.testapp.weatherApi;
import com.example.michaelsanchez.testapp.data.weatherData.Weather;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Query for the api weather using rxjava.
 */

public interface WeatherAPI {
    @GET("data/2.5/weather")
    rx.Observable<Weather> getWeather(
            @Query("appid") String appid,
            @Query("q") String cityName);
}
