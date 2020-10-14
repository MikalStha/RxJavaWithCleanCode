package com.example.rxjavawithcleancode.vm;

import androidx.lifecycle.MutableLiveData;

import com.example.rxjavawithcleancode.basevm.BaseVm;
import com.example.rxjavawithcleancode.domain.interactor.UserInfoUc;
import com.example.rxjavawithcleancode.domain.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserInfoVm extends BaseVm {

    private final UserInfoUc mUserInfoUseCase;

    public MutableLiveData<Boolean> hasData = new MutableLiveData<>();
    public MutableLiveData<List<User>> userList = new MutableLiveData();


    public UserInfoVm(UserInfoUc userInfoUseCase) {
        this.hasData.setValue(false);
        this.mUserInfoUseCase = userInfoUseCase;
    }

    public void fetchUserInfo() {
        loading.setValue(true);
        disposables.add(mUserInfoUseCase.getUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userInfoApi -> {
                    loading.setValue(false);
                    if (userInfoApi != null) {
                        hasData.setValue(true);
                        this.userList.setValue(userInfoApi);
                    } else {
                        hasData.setValue(false);
                        this.userList.setValue(new ArrayList());

                    }
                }, throwable -> {
                    loading.setValue(false);
                    hasData.setValue(false);
                    this.userList.setValue(new ArrayList());

                }));
    }
}
