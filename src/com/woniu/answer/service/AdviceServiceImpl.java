package com.woniu.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Advice;
import com.woniu.answer.mapper.AdviceMapper;
@Service
@Transactional
public class AdviceServiceImpl implements IAdviceService{
	@Autowired
	AdviceMapper adviceMapper;
	@Override
	public PageInfo<Advice> findPage(String title,String status, int now, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Advice> lists=adviceMapper.selectPage(title,status);
		PageInfo<Advice> info=new PageInfo<Advice>(lists);
		return info;
	}

	@Override
	public Advice findAdviceByid(int id) {
		// TODO Auto-generated method stub
		return adviceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addAdvice(Advice advice) {
		// TODO Auto-generated method stub
		adviceMapper.insert(advice);
	}

	@Override
	public void updateAdvice(Advice advice) {
		// TODO Auto-generated method stub
		adviceMapper.updateByPrimaryKey(advice);
	}

	@Override
	public void updateSatusAdvice(int id) {
		// TODO Auto-generated method stub
		adviceMapper.updateStatusByKey(id);
	}

	@Override
	public Advice selectAdviceById(int id) {
		// TODO Auto-generated method stub
		return adviceMapper.selectByPrimaryKey(id);
	}
	
	
}
