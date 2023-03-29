package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.weatherapp.ModelInJava.ModelResponse;
import com.example.weatherapp.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface apiInterface = retrofit.create(WeatherInterface.class);
        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = ProgressDialog.show(MainActivity.this, "Loading", "Please wait...", true);

                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                if (!binding.et.getText().toString().trim().equals("")) {
                    Call<ModelResponse> call = apiInterface.getWeather(binding.et.getText().toString(), "9149a4b800b22d122db23466a39b3989", "metric");
                     call.enqueue(new Callback<ModelResponse>() {
                         @Override
                         public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {

                             if (response != null && response.body() != null) {

                                 ModelResponse mresponse = response.body();
//                                Toast.makeText(MainActivity.this, mresponse.toString(), Toast.LENGTH_LONG).show();
                                 Log.d("1234", "onFailure: " + mresponse);
                                 progressDialog.dismiss();
                                 binding.temp.setText(mresponse.getMain().getTemp() + " " + "℃");
                                 binding.forecastText.setText(mresponse.getWeather().get(0).getMain() + " ");
                                 binding.city.setText("    " + mresponse.getName() + "   , ");
                                 binding.minimumTemp.setText(" " + mresponse.getMain().getTemp_min() + " " + "℃");
                                 binding.maximumTemp.setText(" " + mresponse.getMain().getTemp_max() + " " + "℃");
                                 binding.wind.setText("  " + String.format("%.2f", mresponse.getWind().getSpeed() * 1.58) + " " + " km/hr ");

                                 binding.humid.setText(" " + mresponse.getMain().getHumidity() + " ");
                                 Long rise = Long.valueOf(mresponse.getSys().getSunrise());

                                 String sunrise = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(rise * 1000));
                                 binding.sunrise.setText(sunrise);

                                 Long set = Long.valueOf(mresponse.getSys().getSunset());

                                 String sunset = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(set * 1000));

                                 binding.sunset.setText(sunset);
                                 String fimg=String.valueOf(mresponse.getWeather().get(0).getMain());
                                 if(fimg.equals("Thunderstorm")){
                                     binding.forecastImg.setImageResource(R.drawable.thunderstorm);
                                 }




                                 binding.moreDetails.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent intent = new Intent(MainActivity.this, MoreDetailsActivity.class);
                                         intent.putExtra("city", mresponse.getName());


                                         Long rise = Long.valueOf(mresponse.getSys().getSunrise());

                                         String sunrise = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(rise * 1000));
                                         intent.putExtra("sunrise",sunrise);
                                         Long set = Long.valueOf(mresponse.getSys().getSunset());

                                         String sunset = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(set * 1000));
                                         intent.putExtra("sunset",sunset);

                                         long unixSeconds = Long.valueOf(mresponse.getDt());
                                         Date date = new Date(unixSeconds * 1000L);
                                         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z", Locale.ENGLISH);
                                         sdf.setTimeZone(TimeZone.getDefault());
                                         String formattedDate = sdf.format(date);
                                         intent.putExtra("date",formattedDate);
                                         intent.putExtra("temp",mresponse.getMain().getTemp());
                                         intent.putExtra("feels like",mresponse.getMain().getFeels_like());
                                         intent.putExtra("humid",mresponse.getMain().getHumidity());
                                         intent.putExtra("visible",mresponse.getVisibility());
                                         intent.putExtra("press",mresponse.getMain().getPressure());

                                         startActivity(intent);
                                     }
                                 });

                             }
                         }
                         @Override
                         public void onFailure(Call<ModelResponse> call, Throwable t) {
                             Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                             Log.d("1234", "onFailure: " + t.getLocalizedMessage());
                             progressDialog.dismiss();
                         }
                     });
                } else {
                    binding.city.setError("please enter valid city name");
                    progressDialog.dismiss();
                }
                binding.city.setText("");


            }
        });


    }
}
