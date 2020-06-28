package com.woniu.answer.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Notice;



public interface INoticeService {
	
	PageInfo<Notice> findPage(String title,String status,int now,int size);
	Notice findnoticeByid(int id);
	List<Notice> selectAll();
	int updateStatusByKey(int id);
	void deleteNotice(int id);
	void updateByPrimaryKey(Notice notice);
	void addNotice(Notice notice);
}
