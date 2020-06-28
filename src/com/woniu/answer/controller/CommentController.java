package com.woniu.answer.controller;

import java.util.List
;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Comment;
import com.woniu.answer.service.ICommentService;

@Controller
@RequestMapping("comment")
public class CommentController {
	@Autowired
	ICommentService as;
	@RequestMapping("list")
	/** servlret传过来的都是字符串，，cateid是int类型，如果没有传入参数，空字符串就会报错*/
	public String list(String answercontent,String content,String status,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			@RequestParam(value="size",defaultValue="2")int size,
			Model model) {
		PageInfo<Comment> info=as.findPage(answercontent, content, status, now, 2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("answercontent", answercontent);
		model.addAttribute("content", content);
		model.addAttribute("status", status);
		List<Comment> lists=as.findAll();
		model.addAttribute("lists", lists);
		return "Comment";
	}
	@RequestMapping("del/{id}")
	@ResponseBody//删除cate
	public Comment deleteCate(@PathVariable("id")int answerid) {
		Comment answer=as.selectByid(answerid);
		as.updateStatusByKey(answerid);
		System.out.println("删除成功");
		return answer;
	}
}
