package com.example.rxjavawithcleancode.vm;

import androidx.lifecycle.MutableLiveData;

import com.example.rxjavawithcleancode.basevm.BaseVm;
import com.example.rxjavawithcleancode.domain.model.User;

public class RowUserInfoVm extends BaseVm {

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();


    public RowUserInfoVm(User user){
        user.setName(user.getName());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());

    }
}
