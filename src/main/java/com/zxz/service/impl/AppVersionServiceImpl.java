package com.zxz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.AppInfoMapper;
import com.zxz.dao.AppVersionMapper;
import com.zxz.pojo.AppInfo;
import com.zxz.pojo.AppVersion;
import com.zxz.service.AppVersionService;

@Service
public class AppVersionServiceImpl implements AppVersionService {
	@Resource
	private AppVersionMapper appVersionMapper;
	@Resource
	private AppInfoMapper appInfoMapper;
	
	@Override
	public int addAppVersion(AppVersion appVersion) {
		AppInfo appInfo=new AppInfo();
		appInfo.setId(appVersion.getAppId());
		appVersionMapper.addAppVersion(appVersion);
		appInfo.setVersionId(appVersion.getId());
		return appInfoMapper.updateAppInfo(appInfo);
	}

	@Override
	public int updateAppVersion(AppVersion appVersion) {
		return appVersionMapper.updateAppVersion(appVersion);
	}

	@Override
	public int deleteAppVersion(Integer appId) {
		return appVersionMapper.deleteAppVersion(appId);
	}

	@Override
	public AppVersion findAppVersion(Integer id) {
		return appVersionMapper.findAppVersion(id);
	}

	@Override
	public List<AppVersion> findAppVersionList(Integer appId) {
		return appVersionMapper.findAppVersionList(appId);
	}

	@Override
	public int deleteAPK(Integer id) {
		return appVersionMapper.deleteAPK(id);
	}

}
