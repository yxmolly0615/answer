package com.woniu.answer.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Pm;



public interface IPmService {
	
	PageInfo<Pm> findPage(String content,String isread,int now,int size);
	Pm findPmByid(int id); 
	List<Pm> selectAll();
	int updateStatusByKey(int id);
	void deletePm(int id);
	void updateByPrimaryKey(Pm pm);
	void addPm(Pm pm);
}
