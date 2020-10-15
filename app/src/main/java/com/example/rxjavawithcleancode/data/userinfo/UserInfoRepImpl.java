package com.example.rxjavawithcleancode.data.userinfo;

import com.example.rxjavawithcleancode.api.ApiClient;
import com.example.rxjavawithcleancode.api.EndPoint;
import com.example.rxjavawithcleancode.data.base.RepoImpl;
import com.example.rxjavawithcleancode.domain.model.User;
import com.example.rxjavawithcleancode.domain.repository.UserInfoRepo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;

public class UserInfoRepImpl extends RepoImpl implements UserInfoRepo {

    List<User> userInfoApi;
    public UserInfoRepImpl(EndPoint endpoint) {
        mEndpoint = endpoint;
    }

    @Override
    public Observable<List<User>> getUserInfoApi() {
        if ( userInfoApi== null ) {

            return getUserInfoFromServer();

        }
        return Observable.just(userInfoApi);

    }

    private Observable<List<User>> getUserInfoFromServer() {

      //  mEndpoint = ApiClient.getInstance().create(EndPoint.class);

       // mEndpoint.getUsers().

        return  mEndpoint.getUsers();
    }
}
