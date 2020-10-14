package com.example.rxjavawithcleancode.basevm;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseVm  extends ViewModel implements LifecycleObserver {

    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    protected final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
