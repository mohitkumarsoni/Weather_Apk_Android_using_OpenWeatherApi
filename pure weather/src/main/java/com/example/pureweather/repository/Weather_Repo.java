package com.example.pureweather.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.pureweather.model.Weather_App;
import com.example.pureweather.service.Retrofit_Service;
import com.example.pureweather.service.Weather_Api;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Weather_Repo {

    private Application application;
    private Weather_App weatherApp = new Weather_App();
    DecimalFormat df = new DecimalFormat("#.##");

    public Weather_Repo(Application application) {
        this.application = application;
//        this.weatherApp = new Weather_App();
    }

    public Weather_App getWeather(String cityName, String apiKey){
        //===

        Weather_Api api = Retrofit_Service.getWeatherAccess();
        api.getWeather(cityName, apiKey).enqueue(new Callback<Weather_App>() {
            @Override
            public void onResponse(@NonNull Call<Weather_App> call, @NonNull Response<Weather_App> response) {

                if (response.isSuccessful()){
                    weatherApp = response.body();
                    Toast.makeText(application, "response successful : "+response.code(), Toast.LENGTH_SHORT).show();

                    if (weatherApp != null){
                        Double temp = weatherApp.getMain().getTemp();
                        double temperature = (temp - 273.15);
                        String formattedTemp = df.format(temperature);
                        weatherApp.getMain().setTemp(Double.valueOf(formattedTemp));

                        Double tempMin = weatherApp.getMain().getTempMin();
                        double temperatureMin = (tempMin - 273.15);
                        String formattedTempMin = df.format(temperatureMin);
                        weatherApp.getMain().setTempMin(Double.valueOf(formattedTempMin));

                        Double tempMax = weatherApp.getMain().getTempMax();
                        double temperatureMax = (tempMax - 273.15);
                        String formattedTempMax = df.format(temperatureMax);
                        weatherApp.getMain().setTempMax(Double.valueOf(formattedTempMax));
                    }

                }else {
                    if (response.code() == 404)
                        Toast.makeText(application, "city not found !", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(application, "response failed !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Weather_App> call, @NonNull Throwable t) {
                Log.d("RepoError", t.getMessage(), t.getCause());
            }
        });
        return weatherApp;
    }

}

