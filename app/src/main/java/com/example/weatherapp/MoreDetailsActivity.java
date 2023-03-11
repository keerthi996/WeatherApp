package com.example.weatherapp;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.databinding.MoreDetailsBinding;

public class MoreDetailsActivity extends AppCompatActivity {
    private MoreDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MoreDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String cityName=getIntent().getStringExtra("city");
        String rise=getIntent().getStringExtra("sunrise");
        String set=getIntent().getStringExtra("sunset");
        String date=getIntent().getStringExtra("date");
        double temperature=getIntent().getDoubleExtra("temp",0.0);
        double feels=getIntent().getDoubleExtra("feels like",0.0);
        double humidity=getIntent().getDoubleExtra("humid",0.0);
        double visibility=getIntent().getDoubleExtra("visible",0.0);
        double pressure=getIntent().getDoubleExtra("press",0.0);

        if(cityName!=null){
            binding.tvCityName.setText(cityName);
            binding.sunrise.setText(rise);
            binding.sunset.setText(set);
            binding.date.setText(date);
            binding.temperature.setText(String.valueOf(temperature));
            binding.feel.setText(String.valueOf(feels));
            binding.humidity.setText(String.valueOf(humidity));
            binding.visibility.setText(String.valueOf(visibility));
            binding.pressure.setText(String.valueOf(pressure));

        }
    }
}
