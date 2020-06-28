package com.woniu.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Answer;
import com.woniu.answer.mapper.AnswerMapper;
@Service 
@Transactional//声明式事务
public class AnswerServiceImpl implements IAnswerService{
	@Autowired
	AnswerMapper answer;
	@Override
	public PageInfo<Answer> findPage(String answerContent, String title, String status,  int now,
			int size) {
		// TODO Auto-generated method stub
				PageHelper.startPage(now, size);
				List<Answer> list=answer.selectPage(answerContent, title, status);
				//封装分页对象
				PageInfo<Answer> info=new PageInfo<Answer>(list);
				return info;
	}

	@Override
	public void updateStatusByKey(int id) {
		// TODO Auto-generated method stub
		answer.updateStatusByKey(id);
	}

	@Override
	public Answer selectByid(int id) {
		// TODO Auto-generated method stub
		return answer.selectByPrimaryKey(id);
	}

	@Override
	public List<Answer> findAll() {
		// TODO Auto-generated method stub
		return answer.selectAll();
	}

}
