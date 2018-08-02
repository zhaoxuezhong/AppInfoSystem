package com.zxz.service;

import java.util.List;

import com.zxz.pojo.AppVersion;

public interface AppVersionService {
	
	int addAppVersion(AppVersion appVersion);
	
	int updateAppVersion(AppVersion appVersion);
	
	int deleteAppVersion(Integer appId);
	
	int deleteAPK(Integer id);
	
	AppVersion findAppVersion(Integer id);
	
	List<AppVersion> findAppVersionList(Integer appId);
}
