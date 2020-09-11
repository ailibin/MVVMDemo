package com.goldze.mvvmhabit.data.source.user.service;

import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ailibin on 2020/9/10.
 */

//@FieldMap必须与 @FormUrlEncoded 一起配合使用
//提交的Content-Type 为application/x-www-form-urlencoded
//@Body 提交的提交的Content-Type 为application/json; charset=UTF-8
public interface UserApiService {

    @FormUrlEncoded
    @POST("app/app/appinit")
    Observable<BaseResponse<DemoEntity>> init(@Field("open_cnt") int cnt);

//    static Future<Map<String, dynamic>> init() async {
//        Response<Map<String, dynamic>> response =
//                await CommonDio.dio.post("app/app/appinit", data: {"open_cnt": 1});
//        return response.data;
//    }

}
