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
import com.woniu.answer.entity.Cate;
import com.woniu.answer.entity.Question;
import com.woniu.answer.service.ICateService;
import com.woniu.answer.service.IQuestionService;

@Controller
@RequestMapping("question")
public class QuestionController {
	@Autowired
	IQuestionService qs;
	@Autowired
	ICateService cs;
	@RequestMapping("list")
	/** servlret传过来的都是字符串，，cateid是int类型，如果没有传入参数，空字符串就会报错*/
	public String list(String title,String status,
			@RequestParam(value="cateid",defaultValue="0")int cateid,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			Model model) {
		PageInfo<Question> info=qs.findPage(title, status, cateid, now,2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("title", title);
		model.addAttribute("status", status);
		model.addAttribute("cateid", cateid);
		List<Cate> lists=cs.findAll();
		model.addAttribute("lists", lists);
		return "question";
	}
	@RequestMapping("del/{id}")
	@ResponseBody//删除cate
	public Question deleteCate(@PathVariable("id")int questionid) {
		Question cate=qs.findQuestionByKey(questionid);
		qs.removeQuestionBykey(questionid);
		System.out.println("删除成功");
		return cate;
	}
}
