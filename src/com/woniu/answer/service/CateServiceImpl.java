package com.woniu.answer.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Cate;
import com.woniu.answer.mapper.CateMapper;
import com.woniu.answer.util.SqlSessionUtil;
@Service
@Transactional
public class CateServiceImpl implements ICateService{
	@Autowired
	CateMapper cateMapper;
	SqlSessionUtil util = new SqlSessionUtil();
	@Override
	public PageInfo<Cate> findPage(String name,int now,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Cate> listCate=cateMapper.selectAll(name);
		PageInfo<Cate> info = new PageInfo<>(listCate);
		return info;
	}
	@Override
	public void addCate(Cate cate) {
		// TODO Auto-generated method stub
		cateMapper.insert(cate);
	}
	@Override
	public void saveUpdate(Cate cate) {
		// TODO Auto-generated method stub
		cateMapper.updateByPrimaryKey(cate);
	}
	@Override
	public void removeCateById(int cateid) {
		// TODO Auto-generated method stub
		cateMapper.deleteByPrimaryKey(cateid);
	}
	@Override
	public Cate findCateByid(int cateid) {
		// TODO Auto-generated method stub
		return cateMapper.selectByPrimaryKey(cateid);
	}
	@Override
	public List<Cate> findAll() {
		// TODO Auto-generated method stub
		return cateMapper.selectAll(null);
	}

}
