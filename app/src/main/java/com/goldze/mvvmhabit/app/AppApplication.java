package com.goldze.mvvmhabit.app;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.room.Room;

import com.goldze.mvvmhabit.BuildConfig;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.database.UserDaoManager;
import com.goldze.mvvmhabit.database.data.AppDatabase;
import com.goldze.mvvmhabit.ui.login.LoginActivity;
import com.squareup.leakcanary.LeakCanary;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * Created by goldze on 2017/7/16.
 */

public class AppApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        // 主要是添加下面这句代码
        MultiDex.install(this);
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //是否开启打印日志
        KLog.init(BuildConfig.DEBUG);
        //初始化全局异常崩溃
        initCrash();
        //内存泄漏检测
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
        //初始化用户数据库
        UserDaoManager.getInstance().initDataBase(getApplicationContext());
    }



    private void initCrash() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(LoginActivity.class) //重新启动后的activity
//                .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
//                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }

}
