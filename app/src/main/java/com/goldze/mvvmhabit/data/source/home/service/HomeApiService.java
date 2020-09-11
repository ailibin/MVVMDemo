package com.goldze.mvvmhabit.data.source.home.service;

import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ailibin on 2020/9/10.
 */

public interface HomeApiService {
    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    //添加头部参数
    @FormUrlEncoded
    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: huoapp"
    })
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);
}
