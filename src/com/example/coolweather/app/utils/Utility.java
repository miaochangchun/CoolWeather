package com.example.coolweather.app.utils;

import android.text.TextUtils;

import com.example.coolweather.app.model.City;
import com.example.coolweather.app.model.CoolWeatherDB;
import com.example.coolweather.app.model.County;
import com.example.coolweather.app.model.Province;

public class Utility {
	/**
	 * �����ʹ����ص�ʡ������
	 * @param coolWeatherDB		���ݿ�����
	 * @param response			���ص���������
	 * @return
	 */
	public synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB, String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces = response.split(",");
			if(allProvinces != null && allProvinces.length > 0){
				for(String pString : allProvinces){
					String[] array = pString.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//���������������ݴ洢��Province��
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * ��ж�ʹ�����������ص��м�����
	 * @param coolWeatherDB		���ݿ�����
	 * @param response			��������������
	 * @param provinceId		ѡ�е�ʡ��Id��
	 * @return
	 */
	public synchronized static boolean handleCityResponse(CoolWeatherDB coolWeatherDB, String response, int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities = response.split(",");
			if(allCities != null && allCities.length > 0){
				for(String pString : allCities){
					String[] array = pString.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//���������������ݴ洢��City��
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * �����ʹ����ص��ؼ����ݿ�
	 * @param coolWeatherDB	���ݿ�����
	 * @param response		���ص�����
	 * @param cityId		ѡ�еĳ���id��
	 * @return
	 */
	public synchronized static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB, String response, int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCounties = response.split(",");
			if(allCounties != null && allCounties.length > 0){
				for(String pString : allCounties){
					String[] array = pString.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					//���������������ݴ洢��County��
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
}
