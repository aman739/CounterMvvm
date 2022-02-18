package com.example.countermvvm.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class CounterViewModel extends ViewModel {
    MutableLiveData<String> count = new MutableLiveData<>();
    private int _amount;
    private int color;

    public MutableLiveData<String> increment() {
        count.setValue(String.valueOf(_amount++));
        return count;

    }

    public MutableLiveData<String> decrement() {
        count.postValue(String.valueOf(_amount--));
        return count;

    }

    public MutableLiveData<String> updateCounter() {
        return count;
    }


}
