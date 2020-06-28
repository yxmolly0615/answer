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
import com.woniu.answer.entity.Notice;
import com.woniu.answer.service.INoticeService;
import com.woniu.answer.vo.ResultImg;

@Controller
@RequestMapping("notice")
public class NoticeController {
	@Autowired
	INoticeService ac;
	@RequestMapping("list")
	public String list(String title,String status
			,@RequestParam(value="now",defaultValue="0")int now
			,@RequestParam(value="size",defaultValue="2")int size,Model model) {
		PageInfo<Notice> info=ac.findPage(title,status, now, 2);
		model.addAttribute("info", info);
		model.addAttribute("title", title);
		return "notice";
	}

	/*
	 * //保存
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("addNotice") public Notice addNotice(@RequestBody Notice
	 * notice) { notice.setCreatedate(new Date()); notice.setStatus("1");
	 * ac.addNotice(notice); return notice; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("updateNotice/{id}")//修改notice public Notice
	 * updateNotice(@RequestBody Notice notice,Model model) {
	 * ac.updateByPrimaryKey(notice);
	 * 
	 * return notice; }
	 */
	@ResponseBody
	@RequestMapping("addUpdateNotice")//修改notice
	public Notice addUpdateNotice(@RequestBody Notice notice,Model model) {
		if(notice.getNoticeid()==null) {
			notice.setCreatedate(new Date());
			notice.setStatus("1");
			ac.addNotice(notice);
		}else {
			ac.updateByPrimaryKey(notice);
		}
		return notice;
	}
	@ResponseBody
	@RequestMapping("updateView/{id}")//要修改的notice值传到修改页面
	public String updateNoticeView(@PathVariable("id")int id,Model model) {
		Notice notice=ac.findnoticeByid(id);
		model.addAttribute("notice", notice);
		return "AddUpdateNotice";
	}
	@ResponseBody
	@RequestMapping("deleteNotice/{id}")
	public Notice updateStatusNotice(@PathVariable("id") int id) {
		ac.updateStatusByKey(id);
		Notice notice=ac.findnoticeByid(id);
		return notice;
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
	
}
