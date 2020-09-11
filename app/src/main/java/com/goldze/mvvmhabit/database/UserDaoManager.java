package com.goldze.mvvmhabit.database;


import android.content.Context;

import androidx.room.Room;

import com.goldze.mvvmhabit.database.data.AppDatabase;

/**
 * @author ailibin
 * @date: 2020/09/11
 * @description: 数据库管理者
 */
public class UserDaoManager {

    public static AppDatabase db;

    private static class SingletonHolder {
        private static UserDaoManager INSTANCE = new UserDaoManager();
    }

    public static UserDaoManager getInstance() {
        return UserDaoManager.SingletonHolder.INSTANCE;
    }

    //初始化用户数据库表
    public void initDataBase(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, "database-user").build();
    }

    public static AppDatabase getDb() {
        return db;
    }
}
