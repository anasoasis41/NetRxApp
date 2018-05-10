package com.riahi.netapp.Utils;

import com.riahi.netapp.models.GithubUser;
import com.riahi.netapp.models.GithubUserInfo;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by iSDT-Anas on 23/04/2018.
 */

public interface GithubService {

    @GET("users/{username}/following")
    Observable<List<GithubUser>> getFollowing(@Path("username") String username);

    @GET("/users/{username}")
    Observable<GithubUserInfo> getUserInfos(@Path("username") String username);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
