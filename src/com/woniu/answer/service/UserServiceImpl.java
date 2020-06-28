package com.woniu.answer.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Question;
import com.woniu.answer.entity.User;
import com.woniu.answer.mapper.QuestionMapper;
import com.woniu.answer.mapper.UserMapper;
@Service
@Transactional//声明式事务
public class UserServiceImpl implements IUserService{
	@Autowired//依赖注入
	UserMapper userMapper;

	/**
	 * 问题查询
	 * @param title根据标题
	 * @param status根据状态
	 * @param cateid问题类型
	 * @param now分页查询
	 * @param size每页的数据条数
	 * @return
	 */
	@Override//查询
	public PageInfo<User> findPage(String username, String status, String sex, int now, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<User> list=userMapper.selectPage(username, status, sex);
		System.out.println("userService上查到的分页信息"+list);
		//封装分页对象
		PageInfo<User> info=new PageInfo<User>(list);
		return info;
	}

	@Override
	public User findAdviceByid(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

	@Override
	public void freezeStatusByKey(int userid) {
		// TODO Auto-generated method stub
		userMapper.freezeStatusByKey(userid);
	}

	@Override
	public void unFreezeStatusByKey(int userid) {
		// TODO Auto-generated method stub
		userMapper.unFreezeStatusByKey(userid);
	}

	

}
