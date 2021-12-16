package com.grt.tally.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.grt.tally.R;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context) {
        super(context,"tally.db" , null, 1);
    }

//    创建数据库的方法，只有项目第一次运行时，会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
//        创建表示类型的表
        String sql = "create table typetb(id integer primary key autoincrement,typename varchar(10),imageId integer,sImageId integer,kind integer)";
        db.execSQL(sql);
        insertType(db);
        //创建记账表
        sql = "create table accounttb(id integer primary key autoincrement,typename varchar(10),sImageId integer,beizhu varchar(80),money float," +
                "time varchar(60),year integer,month integer,day integer,kind integer)";
        db.execSQL(sql);
    }

    private void insertType(SQLiteDatabase db) {
//      向typetb表当中插入元素
        String sql = "insert into typetb (typename,imageId,sImageId,kind) values (?,?,?,?)";
        db.execSQL(sql,new Object[]{"还款", R.mipmap.sort_huankuan,R.mipmap.sort_huankuan,0});
        db.execSQL(sql,new Object[]{"住房", R.mipmap.sort_zhufang,R.mipmap.sort_zhufang,0});
        db.execSQL(sql,new Object[]{"办公", R.mipmap.sort_bangong,R.mipmap.sort_bangong,0});
        db.execSQL(sql,new Object[]{"餐饮", R.mipmap.sort_canyin,R.mipmap.sort_canyin,0});
        db.execSQL(sql,new Object[]{"医疗", R.mipmap.sort_yiliao,R.mipmap.sort_yiliao,0});
        db.execSQL(sql,new Object[]{"运动", R.mipmap.sort_yundong,R.mipmap.sort_yundong,0});
        db.execSQL(sql,new Object[]{"宠物", R.mipmap.sort_chongwu,R.mipmap.sort_chongwu,0});
        db.execSQL(sql,new Object[]{"数码", R.mipmap.sort_shuma,R.mipmap.sort_shuma,0});
        db.execSQL(sql,new Object[]{"零食", R.mipmap.sort_lingshi,R.mipmap.sort_lingshi,0});
        db.execSQL(sql,new Object[]{"长辈", R.mipmap.sort_zhangbei,R.mipmap.sort_zhangbei,0});
        db.execSQL(sql,new Object[]{"礼物", R.mipmap.sort_liwu,R.mipmap.sort_liwu,0});
        db.execSQL(sql,new Object[]{"孩子", R.mipmap.sort_haizi,R.mipmap.sort_haizi,0});
        db.execSQL(sql,new Object[]{"旅行", R.mipmap.sort_lvxing,R.mipmap.sort_lvxing,0});
        db.execSQL(sql,new Object[]{"交通", R.mipmap.sort_jiaotong,R.mipmap.sort_jiaotong,0});
        db.execSQL(sql,new Object[]{"礼金", R.mipmap.sort_lijin,R.mipmap.sort_lijin,0});

        db.execSQL(sql,new Object[]{"工资", R.mipmap.sort_lijin,R.mipmap.sort_lijin,1});
        db.execSQL(sql,new Object[]{"礼金", R.mipmap.sort_jiangjin,R.mipmap.sort_jiangjin,1});
        db.execSQL(sql,new Object[]{"利息", R.mipmap.sort_lixi,R.mipmap.sort_lixi,1});
        db.execSQL(sql,new Object[]{"理财", R.mipmap.sort_fanxian,R.mipmap.sort_fanxian,1});
        db.execSQL(sql,new Object[]{"兼职", R.mipmap.sort_jianzhi,R.mipmap.sort_jianzhi,1});
    }

    // 数据库版本在更新时发生改变，会调用此方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
