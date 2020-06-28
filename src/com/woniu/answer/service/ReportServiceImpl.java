package com.woniu.answer.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Report;
import com.woniu.answer.mapper.ReportMapper;
@Service
@Transactional
public class ReportServiceImpl implements IReportService{
	
	@Autowired
	ReportMapper reportMapper;
	
	@Override
	public List<Report> findAll() {
		// TODO Auto-generated method stub
		return reportMapper.selectAll();
	}

	@Override
	public Report selectByid(int id) {
		// TODO Auto-generated method stub
		return reportMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Report> selectQuestionPage(String reportcontent, String title, String status,int now,int size) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PageHelper.startPage(now, size);
				List<Report> listCate=reportMapper.selectQuestionPage(reportcontent, title, status);
				PageInfo<Report> info = new PageInfo<>(listCate);
				return info;
	}

	@Override
	public PageInfo<Report> selectAnswerPage(String reportcontent, String answercontent, String status,int now,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Report> listCate=reportMapper.selectAnswerPage(reportcontent, answercontent, status);
		PageInfo<Report> info = new PageInfo<>(listCate);
		return info;
	}

	@Override
	public PageInfo<Report> selectCommentPage(String reportcontent, String content, String status,int now,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(now, size);
		List<Report> listCate=reportMapper.selectCommentPage(reportcontent, content, status);
		PageInfo<Report> info = new PageInfo<>(listCate);
		return info;
	}

	@Override
	public int updateStatusByKey(int id) {
		// TODO Auto-generated method stub
		return reportMapper.updateStatusByKey(id);
	}

}
