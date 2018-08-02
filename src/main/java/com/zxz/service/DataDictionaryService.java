package com.zxz.service;

import java.util.List;

import com.zxz.pojo.DataDictionary;

public interface DataDictionaryService {

	List<DataDictionary> findDataDictionaryByTypeCode(String typeCode);
	
}
