package com.goldze.mvvmhabit.data.source.user;

import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by ailibin on 2020/9/10.
 */
public interface HttpUserDataSource {

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);


}
