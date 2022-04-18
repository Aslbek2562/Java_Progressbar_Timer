package com.fourcade7.java_progressbar_style_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.fourcade7.java_progressbar_style_timer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    CountDownTimer cTimer = null;
    long a=0;
    int t=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button1.setOnClickListener(view -> {
            cTimer = new CountDownTimer(5000, 100) {
                public void onTick(long millisUntilFinished) {
                    t++;
                    binding.textview1.setText(t+" %");
                    binding.textview2.setText(t+" %");
                    binding.progressbar1.setProgress(t);
                    binding.progressbar2.setProgress(t);
                }
                public void onFinish() {
                }
            };
            cTimer.start();

        });
        binding.button3.setOnClickListener(view -> {
            cTimer.cancel();
            binding.textview1.setText("00:00");
            t=0;
        });
    }
}