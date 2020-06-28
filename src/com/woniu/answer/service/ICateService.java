package com.woniu.answer.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Cate;

public interface ICateService {
	/*
	 * name:查询条件catename
	 * now:当前第几页
	 * size：每页显示数量
	 */
	PageInfo<Cate> findPage(String name,int now,int size);
	void addCate(Cate cate);
	void removeCateById(int id);
	void saveUpdate(Cate cate);
	Cate findCateByid(int id);
	List<Cate> findAll();
}
