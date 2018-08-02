package com.zxz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zxz.pojo.DevUser;
import com.zxz.utils.Constants;

public class DevInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// intercept
		HttpSession session = request.getSession();
		DevUser devUser = ((DevUser) session.getAttribute(Constants.SESSION_DEVUSER));

		if (null != devUser) {
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
