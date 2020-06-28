package com.woniu.answer.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.woniu.answer.entity.Advice;
import com.woniu.answer.service.IAdviceService;
import com.woniu.answer.vo.ResultImg;

@Controller
@RequestMapping("advice")
public class AdviceController {
	@Autowired
	IAdviceService ac;
	@RequestMapping("list")
	public String list(String title,String status
			,@RequestParam(value="now",defaultValue="0")int now
			,@RequestParam(value="size",defaultValue="2")int size,Model model) {
		PageInfo<Advice> info=ac.findPage(title,status, now, 2);
		model.addAttribute("info", info);
		model.addAttribute("title", title);
		return "advice";
	}

	@ResponseBody
	@RequestMapping("updateAdvice/{id}")//修改advice
	public Advice updateAdvice(@RequestBody Advice advice,Model model) {
		ac.updateAdvice(advice);
		
		return advice;
	}
	@ResponseBody
	@RequestMapping("updateView")//要修改的advice值传到修改页面
	public String updateAdviceView(@PathVariable("id")int id,Model model) {
		Advice advice=ac.selectAdviceById(id);
		model.addAttribute("advice", advice);
		return "updateAdvice";
	}
	@ResponseBody
	@RequestMapping("deleteAdvice/{id}")
	public Advice updateStatusAdvice(@PathVariable("id") int id) {
		ac.updateSatusAdvice(id);
		Advice advice=ac.selectAdviceById(id);
		return advice;
	}
	@ResponseBody//将res转为json字符串
	@RequestMapping("uploadimg")//上传图片 通过input属性name拿到上传图片
	public ResultImg uploadimg(@RequestParam("filepath")MultipartFile upload) {
		String filename=upload.getOriginalFilename();
		System.out.println(filename+"上传图片名称");
		File f= new File("D:\\img\\"+filename);
		ResultImg res=null;
		try {
			upload.transferTo(f);
			res=new ResultImg("100",filename);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res=new ResultImg("100","上传失败");
		}
		//user.setHederImg(fileName);
		return res;
	}
	//保存
	@ResponseBody
	@RequestMapping("addAdvice")
	public Advice addAdvice(@RequestBody Advice advice) {
		System.out.println("添加的广告图片"+advice.getImgpath()+"添加的广告内容"+advice.getConment()+"添加的广告标题"+advice.getTitle());
		advice.setCreatedate(new Date());
		advice.setStatus("1");
		ac.addAdvice(advice);
		return advice;
	}
}
