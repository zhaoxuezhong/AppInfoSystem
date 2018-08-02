package com.zxz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AppVersion;

public interface AppVersionMapper {

	int addAppVersion(AppVersion appVersion);
	
	int updateAppVersion(AppVersion appVersion);
	
	int deleteAppVersion(Integer appId);
	
	int deleteAPK(Integer id);
	
	AppVersion findAppVersion(Integer id);
	
	int getAppVersionCount(Integer appId);
	
	List<AppVersion> findAppVersionList(@Param("appId")Integer appId);
}
