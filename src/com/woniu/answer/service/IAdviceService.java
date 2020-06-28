package com.woniu.answer.service;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Advice;

public interface IAdviceService {
	
	PageInfo<Advice> findPage(String title,String status ,int now,int size);
	Advice findAdviceByid(int id);
	void addAdvice(Advice advice);
	void updateAdvice(Advice advice);
	void updateSatusAdvice(int id);
	Advice selectAdviceById(int id);
}
