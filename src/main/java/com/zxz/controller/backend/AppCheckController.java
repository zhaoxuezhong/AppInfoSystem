package com.zxz.controller.backend;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxz.controller.BaseController;
import com.zxz.pojo.AppCategory;
import com.zxz.pojo.AppInfo;
import com.zxz.pojo.AppVersion;
import com.zxz.pojo.BackendUser;
import com.zxz.pojo.DataDictionary;
import com.zxz.service.AppCategoryService;
import com.zxz.service.AppInfoService;
import com.zxz.service.AppVersionService;
import com.zxz.service.DataDictionaryService;
import com.zxz.utils.Constants;
import com.zxz.utils.PageInfo;

@Controller
@RequestMapping(value = "/backend/app")
public class AppCheckController extends BaseController<BackendUser> {
	@Resource
	private AppInfoService appInfoServiceImpl;
	@Resource
	private AppCategoryService appCategoryServiceImpl;
	@Resource
	private DataDictionaryService dataDictionaryServiceImpl;
	@Resource
	private AppVersionService appVersionServiceImpl;
	

	@RequestMapping(value = "list")
	public String auditingList(@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "5") Integer pageSize, AppInfo appInfo, Model model) {
		if (appInfo == null)
			appInfo = new AppInfo();
		appInfo.setStatus(1L);
		PageInfo<AppInfo> appInfoList = appInfoServiceImpl.findAppInfo(appInfo, pageIndex, pageSize);
		model.addAttribute("appInfoList", appInfoList);
		List<AppCategory> categoryLevel1List = appCategoryServiceImpl.findAppCategoryByParentId(null);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		if (appInfo.getCategoryLevel2() != null && appInfo.getCategoryLevel3() != null) {
			List<AppCategory> categoryLevel2List = appCategoryServiceImpl
					.findAppCategoryByParentId(appInfo.getCategoryLevel1().intValue());
			model.addAttribute("categoryLevel2List", categoryLevel2List);
			List<AppCategory> categoryLevel3List = appCategoryServiceImpl
					.findAppCategoryByParentId(appInfo.getCategoryLevel2().intValue());
			model.addAttribute("categoryLevel3List", categoryLevel3List);
		}
		List<DataDictionary> flatformList = dataDictionaryServiceImpl
				.findDataDictionaryByTypeCode(Constants.APP_FLATFORM);
		model.addAttribute("flatFormList", flatformList);
		return "backend/applist";
	}

	// 查询分类信息
	@RequestMapping(value = "categorylevellist.json")
	@ResponseBody
	public List<AppCategory> queryCategoryList(@RequestParam(required = false) Integer pid) {
		return appCategoryServiceImpl.findAppCategoryByParentId(pid);
	}
	
	@RequestMapping(value="check")
	public String checkApp(Integer aid,Integer vid,Model model){
		AppInfo appInfo=appInfoServiceImpl.findAppInfoById(aid);
		model.addAttribute("appInfo", appInfo);
		AppVersion appVersion=appVersionServiceImpl.findAppVersion(vid);
		model.addAttribute("appVersion", appVersion);
		return "backend/appcheck";
	}
	
	@RequestMapping(value="checksave")
	public String checksave(AppInfo appInfo){
		try {
			appInfoServiceImpl.updateAppInfo(appInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}

}
