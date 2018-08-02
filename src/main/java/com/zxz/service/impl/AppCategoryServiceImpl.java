package com.zxz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.AppCategoryMapper;
import com.zxz.pojo.AppCategory;
import com.zxz.service.AppCategoryService;
@Service
public class AppCategoryServiceImpl implements AppCategoryService {
	@Resource
	private AppCategoryMapper appCategoryMapper;
	
	@Override
	public List<AppCategory> findAppCategoryByParentId(Integer parentId) {
		return appCategoryMapper.findAppCategoryByParentId(parentId);
	}

}
