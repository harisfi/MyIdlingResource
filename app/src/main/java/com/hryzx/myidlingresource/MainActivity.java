package com.hryzx.myidlingresource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.hryzx.myidlingresource.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        activityMainBinding.button.setOnClickListener(v -> delay1());
    }

    private void delay1() {
        EspressoIdlingResource.increment();
        new Handler().postDelayed(() -> {
            activityMainBinding.textView.setText(getString(R.string.delay1));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, 2000);
    }
}