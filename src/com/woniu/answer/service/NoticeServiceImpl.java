package com.woniu.answer.service;

import java.util.Date;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Notice;
import com.woniu.answer.mapper.NoticeMapper;
@Service
@Transactional//声明式事务
public class NoticeServiceImpl implements INoticeService{
	@Autowired//依赖注入
	NoticeMapper noticeMapper;

	/**
	 * 问题查询
	 * @param title根据标题
	 * @param status根据状态
	 * @param cateid问题类型
	 * @param now分页查询
	 * @param size每页的数据条数
	 * @return
	 */
	@Override//查询
	public PageInfo<Notice> findPage(String title, String status,  int now, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Notice> list=noticeMapper.selectPage(title, status);
		System.out.println("NoticeService上查到的分页信息"+list);
		//封装分页对象
		PageInfo<Notice> info=new PageInfo<Notice>(list);
		return info;
	}

	@Override
	public Notice findnoticeByid(int id) {
		// TODO Auto-generated method stub
		return noticeMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<Notice> selectAll() {
		// TODO Auto-generated method stub
		return noticeMapper.selectAll();
	}


	@Override
	public void deleteNotice(int id) {
		// TODO Auto-generated method stub
		noticeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStatusByKey(int id) {
		// TODO Auto-generated method stub
		return noticeMapper.updateStatusByKey(id);
	}

	@Override
	public void updateByPrimaryKey(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.updateByPrimaryKey(notice);
	}

	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.insert(notice);
	}



	

}
