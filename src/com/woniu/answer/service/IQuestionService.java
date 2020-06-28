package com.woniu.answer.service;


import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Question;

public interface IQuestionService {
	//条件查询
	/**
	 * 问题查询
	 * @param title根据标题
	 * @param status根据状态
	 * @param cateid问题类型
	 * @param now分页查询
	 * @param size每页的数据条数
	 * @return
	 */
	PageInfo<Question> findPage(String title,String status,int cateid,int now,int size);
	/**
	 * 非物理删除：不是从数据库真正删除，只是改变状态
	 * 把status从1改为0
	 * @param id
	 */
	void removeQuestionBykey(int id);
	Question findQuestionByKey(int id);
}
