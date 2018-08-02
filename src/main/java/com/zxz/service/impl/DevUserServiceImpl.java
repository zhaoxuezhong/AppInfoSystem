package com.zxz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.DevUserMapper;
import com.zxz.pojo.DevUser;
import com.zxz.service.DevUserService;

@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper devUserMapper;
	
	@Override
	public DevUser login(DevUser user) {
		return devUserMapper.getDevUser(user);
	}

}
