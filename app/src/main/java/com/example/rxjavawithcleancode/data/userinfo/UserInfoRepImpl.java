package com.example.rxjavawithcleancode.data.userinfo;

import com.example.rxjavawithcleancode.api.EndPoint;
import com.example.rxjavawithcleancode.data.base.RepoImpl;
import com.example.rxjavawithcleancode.domain.model.User;
import com.example.rxjavawithcleancode.domain.repository.UserInfoRepo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class UserInfoRepImpl extends RepoImpl implements UserInfoRepo {


    List<User> userInfoApi=new ArrayList<>();
    public UserInfoRepImpl(EndPoint endpoint) {
        mEndpoint = endpoint;
    }

    @Override
    public Observable<List<User>> getUserInfoApi() {
        if ( userInfoApi== null ) {
            return getUserInfoFromServer();
        }
    //   return  Observable.create();
        return null; //null return to avoid error now
    }

    private Observable<List<User>> getUserInfoFromServer() {

        /*mEndpoint.getUsers().map(userInfoApi -> {


        });
        return userInfoApi;
    }*/
        return null; //null return to avoid error now

    }

}
