package com.goldze.mvvmhabit.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.goldze.mvvmhabit.data.source.HttpDataSource;
import com.goldze.mvvmhabit.data.source.LocalDataSource;
import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class HomeRepository extends BaseModel implements HttpDataSource {
    private volatile static HomeRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private HomeRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static HomeRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (HomeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HomeRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<Object> login() {
        return mHttpDataSource.login();
    }

    @Override
    public Observable<DemoEntity> loadMore() {
        return mHttpDataSource.loadMore();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return mHttpDataSource.demoPost(catalog);
    }

}
