package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileuploadService;

@Controller
public class FileUploadController {

	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping({"","/form"})
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam(value = "email", required = true ,defaultValue = "")String email ,@RequestParam("file1") MultipartFile file1, Model model) {
		System.out.println("email :" + email);
		String url = fileuploadService.restore(file1);
		model.addAttribute("url",url);
		return "/WEB-INF/views/result.jsp";
	}
}
