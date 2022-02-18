package com.example.countermvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.countermvvm.R;
import com.example.countermvvm.databinding.ActivityMainBinding;
import com.example.countermvvm.model.CounterViewModel;

public class MainActivity extends AppCompatActivity {
    CounterViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(MainActivity.this).get(CounterViewModel.class);
        initListeners();
        updateCounter();

    }

    private void updateCounter() {
        viewModel.updateCounter().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.numberTv.setText(s);
            }
        });
    }

    private void initListeners() {
        binding.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.decrement();
            }
        });
        binding.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.increment();
            }
        });
    }
}