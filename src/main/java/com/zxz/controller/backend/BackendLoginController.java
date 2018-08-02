package com.zxz.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxz.controller.BaseController;
import com.zxz.pojo.BackendUser;
import com.zxz.service.BackendUserService;
import com.zxz.utils.Constants;

@Controller
public class BackendLoginController extends BaseController<BackendUser> {

	@Resource
	private BackendUserService backendUserServiceImpl;
	
	@RequestMapping(value="/backendlogin.html")
	public String toLogin(){
		return "backendlogin";		
	}
	
	@RequestMapping(value="/dobackendlogin")
	public String doBackendLogin(BackendUser user,HttpSession session,Model model){
		BackendUser loginUser =backendUserServiceImpl.login(user);
		if(loginUser!=null){
			session.setAttribute(Constants.SESSION_BACKENDUSER, loginUser);
			return "backend/main";
		}
		model.addAttribute(Constants.ERROR, "登录失败，请重试！");
		return "backendlogin";
	}
	
	@RequestMapping(value="/backendlogout")
	public String outBackendLogin(HttpSession session){
		session.removeAttribute(Constants.SESSION_BACKENDUSER);
		return "backendlogin";
	}
	
	@RequestMapping(value = "/backend/main")
	public String main() {
		return "backend/main";
	}
	
	
}
