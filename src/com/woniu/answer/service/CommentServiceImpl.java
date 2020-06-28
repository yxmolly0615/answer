package com.woniu.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Answer;
import com.woniu.answer.entity.Comment;
import com.woniu.answer.mapper.AnswerMapper;
import com.woniu.answer.mapper.CommentMapper;
@Service 
@Transactional//声明式事务
public class CommentServiceImpl implements ICommentService{
	@Autowired
	CommentMapper commentMapper;
	@Override
	public PageInfo<Comment> findPage(String answercontent, String content, String status,  int now,
			int size) {
		// TODO Auto-generated method stub
				PageHelper.startPage(now, size);
				List<Comment> list=commentMapper.selectPage(answercontent, content, status);
				//封装分页对象
				PageInfo<Comment> info=new PageInfo<Comment>(list);
				return info;
	}

	@Override
	public void updateStatusByKey(int id) {
		// TODO Auto-generated method stub
		commentMapper.updateStatusByKey(id);
	}

	@Override
	public Comment selectByid(int id) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return commentMapper.selectAll();
	}

}
