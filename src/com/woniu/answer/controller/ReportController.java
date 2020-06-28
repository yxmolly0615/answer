package com.woniu.answer.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Report;
import com.woniu.answer.service.IReportService;

@Controller
@RequestMapping("report")
public class ReportController {
	@Autowired
	IReportService qs;
	@RequestMapping("questionlist")
	
	/** servlret传过来的都是字符串，，cateid是int类型，如果没有传入参数，空字符串就会报错*/
	public String questionlist(String reportcontent,String title,String status,
			@RequestParam(value="cateid",defaultValue="0")int cateid,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			Model model) {
		System.out.println(reportcontent+"左边====="+"title"+"=====右边"+status);
		PageInfo<Report> info=qs.selectQuestionPage(reportcontent, title, status, now, 2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("reportcontent", reportcontent);
		model.addAttribute("title", title);
		model.addAttribute("status", status);
		return "reportQuestion";
	}
	@RequestMapping("answerlist")
	public String selectAnswerPage(String reportcontent,String answercontent,String status,
			@RequestParam(value="cateid",defaultValue="0")int cateid,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			Model model) {
		System.out.println(reportcontent+"左边====="+answercontent+"=====右边"+status);
		PageInfo<Report> info=qs.selectAnswerPage(reportcontent, answercontent, status, now, 2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("reportcontent", reportcontent);
		model.addAttribute("answercontent", answercontent);
		model.addAttribute("status", status);
		return "reportAnswer";
	}
	@RequestMapping("commentlist")
	public String selectCommentPage(String reportcontent,String content,String status,
			@RequestParam(value="cateid",defaultValue="0")int cateid,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			Model model) {
		System.out.println(reportcontent+"左边====="+content+"=====右边"+status);
		PageInfo<Report> info=qs.selectCommentPage(reportcontent, content, status, now, 2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("reportcontent", reportcontent);
		model.addAttribute("content", content);
		model.addAttribute("status", status);
		return "reportComment";
	}
	@RequestMapping("del/{id}")
	@ResponseBody//删除cate
	public Report deleteCate(@PathVariable("id")int questionid) {
		qs.updateStatusByKey(questionid);
		Report cate=qs.selectByid(questionid);
		return cate;
	}
}
