package com.woniu.answer.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Advice;
import com.woniu.answer.entity.Report;

public interface IReportService {
	List<Report> findAll();
	Report selectByid(int id);
	PageInfo<Report> selectQuestionPage(String reportcontent,String title,String status,int now,int size);
	PageInfo<Report> selectAnswerPage(String reportcontent, String answercontent,String status,int now,int size);
	PageInfo<Report> selectCommentPage(String reportcontent,String title,String status,int now,int size);
    int updateStatusByKey(int id);
}
