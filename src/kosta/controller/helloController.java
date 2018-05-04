package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.service.HelloService;

@Controller
public class helloController {
	
	public helloController(){}
	
	private HelloService service;
	
	@Autowired
	public void setService(HelloService service) {
		this.service = service;
	}

	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "반갑다 Spring");
		mav.addObject("message", service.getMessage());
		mav.setViewName("hello");
		
		return mav;
	}
}
