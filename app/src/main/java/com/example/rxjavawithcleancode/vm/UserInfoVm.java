package com.example.rxjavawithcleancode.vm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.rxjavawithcleancode.basevm.BaseVm;
import com.example.rxjavawithcleancode.domain.interactor.UserInfoUc;
import com.example.rxjavawithcleancode.domain.model.User;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

public class UserInfoVm extends BaseVm {

    private final UserInfoUc mUserInfoUseCase;
    public final Retrofit mRetrofit;

    public MutableLiveData<Boolean> hasData = new MutableLiveData<>();
    public MutableLiveData<List<User>> userList = new MutableLiveData();

    public UserInfoVm(UserInfoUc userInfoUseCase,Retrofit retrofit) {
        this.hasData.setValue(false);
        this.mUserInfoUseCase = userInfoUseCase;
        this.mRetrofit = retrofit;

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
                    User userInfoApi = new User();

                    if (throwable instanceof HttpException) {
                        ResponseBody body = ((HttpException) throwable).response().errorBody();
                        Converter<ResponseBody, User> converter = mRetrofit.responseBodyConverter(User.class, new Annotation[0]);
                        try {
                            userInfoApi = converter.convert(body);
                        } catch (IOException | NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                    this.userList.setValue((List<User>) userInfoApi);
                }));
    }
}
