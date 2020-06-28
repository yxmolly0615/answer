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
import com.woniu.answer.entity.Pm;
import com.woniu.answer.service.IPmService;
import com.woniu.answer.vo.ResultImg;

@Controller
@RequestMapping("pm")
public class PmController {
	@Autowired
	IPmService ac;
	@RequestMapping("list")//content isread
	public String list(String content,String isread
			,@RequestParam(value="now",defaultValue="0")int now
			,@RequestParam(value="size",defaultValue="2")int size,Model model) {
		System.out.println(content+"左边====="+"=====右边"+isread);
		PageInfo<Pm> info=ac.findPage(content,isread, now, 2);
		
		model.addAttribute("info", info); 
		model.addAttribute("content", content);
		model.addAttribute("isread", isread);
		return "pm";
	}

	@ResponseBody
	@RequestMapping("updatePm/{id}")//修改pm
	public Pm updatePm(@RequestBody Pm pm,Model model) {
		ac.updateByPrimaryKey(pm);
		
		return pm;
	}

	@ResponseBody
	@RequestMapping("deletePm/{id}")
	public Pm updateIsreadPm(@PathVariable("id") int id) {
		ac.updateStatusByKey(id);
		Pm pm=ac.findPmByid(id);
		return pm;
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
	@RequestMapping("addPm")
	public Pm addPm(@RequestBody Pm pm) {
		pm.setCreatedate(new Date());
		pm.setIsread("0");
		ac.addPm(pm);
		return pm;
	}
}
