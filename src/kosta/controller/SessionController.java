package kosta.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping("session_req")
	public String session_req(){
		return "session/session_req";
	}
	
	@RequestMapping("session")
	public String session_exe(HttpServletRequest request){ //정상적 세션일때만
		return "session/session_success"; //페이지이동
	}
	
	@RequestMapping("session_add")
	public String session_add(){
		return "session/session_add";
	}
	
	
}
