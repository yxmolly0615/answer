package com.woniu.answer.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Answer;
import com.woniu.answer.entity.Question;

public interface IAnswerService {
	 /* 问题查询
	 * @param title根据标题
	 * @param status根据状态
	 * @param cateid问题类型
	 * @param now分页查询
	 * @param size每页的数据条数
	 * @return
	 */
	PageInfo<Answer> findPage(String answerContent,String title,String status,int now,int size);
	void updateStatusByKey(int id);
	Answer selectByid(int id);
	List<Answer> findAll();
}
