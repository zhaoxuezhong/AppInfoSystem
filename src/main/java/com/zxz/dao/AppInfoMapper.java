package com.zxz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AppInfo;

public interface AppInfoMapper {
	
	AppInfo findAppInfoById(Integer id);
	
	int addAppInfo(AppInfo appInfo);
	
	int updateAppInfo(AppInfo appInfo);
	
	int deleteAppInfo(Integer id);
	
	int deletePicById(Integer id);
	
	int getAppInfoCount(AppInfo appInfo);

	List<AppInfo> findAppInfoList(@Param("appInfo") AppInfo appInfo,
			@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	
}
