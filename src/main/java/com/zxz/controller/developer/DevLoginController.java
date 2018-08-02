package com.zxz.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxz.controller.BaseController;
import com.zxz.pojo.DevUser;
import com.zxz.service.DevUserService;
import com.zxz.utils.Constants;

@Controller
public class DevLoginController extends BaseController<DevUser>{

	@Resource
	private DevUserService devUserServiceImpl;
	
	@RequestMapping(value="/devlogin.html")
	public String toLogin(){
		return "devlogin";		
	}
	
	@RequestMapping(value="/dodevlogin")
	public String doDevLogin(DevUser user,HttpSession session,Model model){
		DevUser loginUser =devUserServiceImpl.login(user);
		if(loginUser!=null){
			session.setAttribute(Constants.SESSION_DEVUSER, loginUser);
			return "developer/main";
		}
		model.addAttribute(Constants.ERROR, "登录失败，请重试！");
		return "devlogin";
	}
	
	@RequestMapping(value="/devlogout")
	public String outDevLogin(HttpSession session){
		session.removeAttribute(Constants.SESSION_DEVUSER);
		return "devlogin";
	}
	

	@RequestMapping(value = "/dev/main")
	public String main() {
		return "developer/main";
	}
	
}
