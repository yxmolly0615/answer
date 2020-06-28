package com.woniu.answer.service;

import java.util.Date;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Pm;
import com.woniu.answer.mapper.PmMapper;
@Service
@Transactional//声明式事务
public class PmServiceImpl implements IPmService{
	@Autowired//依赖注入
	PmMapper pmMapper;

	@Override//查询
	public PageInfo<Pm> findPage(String content, String isread,  int now, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Pm> list=pmMapper.selectPage(content, isread);
		System.out.println("PmService上查到的分页信息"+list);
		//封装分页对象
		PageInfo<Pm> info=new PageInfo<Pm>(list);
		return info;
	}

	@Override
	public Pm findPmByid(int id) {
		// TODO Auto-generated method stub
		return pmMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<Pm> selectAll() {
		// TODO Auto-generated method stub
		return pmMapper.selectAll();
	}


	@Override
	public void deletePm(int id) {
		// TODO Auto-generated method stub
		pmMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStatusByKey(int id) {
		// TODO Auto-generated method stub
		return pmMapper.updateIsreadByKey(id);
	}

	@Override
	public void updateByPrimaryKey(Pm notice) {
		// TODO Auto-generated method stub
		pmMapper.updateByPrimaryKey(notice);
	}

	@Override
	public void addPm(Pm notice) {
		// TODO Auto-generated method stub
		pmMapper.insert(notice);
	}



	

}
