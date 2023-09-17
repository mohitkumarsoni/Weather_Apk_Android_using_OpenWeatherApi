package com.example.pureweather.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.pureweather.model.Weather_App;
import com.example.pureweather.repository.Weather_Repo;

public class Weather_ViewModel extends AndroidViewModel {

    private Weather_Repo weatherRepo;

    public Weather_ViewModel(@NonNull Application application) {
        super(application);
        weatherRepo = new Weather_Repo(application);
    }

    public Weather_App getWeather(@NonNull String cityName, @NonNull String apiKey){
        return weatherRepo.getWeather(cityName, apiKey);
    }

}
