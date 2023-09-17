package com.example.pureweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.pureweather.databinding.ActivityMainBinding;
import com.example.pureweather.model.Weather_App;
import com.example.pureweather.viewmodel.Weather_ViewModel;

public class MainActivity extends AppCompatActivity {

    private String selectedCountry, selectedState, selectedCity;
    private ActivityMainBinding activityMainBinding;
    private Weather_ViewModel weather_viewModel;
    private static final String API_KEY = "9267268e4149ea055bee22911d6592dc";
    private ArrayAdapter<CharSequence> countryAdapter, stateAdapter, cityAdapter;
    private Weather_App weatherApp = new Weather_App();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        weather_viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(Weather_ViewModel.class);

        spinnerSelectingTask();

        activityMainBinding.searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                weatherApp = weather_viewModel.getWeather(selectedCity, API_KEY);
//                activityMainBinding.setWeatherapp(weatherApp);

                weatherApp = weather_viewModel.getWeather(selectedCity, "9267268e4149ea055bee22911d6592dc");
                activityMainBinding.setMain(weatherApp.getMain());
                activityMainBinding.setWind(weatherApp.getWind());
                try {
                    activityMainBinding.setWeather(weatherApp.getWeather().get(0));
                }catch (Exception e){
                    Log.d("ArrayGsonError", e.getMessage());
                }

            }
        });



    }
    private void spinnerSelectingTask() {

        //populate countryAdapter & set to country spinner
        countryAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.array_world_countries, R.layout.spinner_layout);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityMainBinding.countrySpinner.setAdapter(countryAdapter);

        activityMainBinding.countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = parent.getSelectedItem().toString();
                int countryId = parent.getId();

                if (countryId == R.id.countrySpinner){
                    switch (selectedCountry){
                        case "Afghanistan":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_afghanistan_states,R.layout.spinner_layout);
                            break;
                        case "Albania":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_albania_states,R.layout.spinner_layout);
                            break;
                        case "Bahamas":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_bahamas_states,R.layout.spinner_layout);
                            break;
                        case "Cambodia":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_cambodia_states,R.layout.spinner_layout);
                            break;
                        case"Canada":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_canada_states,R.layout.spinner_layout);
                            break;
                        case "Denmark":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_Denmark_states,R.layout.spinner_layout);
                            break;
                        case"Egypt":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_Egypt_states,R.layout.spinner_layout);
                            break;
                        case"India":
                            stateAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_indian_states,R.layout.spinner_layout);
                            break;
                        default:
                            break;
                    }
                }

                //populate stateAdapter & set to country spinner
                stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                activityMainBinding.stateSpinner.setAdapter(stateAdapter);

                activityMainBinding.stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selectedState = parent.getSelectedItem().toString();

                        if (parent.getId() == R.id.stateSpinner){
//                            if (selectedCountry.equals("Afghanistan") && selectedState.equals("Badakhshan")){
//                                cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Badakhshan_cities, R.layout.spinner_bg);
//                            } else if (selectedCountry.equals("Afghanistan") && selectedState.equals("Badghis")) {
//                                cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Badghis_cities, R.layout.spinner_bg);
//                            }
                            if (selectedCountry.equals("Afghanistan")){

                                switch (selectedState){
                                    case "Badakhshan":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Badakhshan_cities, R.layout.spinner_bg);
                                        break;
                                    case"Badghis":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Badghis_cities, R.layout.spinner_bg);
                                        break;
                                    case"Baghlan":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Baghlan_cities, R.layout.spinner_bg);
                                        break;
                                    case"Balkh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Balkh_cities, R.layout.spinner_bg);
                                        break;
                                    case"Bamyan":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Bamyan_cities, R.layout.spinner_bg);
                                        break;
                                    case"Daykundi":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Daykundi_cities, R.layout.spinner_bg);
                                        break;
                                    case"Farah":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Farah_cities, R.layout.spinner_bg);
                                        break;
                                    case"Faryab":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Faryab_cities, R.layout.spinner_bg);
                                        break;
                                    case"Ghazni":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Ghazni_cities, R.layout.spinner_bg);
                                        break;
                                    case"Helmand":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.afghanistan_Helmand_cities, R.layout.spinner_bg);
                                        break;
                                    default:
                                        break;
                                }
                            }

                            if (selectedCountry.equals("Albania")){

                                switch (selectedState){
                                    case "Berat":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.albania_berat_cities, R.layout.spinner_bg);
                                        break;
                                    case "Elbasan":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.albania_Elbasan_cities, R.layout.spinner_bg);
                                        break;
                                    case "Fier":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.albania_Fier_cities, R.layout.spinner_bg);
                                        break;
                                    default:
                                        break;

                                }

                            }

                            if (selectedCountry.equals("Bahamas")){
                                switch (selectedState){
                                    case "Andros":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.bahamas_Andros_cities, R.layout.spinner_bg);
                                        break;
                                    case "Berry Islands":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.bahamas_Berry_Islands_cities, R.layout.spinner_bg);
                                        break;
                                    case "Bimini":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.bahamas_Bimini_cities, R.layout.spinner_bg);
                                        break;
                                    case "Cat Island":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.bahamas_Cat_Island_cities, R.layout.spinner_bg);
                                        break;
                                    default:
                                        break;
                                }


                            }

                            if (selectedCountry.equals("Cambodia")){
                                if (selectedState.equals("Kampot")) {
                                    cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.cambodia_Kampot_cities, R.layout.spinner_bg);
                                }
                            }

                            if (selectedCountry.equals("Canada")){
                                switch (selectedState){
                                    case "Alberta":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.canada_Alberta_cities, R.layout.spinner_bg);
                                        break;
                                    case "British Columbia":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.canada_British_Columbia_cities, R.layout.spinner_bg);
                                        break;
                                    case "Manitoba":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.canada_Manitoba_cities, R.layout.spinner_bg);
                                        break;
                                    default:
                                        break;

                                }

                            }

                            if (selectedCountry.equals("Denmark")){
                                switch (selectedState){
                                    case "Central Denmark Region":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.denmark_Central_Denmark_Region_cities, R.layout.spinner_bg);
                                        break;
                                    case "North Denmark Region":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.denmark_North_Denmark_Region_cities, R.layout.spinner_bg);
                                        break;
                                    default:
                                        break;

                                }
                            }

                            if (selectedCountry.equals("Egypt")){
                                switch (selectedState){
                                    case "Giza":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_Giza_cities, R.layout.spinner_bg);
                                        break;
                                    case "Ismailia":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_Ismailia_cities, R.layout.spinner_bg);
                                        break;
                                    case "Luxor":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_Luxor_cities, R.layout.spinner_bg);
                                        break;
                                    case "Matrouh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_Matrouh_cities, R.layout.spinner_bg);
                                        break;
                                    case "Minya":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_Minya_cities, R.layout.spinner_bg);
                                        break;
                                    case "Monufia":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_Monufia_cities, R.layout.spinner_bg);
                                        break;
                                    case "New Valley":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.egypt_New_Valley_cities, R.layout.spinner_bg);
                                        break;
                                    default:
                                        break;
                                }

                            }

                            if (selectedCountry.equals("India")){
                                switch (selectedState) {
                                    case "Andaman and Nicobar Islands":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_andaman_nicobar_districts,R.layout.spinner_layout);
                                        break;

                                    case "Andhra Pradesh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_andhra_pradesh_districts,R.layout.spinner_layout);
                                        break;

                                    case "Arunachal Pradesh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_arunachal_pradesh_districts,R.layout.spinner_layout);
                                        break;

                                    case "Assam":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_assam_districts,R.layout.spinner_layout);
                                        break;

                                    case "Bihar":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_bihar_districts,R.layout.spinner_layout);
                                        break;

                                    case "Chandigarh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_chandigarh_districts,R.layout.spinner_layout);
                                        break;

                                    case "Chhattisgarh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_chhattisgarh_districts,R.layout.spinner_layout);
                                        break;

                                    case "Dadra and Nagar Haveli":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_dadra_nagar_haveli_districts,R.layout.spinner_layout);
                                        break;

                                    case "Daman and Diu":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_daman_diu_districts,R.layout.spinner_layout);
                                        break;

                                    case "Delhi":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_delhi_districts,R.layout.spinner_layout);
                                        break;

                                    case"Haryana":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_haryana_districts,R.layout.spinner_layout);
                                        break;

                                    case"Himachal Pradesh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_himachal_pradesh_districts,R.layout.spinner_layout);
                                        break;

                                    case"Jammu and Kashmir":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_jammu_kashmir_districts,R.layout.spinner_layout);
                                        break;

                                    case"Jharkhand":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_jharkhand_districts,R.layout.spinner_layout);
                                        break;

                                    case"Karnataka":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_karnataka_districts,R.layout.spinner_layout);
                                        break;

                                    case"Kerala":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_kerala_districts,R.layout.spinner_layout);
                                        break;

                                    case"Ladakh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_ladakh_districts,R.layout.spinner_layout);
                                        break;

                                    case"Lakshadweep":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_lakshadweep_districts,R.layout.spinner_layout);
                                        break;

                                    case"Madhya Pradesh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_madhya_pradesh_districts,R.layout.spinner_layout);
                                        break;

                                    case"Maharashtra":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_maharashtra_districts,R.layout.spinner_layout);
                                        break;

                                    case"Manipur":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_manipur_districts,R.layout.spinner_layout);
                                        break;

                                    case"Meghalaya":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_meghalaya_districts,R.layout.spinner_layout);
                                        break;

                                    case"Mizoram":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_mizoram_districts,R.layout.spinner_layout);
                                        break;

                                    case"Nagaland":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_nagaland_districts,R.layout.spinner_layout);
                                        break;

                                    case"Orissa":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_odisha_districts,R.layout.spinner_layout);
                                        break;

                                    case"Puducherry":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_puducherry_districts,R.layout.spinner_layout);
                                        break;

                                    case"Punjab":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_punjab_districts,R.layout.spinner_layout);
                                        break;

                                    case"Rajasthan":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_rajasthan_districts,R.layout.spinner_layout);
                                        break;

                                    case"Sikkim":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_sikkim_districts,R.layout.spinner_layout);
                                        break;

                                    case"Tamil Nadu":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_tamil_nadu_districts,R.layout.spinner_layout);
                                        break;

                                    case"Telangana":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_telangana_districts,R.layout.spinner_layout);
                                        break;

                                    case"Tripura":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_tripura_districts,R.layout.spinner_layout);
                                        break;

                                    case"Uttarakhand":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_uttarakhand_districts,R.layout.spinner_layout);
                                        break;

                                    case"Uttar Pradesh":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_uttar_pradesh_districts,R.layout.spinner_layout);
                                        break;

                                    case"West Bengal":
                                        cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_west_bengal_districts,R.layout.spinner_layout);
                                        break;

                                    default:
                                        break;

                                }
                            }

                        }

                        //populate cityAdapter & set to city spinner
                        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        activityMainBinding.citySpinner.setAdapter(cityAdapter);

                        activityMainBinding.citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                selectedCity = parent.getSelectedItem().toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}