package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmailListRepository;
import com.douzone.emaillist.vo.EmailListVo;

@Controller
public class EmailListController {

	@Autowired
	private EmailListRepository emailListRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmailListVo> list = emailListRepository.findAll();
		
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add" ,method = RequestMethod.POST)
	public String add(EmailListVo vo) {
		emailListRepository.insert(vo);
		return "redirect:/";
	}
}
