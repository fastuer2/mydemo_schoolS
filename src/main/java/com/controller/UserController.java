package com.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Menu;
import com.entity.Node;
import com.entity.Role;
import com.entity.User;
import com.service.MenuService;
import com.service.RoleService;
import com.service.impl.UserServiceImpl;


@Controller
public class UserController{
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("login")
	public String login(HttpSession session,String name,String password){
		User user=userServiceImpl.findByUser(name, password);
		session.setAttribute("user", user);
		if(user!=null){
			System.out.println("------------");
			return "main";
		}else{
			return "index";
		}
	}
	
	@RequestMapping("/list")
	public String list(Model model,@RequestParam(value="page",defaultValue="0")Integer page,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
		page=page<0?0:page;
		Page<User> users = userServiceImpl.getPage(page, pageSize);
		model.addAttribute("users",users);
		return "list";
	}
	
	@RequestMapping("/del")
	public String del(Integer id){
		userServiceImpl.deleteById(id);
		return "redirect:list";
	}
	
	@RequestMapping("/add")
	public String add(String name ,String password,String phone){
		return "add";
	}
	@RequestMapping("/save")
	public String save(String name ,String password,String phone,Date insTime){
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setCtime(new Date());
		userServiceImpl.save(user);
		return "list";
	}
	@RequestMapping("/search")
	public String search(){
		return "search";
	}
	@RequestMapping("/search_user")
	public String search_user(HttpServletRequest request,String name,String password,String phone,@RequestParam(value="page",defaultValue="0")Integer page,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("phone", phone);
		Page<User> users=userServiceImpl.getPageByType(name,password,phone,page,pageSize);
		request.setAttribute("users",users);
		return "search";
	}
	@Autowired
	private RoleService roleServiceImpl;
	@Autowired
	private MenuService menuServiceImpl;
	
	@RequestMapping("/load")
	@ResponseBody
	public List<Node> load(HttpSession session,HttpServletRequest request){
		User user = (User) session.getAttribute("user");
		List<Node> node=new ArrayList<>();
		List<Role> roleList = roleServiceImpl.findByUserId(user.getId());
		for (Role role : roleList) {
			//根据角色id查询中间表的mid,查出所有父级菜单
			List<Menu> parentMenus = menuServiceImpl.findById1(role.getId());
			Node parentSiblingNode=new Node();
			for (Menu parentMenu : parentMenus) {
				//初始化父级菜单
				parentSiblingNode.setNodeId(parentMenu.getId()+"");
				parentSiblingNode.setText(parentMenu.getName());
				parentSiblingNode.setHref(parentMenu.getUrl());
				parentSiblingNode.setPid(parentMenu.getParentid());
				//根据父级菜单的id查询
				List<Menu> childMenus=menuServiceImpl.findByParentId(parentMenu.getId());
				List<Node> childNodes=new ArrayList<>();
				for (Menu childMenu : childMenus) {
					Node childNode = new Node();
					//初始化子级
					childNode.setNodeId(childMenu.getId()+"");
					childNode.setText(childMenu.getName());
					childNode.setHref(childMenu.getUrl());
					childNode.setPid(childMenu.getParentid());
					childNodes.add(childNode);
				}
				parentSiblingNode.setNodes(childNodes);
				node.add(parentSiblingNode);
			}
		}
		System.out.println(node);
		return node;
	}
//	@RequestMapping("/dept")
//	public String dept(){
//		return "dept";
//	}
	@RequestMapping("/sys")
	public String sys(Model model,@RequestParam(value="page",defaultValue="0")Integer page,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
		page=page<0?0:page;
		Page<User> users = userServiceImpl.getPage(page, pageSize);
		model.addAttribute("users",users);
		return "sys";
	}
}
