package com.zxz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxz.dao.DataDictionaryMapper;
import com.zxz.pojo.DataDictionary;
import com.zxz.service.DataDictionaryService;
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Resource 
	private DataDictionaryMapper dataDictionaryMapper;

	@Override
	public List<DataDictionary> findDataDictionaryByTypeCode(String typeCode) {
		return dataDictionaryMapper.findDataDictionary(typeCode);
	}

}
