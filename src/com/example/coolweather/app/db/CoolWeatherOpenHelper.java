package com.example.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{

	/**
	 * 创建省份数据库的语法
	 */
	public static final String CREATE_PROVINCE = "create table Province(" +
			"id integer primary key autoincrement," +
			"province_name text," +
			"province_code text);";
	/**
	 * 创建市级数据库的语法
	 */
	public static final String CREATE_CITY = "create table City(" +
			"id integer primary key autoincrement," +
			"city_name text," +
			"city_code text," +
			"province_id integer);";
	/**
	 * 创建县级数据库的语法
	 */
	public static final String CREATE_COUNTY = "create table County(" +
			"id integer primary key autoincrement," +
			"county_name text," +
			"county_code text," +
			"city_id integer);";
	
	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE);	//创建省级数据库
		db.execSQL(CREATE_CITY);		//创建市级数据库
		db.execSQL(CREATE_COUNTY);		//创建县级数据库
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
