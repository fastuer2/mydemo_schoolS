package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Dept;
import com.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptServiceImpl;
	
	@RequestMapping("/dept")
	public String dept(Model model,@RequestParam(value="page",defaultValue="0")Integer page,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
		page=page<0?0:page;
		Page<Dept> list = deptServiceImpl.getPageSort(page, pageSize);
		model.addAttribute("depts", list);
		return "dept";
	}
	@RequestMapping("/dept/add")
	public String dept(){
		return "dept_add";
	}
	@RequestMapping("/dept/update")
	public String update(Integer id,Model model){
		System.out.println(id);
		System.out.println(deptServiceImpl.findByDeptId(id));
		model.addAttribute("dept",deptServiceImpl.findByDeptId(id));
		return "dept_update";
	}
	@RequestMapping("/dept/del")
	public String del(Integer id){
		System.out.println(id);
		deptServiceImpl.deleteById(id);
		return "dept";
	}
	@RequestMapping("/dept/dept_save")
	public String dept_save(Integer id,String name){
		Dept dept=deptServiceImpl.findByDeptId(id);
		dept.setName(name);
		deptServiceImpl.save(dept);
		return "redirect:/dept";
	}
	@RequestMapping("/dept/save")
	public String save(String name){
		Dept dept=new Dept();
		dept.setName(name);
		deptServiceImpl.save(dept);
		return "redirect:/dept";
	}
}
