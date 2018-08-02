package com.zxz.controller.developer;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zxz.controller.BaseController;
import com.zxz.pojo.AppCategory;
import com.zxz.pojo.AppInfo;
import com.zxz.pojo.AppVersion;
import com.zxz.pojo.DataDictionary;
import com.zxz.pojo.DevUser;
import com.zxz.service.AppCategoryService;
import com.zxz.service.AppInfoService;
import com.zxz.service.AppVersionService;
import com.zxz.service.DataDictionaryService;
import com.zxz.utils.Constants;
import com.zxz.utils.FileUtil;
import com.zxz.utils.PageInfo;

@Controller
@RequestMapping(value = "/dev/app")
public class AppInfoController extends BaseController<DevUser> {
	@Resource
	private AppInfoService appInfoServiceImpl;
	@Resource
	private AppCategoryService appCategoryServiceImpl;
	@Resource
	private DataDictionaryService dataDictionaryServiceImpl;
	@Resource
	private AppVersionService appVersionServiceImpl;

	//list
	@RequestMapping(value = "list")
	public String appInfoList(@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "5") Integer pageSize, AppInfo appInfo, Model model) {
		DevUser loginUser = this.getCurrentUser(Constants.SESSION_DEVUSER);
		if (appInfo == null)
			appInfo = new AppInfo();
		appInfo.setDevId(loginUser.getId());
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
		List<DataDictionary> statusList = dataDictionaryServiceImpl.findDataDictionaryByTypeCode(Constants.APP_STATUS);
		model.addAttribute("statusList", statusList);
		List<DataDictionary> flatformList = dataDictionaryServiceImpl
				.findDataDictionaryByTypeCode(Constants.APP_FLATFORM);
		model.addAttribute("flatformList", flatformList);
		return "developer/appinfolist";
	}

	//查询分类信息
	@RequestMapping(value = "categorylevellist.json")
	@ResponseBody
	public List<AppCategory> queryCategoryList(@RequestParam(required = false) Integer pid) {
		return appCategoryServiceImpl.findAppCategoryByParentId(pid);
	}

	//根据typeCode查询数据字典
	@RequestMapping(value = "datadictionarylist.json")
	@ResponseBody
	public List<DataDictionary> queryDataDictionaryList(@RequestParam(required = true) String tcode) {
		return dataDictionaryServiceImpl.findDataDictionaryByTypeCode(tcode);
	}

	//删除物理文件（img/apk）
	@RequestMapping(value = "delfile.json")
	@ResponseBody
	public String deleteFile(@RequestParam(required = true) Integer id, String flag) {
		if (flag == null || flag.equals("") || id == null || id.equals("")) {
			return "failed";
		}
		try {
			if ("logo".equals(flag)) {
				if (FileUtil.deleteFile(appInfoServiceImpl.findAppInfoById(id).getLogoLocPath())) {
					return appInfoServiceImpl.deleteLogoPic(id) > 0 ? "success" : "failed";
				}
			} else if ("apk".equals(flag)) {
				if (FileUtil.deleteFile(appVersionServiceImpl.findAppVersion(id).getApkLocPath())) {
					return appVersionServiceImpl.deleteAPK(id) > 0 ? "success" : "failed";
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	//显示app信息
	@RequestMapping(value = "appview/{id}")
	public String appInfoView(@PathVariable Integer id, Model model) {
		AppInfo appInfo = appInfoServiceImpl.findAppInfoById(id);
		model.addAttribute("appInfo", appInfo);
		List<AppVersion> appVersionList = appVersionServiceImpl.findAppVersionList(id);
		model.addAttribute("appVersionList", appVersionList);
		return "developer/appinfoview";
	}

	//去修改app页面
	@RequestMapping(value = "appinfomodify")
	public String toUpdateAppInfo(@RequestParam(required = true) Integer id, Model model) {
		AppInfo appInfo = appInfoServiceImpl.findAppInfoById(id);
		model.addAttribute("appInfo", appInfo);
		List<AppVersion> appVersionList = appVersionServiceImpl.findAppVersionList(id);
		model.addAttribute("appVersionList", appVersionList);
		return "developer/appinfomodify";
	}

	//修改app
	@RequestMapping(value = "appinfomodifysave")
	public String modifyAppInfo(MultipartFile attach, AppInfo appInfo, Model model, HttpServletRequest request) {
		Map<String, String> map = uploadPic(attach, model, request, appInfo.getApkname());
		if (map.get("return") != null) {
			return "redirect:appinfomodify";
		}
		appInfo.setModifyBy(this.getCurrentUser(Constants.SESSION_DEVUSER).getId());
		appInfo.setModifyDate(new Timestamp(System.currentTimeMillis()));
		appInfo.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		appInfo.setLogoLocPath(map.get("logoLocPath"));// LOGO图片的服务器存储路径
		appInfo.setLogoPicPath(map.get("logoPicPath"));// LOGO图片url路径
		int result = appInfoServiceImpl.updateAppInfo(appInfo);
		if (result > 0) {
			return "redirect:list";
		}
		return "redirect:appinfomodify";
	}

	//删除app
	@RequestMapping(value = "delapp.json")
	@ResponseBody
	public Map<String, Object> deleteAppInfo(@RequestParam(required = true) Integer id) {
		Map<String, Object> data = new HashMap<String, Object>();
		String delResult = "notexist";
		if (id == null || id == 0) {
			delResult = "false";
		}
		try {
			AppInfo appInfo = appInfoServiceImpl.findAppInfoById(id);
			List<AppVersion> appVersionList = appVersionServiceImpl.findAppVersionList(id);
			if (appInfoServiceImpl.deleteAppInfo(id) >= 1) {
				delResult = "true";
				FileUtil.deleteFile(appInfo.getLogoLocPath());
				if (appVersionList != null && appVersionList.size() > 0) {
					for (AppVersion appVersion : appVersionList) {
						FileUtil.deleteFile(appVersion.getApkLocPath());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			delResult = "false";
		} finally {
			data.put("delResult", delResult);
		}
		return data;
	}

	//去app新增页面
	@RequestMapping(value = "appinfoadd")
	public String appInfoAdd() {
		return "developer/appinfoadd";
	}

	//验证apkname的唯一
	@RequestMapping(value = "apkexist.json")
	@ResponseBody
	public Map<String, Object> apkExist(String APKName) {
		Map<String, Object> data = new HashMap<String, Object>();
		String delResult = "noexist";
		if (APKName == null || "".equals(APKName)) {
			delResult = "empty";
		} else if (appInfoServiceImpl.apkExist(APKName)) {
			delResult = "exist";
		}
		data.put("APKName", delResult);
		return data;
	}

	//新增app基本信息
	@RequestMapping(value = "appinfoaddsave")
	public String appinfoaddsave(AppInfo appInfo, MultipartFile a_logoPicPath, Model model,
			HttpServletRequest request) {
		Map<String, String> map = uploadPic(a_logoPicPath, model, request, appInfo.getApkname());
		if (map.get("return") != null) {
			return "developer/appinfoadd";
		}
		appInfo.setLogoLocPath(map.get("logoLocPath"));// LOGO图片的服务器存储路径
		appInfo.setLogoPicPath(map.get("logoPicPath"));// LOGO图片url路径
		appInfo.setDevId(this.getCurrentUser(Constants.SESSION_DEVUSER).getId());
		appInfo.setCreatedBy(this.getCurrentUser(Constants.SESSION_DEVUSER).getId());
		appInfo.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int result = appInfoServiceImpl.addAppInfo(appInfo);
		if (result > 0) {
			return "redirect:list";
		}
		return "developer/appinfoadd";
	}

	// 上传图片
	private Map<String, String> uploadPic(MultipartFile attach, Model model, HttpServletRequest request,
			String newFileName) {
		Map<String, String> map = new HashMap<String, String>();
		if (!attach.isEmpty()) {
			String oldFileName = attach.getOriginalFilename();
			String suffix = FileUtil.getFileExtensionByName(oldFileName);
			if (attach.getSize() > Constants.FILE_SIZE) {
				model.addAttribute(Constants.FILE_UPLOAD_ERROR, "上传大小不得超过" + Constants.FILE_SIZE / 1000 + "KB");
				map.put("return", "return");
			} else if (FileUtil.isSuffixs(suffix)) {
				// File.separator 考虑跨平台，则最好是这么写
				String path = request.getSession().getServletContext()
						.getRealPath("statics" + File.separator + "uploadfiles");
				newFileName += "." + suffix;
				File targetFile = new File(path, newFileName);
				if (!targetFile.exists()) {
					// 可以创建多级目录，父目录不一定存在
					targetFile.mkdirs();
				}
				try {
					attach.transferTo(targetFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
					model.addAttribute(Constants.FILE_UPLOAD_ERROR, e.getMessage());
					map.put("return", "return");
				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute(Constants.FILE_UPLOAD_ERROR, e.getMessage());
					map.put("return", "return");
				}
				map.put("logoLocPath", path + File.separator + newFileName);
				map.put("logoPicPath", request.getContextPath() + File.separator + "statics" + File.separator
						+ "uploadfiles" + File.separator + newFileName);
			} else {
				model.addAttribute(Constants.FILE_UPLOAD_ERROR, "上传图片格式不正确");
				map.put("return", "return");
			}
		}
		return map;
	}

	// 上传apk
	private Map<String, String> uploadApk(MultipartFile attach, Model model, HttpServletRequest request,
			String newFileName) {
		Map<String, String> map = new HashMap<String, String>();
		if (!attach.isEmpty()) {
			String oldFileName = attach.getOriginalFilename();
			String suffix = FileUtil.getFileExtensionByName(oldFileName);
			if (attach.getSize() > Constants.FILE_APK_SIZE) {
				model.addAttribute(Constants.FILE_UPLOAD_ERROR, "上传大小不得超过" + Constants.FILE_APK_SIZE / 1000000 + "MB");
				map.put("return", "return");
			} else if ("apk".equalsIgnoreCase(suffix)) {
				// File.separator 考虑跨平台，则最好是这么写
				String path = request.getSession().getServletContext()
						.getRealPath("statics" + File.separator + "uploadfiles");
				newFileName += ".apk";
				File targetFile = new File(path, newFileName);
				if (!targetFile.exists()) {
					// 可以创建多级目录，父目录不一定存在
					targetFile.mkdirs();
				}
				try {
					attach.transferTo(targetFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
					model.addAttribute(Constants.FILE_UPLOAD_ERROR, e.getMessage());
					map.put("return", "return");
				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute(Constants.FILE_UPLOAD_ERROR, e.getMessage());
					map.put("return", "return");
				}
				map.put("apkFileName", newFileName);
				map.put("apkLocPath", path + File.separator + newFileName);
				map.put("downloadLink", request.getContextPath() + File.separator + "statics" + File.separator
						+ "uploadfiles" + File.separator + newFileName);
			} else {
				model.addAttribute(Constants.FILE_UPLOAD_ERROR, "上传文件格式不正确");
				map.put("return", "return");
			}
		}
		return map;
	}

	//去新增appversion页面
	@RequestMapping(value = "appversionadd")
	public String appVersionAdd(Integer id, Model model) {
		List<AppVersion> appVersionList = appVersionServiceImpl.findAppVersionList(id);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute("appInfo", appInfoServiceImpl.findAppInfoById(id));
		return "developer/appversionadd";
	}

	//新增appversion
	@RequestMapping(value = "addversionsave")
	public String addversionsave(AppVersion appVersion, MultipartFile a_downloadLink, HttpServletRequest request,
			Model model) {
		Map<String, String> map = uploadApk(a_downloadLink, model, request,
				appVersion.getAppName() + "-" + appVersion.getVersionNo());
		if (map.get("return") != null) {
			return "redirect:appversionadd?id=" + appVersion.getAppId();
		}
		appVersion.setDownloadLink(map.get("downloadLink"));
		appVersion.setApkFileName(map.get("apkFileName"));
		appVersion.setApkLocPath(map.get("apkLocPath"));
		appVersion.setCreatedBy(this.getCurrentUser(Constants.SESSION_DEVUSER).getId());
		appVersion.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int result = appVersionServiceImpl.addAppVersion(appVersion);
		if (result < 2) {
			System.out.println("新增失败");
		}
		return "redirect:appversionadd?id=" + appVersion.getAppId();
	}

	//去修改页面
	@RequestMapping(value = "appversionmodify")
	public String appversionmodify(Integer vid, Integer aid, Model model) {
		List<AppVersion> appVersionList = appVersionServiceImpl.findAppVersionList(aid);
		model.addAttribute("appVersionList", appVersionList);
		AppVersion appVersion = appVersionServiceImpl.findAppVersion(vid);
		model.addAttribute("appVersion", appVersion);
		return "developer/appversionmodify";
	}

	//修改appversion
	@RequestMapping(value = "appversionmodifysave")
	public String appversionmodifysave(AppVersion appVersion, MultipartFile attach, HttpServletRequest request,
			Model model) {
		Map<String, String> map = uploadApk(attach, model, request,
				appVersion.getAppName() + "-" + appVersion.getVersionNo());
		if (map.get("return") != null) {
			return "redirect:appversionmodify?vid=" + appVersion.getId() + "&aid=" + appVersion.getAppId();
		}
		appVersion.setModifyBy(this.getCurrentUser(Constants.SESSION_DEVUSER).getId());
		appVersion.setModifyDate(new Timestamp(System.currentTimeMillis()));
		appVersion.setDownloadLink(map.get("downloadLink"));
		appVersion.setApkFileName(map.get("apkFileName"));
		appVersion.setApkLocPath(map.get("apkLocPath"));
		int result = appVersionServiceImpl.updateAppVersion(appVersion);
		if (result > 0) {
			return "redirect:list";
		}
		return "redirect:appversionmodify?vid=" + appVersion.getId() + "&aid=" + appVersion.getAppId();
	}

	//上下架
	@RequestMapping(value = "{appId}/sale.json")
	@ResponseBody
	public Map<String, Object> sale(@PathVariable String appId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long appIdLong = 0L;
		try {
			appIdLong = Long.parseLong(appId);
		} catch (Exception e) {
			appIdLong = 0L;
			e.printStackTrace();
		}
		map.put("errorCode", "0");
		map.put("appId", appId);
		if (appIdLong > 0) {
			try {
				AppInfo appInfo = new AppInfo();
				appInfo.setId(appIdLong);
				appInfo.setModifyBy(this.getCurrentUser(Constants.SESSION_DEVUSER).getId());
				appInfo.setModifyDate(new Timestamp(System.currentTimeMillis()));
				if (appInfoServiceImpl.updateStatus(appInfo)) {
					map.put("resultMsg", "success");
				} else {
					map.put("resultMsg", "failed");
				}
			} catch (Exception e) {
				e.printStackTrace();
				map.put("errorCode", "exception000001");
			}
		} else {
			// errorCode:0为正常
			map.put("errorCode", "param000001");
		}
		return map;
	}
}
