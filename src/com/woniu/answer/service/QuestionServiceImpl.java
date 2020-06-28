package com.woniu.answer.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Question;
import com.woniu.answer.mapper.QuestionMapper;
@Service
@Transactional//声明式事务
public class QuestionServiceImpl implements IQuestionService{
	@Autowired//依赖注入
	QuestionMapper questionMapper;

	@Override
	public void removeQuestionBykey(int id) {
		// TODO Auto-generated method stub
		questionMapper.updateStatusByKey(id);
	}	/**
	 * 问题查询
	 * @param title根据标题
	 * @param status根据状态
	 * @param cateid问题类型
	 * @param now分页查询
	 * @param size每页的数据条数
	 * @return
	 */
	@Override//查询
	public PageInfo<Question> findPage(String title, String status, int cateid, int now, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Question> list=questionMapper.selectPage(title, status, cateid);
		System.out.println("questionService上查到的分页信息"+list);
		//封装分页对象
		PageInfo<Question> info=new PageInfo<Question>(list);
		return info;
	}
	@Override
	public Question findQuestionByKey(int id) {
		// TODO Auto-generated method stub
		return questionMapper.selectByPrimaryKey(id);
	}

}
