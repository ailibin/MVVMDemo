package com.goldze.mvvmhabit.database.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.goldze.mvvmhabit.database.UserDao;
import com.goldze.mvvmhabit.database.model.User;

/**
 * @author ailibin
 * @date: 2020/09/11
 * @description: 数据库表
 */
@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
