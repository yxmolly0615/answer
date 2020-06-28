package com.woniu.answer.controller;

import java.util.Date;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.User;
import com.woniu.answer.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	IUserService us;
	@RequestMapping("list")
	/** servlret传过来的都是字符串，，cateid是int类型，如果没有传入参数，空字符串就会报错*/
	public String list(String username,String status,String sex,
			@RequestParam(value="now",defaultValue="1")int now,//如果将来没有传入参数，默认1
			Model model) {
		System.out.println("搜索结果"+username+"=="+status+"=="+sex);
		PageInfo<User> info=us.findPage(username, status, sex, now,2);
		System.out.println("info的搜索结果"+info);
		model.addAttribute("info", info);
		model.addAttribute("username", username);
		model.addAttribute("status", status);
		model.addAttribute("sex", sex);
		return "user";
	}
	@ResponseBody//冻结
	@RequestMapping("freezeStatusByKey/{id}")
	public User freezeStatusByKey(@PathVariable("id") int id) {
		Date modifyDate=new Date();
		System.out.println("冻结当前时间"+modifyDate);
		us.freezeStatusByKey(id);
		User user=us.findAdviceByid(id);
		return user;
	}
	@ResponseBody//解冻
	@RequestMapping("unFreezeStatusByKey/{id}")
	public User unFreezeStatusByKey(@PathVariable("id") int id) {
		Date modifyDate=new Date();
		System.out.println("解冻当前时间"+modifyDate);
		us.unFreezeStatusByKey(id);
		User user=us.findAdviceByid(id);
		return user;
	}
}
