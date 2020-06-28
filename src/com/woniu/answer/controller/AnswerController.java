package com.woniu.answer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Answer;
import com.woniu.answer.entity.Cate;
import com.woniu.answer.entity.Question;
import com.woniu.answer.service.IAnswerService;
import com.woniu.answer.service.ICateService;
import com.woniu.answer.service.IQuestionService;

@Controller
@RequestMapping("answer")
public class AnswerController {
	@Autowired
	IAnswerService as;
	@RequestMapping("list")
	/** servlret传过来的都是字符串，，cateid是int类型，如果没有传入参数，空字符串就会报错*/
	public String list(String answercontent,String title,String status,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			@RequestParam(value="size",defaultValue="2")int size,
			Model model) {
		PageInfo<Answer> info=as.findPage(answercontent, title, status, now, 2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("answercontent", answercontent);
		model.addAttribute("title", title);
		model.addAttribute("status", status);
		List<Answer> lists=as.findAll();
		model.addAttribute("lists", lists);
		return "answer";
	}
	@RequestMapping("del/{id}")
	@ResponseBody//删除cate
	public Answer deleteCate(@PathVariable("id")int answerid) {
		Answer answer=as.selectByid(answerid);
		as.updateStatusByKey(answerid);
		System.out.println("删除成功");
		return answer;
	}
}
