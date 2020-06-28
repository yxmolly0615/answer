package com.woniu.answer.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.User;



public interface IUserService {
	
	PageInfo<User> findPage(String username,String status,String sex ,int now,int size);
	User findAdviceByid(int id);
	List<User> selectAll();
	void freezeStatusByKey(int userid);
	void unFreezeStatusByKey(int userid);
}
