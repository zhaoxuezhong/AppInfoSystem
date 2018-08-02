package com.zxz.service;

import java.util.List;

import com.zxz.pojo.AppCategory;

public interface AppCategoryService {

	List<AppCategory> findAppCategoryByParentId(Integer parentId);
}
