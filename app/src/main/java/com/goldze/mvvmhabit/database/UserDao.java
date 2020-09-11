package com.goldze.mvvmhabit.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.goldze.mvvmhabit.database.model.User;

import java.util.List;

/**
 * @author ailibin
 * @date: 2020/09/11
 * @description: 数据库操作room database
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("SELECT * FROM user WHERE user_name LIKE :userName  LIMIT 1")
    User findByName(String userName);

    //可以插入一个或者多个user
    @Insert
    void insertAll(User... users);

    //删除一个用户数据
    @Delete
    void delete(User user);

}
