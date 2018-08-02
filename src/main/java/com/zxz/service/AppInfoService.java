package com.zxz.service;

import com.zxz.pojo.AppInfo;
import com.zxz.utils.PageInfo;

public interface AppInfoService {
	
	AppInfo findAppInfoById(Integer id);
	
	int addAppInfo(AppInfo appInfo);
	
	int updateAppInfo(AppInfo appInfo);
	
	int deleteAppInfo(Integer id);
	
	int deleteLogoPic(Integer id);

	PageInfo<AppInfo> findAppInfo(AppInfo appInfo,Integer pageIndex,Integer pageSize);

	boolean apkExist(String aPKName);
	
	boolean updateStatus(AppInfo appInfo);
}
