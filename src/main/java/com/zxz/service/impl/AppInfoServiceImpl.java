package com.zxz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.AppInfoMapper;
import com.zxz.dao.AppVersionMapper;
import com.zxz.pojo.AppInfo;
import com.zxz.pojo.AppVersion;
import com.zxz.service.AppInfoService;
import com.zxz.utils.PageInfo;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;
	@Resource
	private AppVersionMapper appVersionMapper;

	@Override
	public PageInfo<AppInfo> findAppInfo(AppInfo appInfo, Integer pageIndex, Integer pageSize) {
		PageInfo<AppInfo> pageInfo = new PageInfo<AppInfo>();
		Integer totalCount = appInfoMapper.getAppInfoCount(appInfo);
		if (null != totalCount && totalCount > 0) {
			pageInfo.setTotalCount(totalCount);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageIndex(pageIndex);
			pageInfo.setList(appInfoMapper.findAppInfoList(appInfo,
					(pageInfo.getPageIndex() - 1) * pageInfo.getPageSize(), pageInfo.getPageSize()));
		}
		return pageInfo;
	}

	@Override
	public AppInfo findAppInfoById(Integer id) {
		return appInfoMapper.findAppInfoById(id);
	}

	@Override
	public int addAppInfo(AppInfo appInfo) {
		return appInfoMapper.addAppInfo(appInfo);
	}

	@Override
	public int updateAppInfo(AppInfo appInfo) {
		return appInfoMapper.updateAppInfo(appInfo);
	}

	@Override
	public int deleteAppInfo(Integer id) {
		appVersionMapper.deleteAppVersion(id);
		return appInfoMapper.deleteAppInfo(id);
	}

	@Override
	public int deleteLogoPic(Integer id) {
		return appInfoMapper.deletePicById(id);
	}

	@Override
	public boolean apkExist(String aPKName) {
		AppInfo appInfo = new AppInfo();
		appInfo.setApkname(aPKName);
		return appInfoMapper.getAppInfoCount(appInfo) > 0;
	}

	@Override
	public boolean updateStatus(AppInfo appInfo) {
		AppInfo reAppInfo = appInfoMapper.findAppInfoById(appInfo.getId().intValue());
		AppVersion appVersion=new AppVersion();
		if(2==reAppInfo.getStatus()||5==reAppInfo.getStatus()){
			//审核通过时上架
			//下架时上架
			appInfo.setStatus(4L);
			appVersion.setId(reAppInfo.getVersionId());
			appVersion.setPublishStatus(2L);
			appVersion.setModifyBy(appInfo.getModifyBy());
			appVersion.setModifyDate(appInfo.getModifyDate());
			return appInfoMapper.updateAppInfo(appInfo)>0&&
					appVersionMapper.updateAppVersion(appVersion)>0;
		}
		else if(4==reAppInfo.getStatus()){
			//上架时下架
			appInfo.setStatus(5L);
			return appInfoMapper.updateAppInfo(appInfo)>0;
		}
		return false;
	}

}
