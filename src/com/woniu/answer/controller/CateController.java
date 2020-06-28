package com.woniu.answer.controller;

import java.io.PrintWriter;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.woniu.answer.entity.Cate;
import com.woniu.answer.service.ICateService;

@Controller
@RequestMapping("cate")
public class CateController {
	
	@Autowired
	ICateService cs;
	
	@RequestMapping("list")//如果没有传入每页多少条数据，给默认值1
	public String list(String name,@RequestParam(value="now",defaultValue="1")int now,Model model) {
		
		PageInfo<Cate> info=cs.findPage(name, now, 2);
		model.addAttribute("info", info);
		model.addAttribute("name", name);
		return "article-list";//article-list.jsp
	}
	
	//添加cate
	@RequestMapping("addCate")
	@ResponseBody
	//@ResponseBody将对象转为json
	//@RequestBody将json转为java对象@RequestBody 
	public Cate addCate(@RequestBody Cate cate) {
		System.out.println(
				"json收到了没有："+cate.getCatename()
				+"cate描述："+cate.getDescription()
				+"cateid的id"+cate.getCateid());
		cs.addCate(cate);
		//保存完要回到列表页面，需要使用重定向redirect,回到上面的list方法
		return cate;
	}
	  //显示修改页面
	@RequestMapping("updateView/{id}")
	public String updatView(@PathVariable("id")int id,Model model) {
		 Cate cate=cs.findCateByid(id);
		 model.addAttribute("c", cate);
		 System.out.println("修改查到的数据"+cate);
		 return "updateCate"; 
	 } //修改cate
	  
	//修改cate
	@RequestMapping("saveUpdate")
	@ResponseBody
	public Cate saveUpdate(@RequestBody(required=false) Cate cate) {
		//System.out.println("json收到了没有："+cate.getCatename()
			//	+"cate描述："+cate.getDescription()
				//+"cateid"+cate.getCateid());
		cs.saveUpdate(cate);
		//保存完要回到列表页面，需要使用重定向redirect,回到上面的list方法
		return cate;
	}

	@RequestMapping("del/{id}")
	@ResponseBody//删除cate
	public Cate deleteCate(@PathVariable("id")int cateid) {
		Cate cate=cs.findCateByid(cateid);
		cs.removeCateById(cateid);
		System.out.println("删除成功");
		return cate;
	}

	 /*@RequestMapping("updateAddCate") public String updateAddCate(Cate cate,Model
	 * model) { System.out.println( "catename是"+cate.getCatename()+
	 * "description是："+cate.getDescription()+ "cateid是"+cate.getCateid());
	 * if(cate.getCateid()==null) { cs.addCate(cate); }else { cs.saveUpdate(cate); }
	 * return null; }
	 */
	
}
