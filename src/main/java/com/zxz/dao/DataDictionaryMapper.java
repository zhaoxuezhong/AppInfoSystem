package com.zxz.dao;

import java.util.List;

import com.zxz.pojo.DataDictionary;

public interface DataDictionaryMapper {

	List<DataDictionary> findDataDictionary(String typeCode);
}
