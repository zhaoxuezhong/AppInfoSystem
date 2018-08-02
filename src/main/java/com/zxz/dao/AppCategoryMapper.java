package com.zxz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxz.pojo.AppCategory;

public interface AppCategoryMapper {

	List<AppCategory> findAppCategoryByParentId(@Param("parentId")Integer parentId);
	
}
