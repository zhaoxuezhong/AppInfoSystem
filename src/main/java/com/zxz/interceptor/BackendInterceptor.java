package com.zxz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zxz.pojo.BackendUser;
import com.zxz.utils.Constants;

public class BackendInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// intercept
		HttpSession session = request.getSession();
		BackendUser backendUser = ((BackendUser) session.getAttribute(Constants.SESSION_BACKENDUSER));

		if (null != backendUser) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/403.jsp");
			return false;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
}
