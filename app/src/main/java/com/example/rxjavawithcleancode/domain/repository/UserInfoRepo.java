package com.example.rxjavawithcleancode.domain.repository;

import com.example.rxjavawithcleancode.domain.model.User;

import java.util.List;

import io.reactivex.Observable;

public interface UserInfoRepo
{

    Observable<List<User>> getUserInfoApi();
}
