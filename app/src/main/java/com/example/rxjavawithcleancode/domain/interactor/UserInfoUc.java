package com.example.rxjavawithcleancode.domain.interactor;

import com.example.rxjavawithcleancode.domain.model.User;
import com.example.rxjavawithcleancode.domain.repository.UserInfoRepo;

import java.util.List;

import io.reactivex.Observable;

public class UserInfoUc {

    private final UserInfoRepo userInfoRepo;

    public UserInfoUc(UserInfoRepo userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

    public Observable<List<User>> getUserInfo() {
        return userInfoRepo.getUserInfoApi();
    }

}
