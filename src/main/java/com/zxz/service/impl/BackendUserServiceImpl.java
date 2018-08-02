package com.zxz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.BackendUserMapper;
import com.zxz.pojo.BackendUser;
import com.zxz.service.BackendUserService;

@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper backendUserMapper;
	
	@Override
	public BackendUser login(BackendUser user) {
		return backendUserMapper.getBackendUser(user);
	}

}
