package com.example.rxjavawithcleancode.api;

import com.example.rxjavawithcleancode.domain.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EndPoint {
    /*@GET("users")
    Observable<List<UserDetails>> getUserInfoApi(@Url String url);*/

    @GET("users")
    Observable<List<User>> getUsers();
}
