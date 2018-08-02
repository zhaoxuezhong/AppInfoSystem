package com.zxz.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * BaseController
 * @author zhaoxuezhong
 */
public class BaseController<T> {
	protected Logger logger = Logger.getLogger(BaseController.class);
	private T currentUser;

	@SuppressWarnings("unchecked")
	public T getCurrentUser(String session_name) {
		if(null == this.currentUser){
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession(false);
			if(null != session){
				currentUser = (T) session.getAttribute(session_name);
			}else {
				currentUser = null;
			}
		}
		return currentUser;
	}

	public void setCurrentUser(T currentUser) {
		this.currentUser = currentUser;
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder){
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
		    public void setAsText(String value) {
		        try {
		            setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
		        } catch(ParseException e) {
		            setValue(null);
		            logger.error(e.getMessage());
		        }
		    }
		    public String getAsText() {
		        return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
		    }        
		});
	}
}
