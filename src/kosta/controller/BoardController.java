package kosta.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.model.Board;
import kosta.model.BoardDao;
import kosta.model.BoardValidator;

@Controller
public class BoardController {
	private BoardDao dao;
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	public BoardController(){}
	
/*	@RequestMapping("/board_insert.do")
	public ModelAndView insertForm(){
		//모델엔드뷰는 객체를 생성해서 담아주는데 view를 지정해줘서 보내줘야한다.
		 
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "글쓰기");
		mav.setViewName("insert_form"); //setviewName("jsp파일 이름과 동일")
		
		return mav;
	}
	*/
	
	//get방식 요청
	@RequestMapping(value="/board_insert", method=RequestMethod.GET)
	public String insertForm(@ModelAttribute("boardCommand") Board board, Model model){	
		model.addAttribute("title", "글쓰기2");	
		return "insert_form";
	}
	
	//post방식 요청
	@RequestMapping(value="/board_insert", method=RequestMethod.POST)
	public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors){
		
		if(errors.hasErrors()){
			System.out.println("error 발생");
			return "insert_form";
		}
		
		dao.insert(board);
		
		return "redirect:board_list";
	}
	
	//데이터를 모델 객체에 넣어 리스트를 전달
	@RequestMapping("/board_list")
	public String board_list(Model model){
		//model은 객체를 생성해서 담아서 보내주는 역할	
		List<Board> list = dao.listBoard();
		model.addAttribute("list",list);
		
		return "list";
	}
	
	//get방식일때 데이터값을 던질 때 requestParam 사용
/*	@RequestMapping("/board_detail")
	public String board_detail(@RequestParam("seq") int seq, Model model){
		Board board = dao.getBoard(seq);
		model.addAttribute("board",board);
		
		return "detail";
	}*/
	
	@RequestMapping("/board_detail{seq}")
	public String board_detail(@PathVariable int seq, Model model){
		Board board = dao.getBoard(seq);
		model.addAttribute("board",board);
		
		return "detail";
	}
	
	@RequestMapping("/board_json")
	public String board_json(){
		return "client";
	}
	
	@RequestMapping("/list_json")
	public String list_json(Model model){
		//model은 객체를 생성해서 담아서 보내주는 역할	
		List<Board> list = dao.listBoard();
		model.addAttribute("list",list);
		
		return "list";
	}
	
	/* board validater를 위한 것*/
/*	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(new BoardValidator());
	}*/
}
