package com.goldze.mvvmhabit.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author ailibin
 * @date: 2020/09/11
 * @description: 数据库管理实体类
 */
@Entity
public class User {
    @PrimaryKey
    @ColumnInfo(name="uid")
    public long userId;

    @ColumnInfo(name="first_name")
    public String firstName;

    @ColumnInfo(name="last_name")
    public String lastName;

    @ColumnInfo(name="user_name")
    public String userName;

    @ColumnInfo(name="password")
    public String password;

    @ColumnInfo(name="mobile")
    public String mobile;


}
