package kosta.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SessionAspect { //어노테이션 방식 사용
	//aspect 공통관심사항 메서드 확인
	
	//@Around 는 대상 객체의 메서드 실행 전,후 또는 예외 발생 시점에 공통 기능을 실행	
	//exe로끝나는 메소드를 호출해서 세션체크를 해달라는 표시
	@Around("execution(public * kosta.controller.*.*exe(..))")
	public String sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)obj[0];
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		
		String view = "session/session_fail"; //세션이 없으면 실행하도록 변수에 담아둔다.
		
		try {
			if(name == null ){ //세션이 x
				throw new Exception("no session"); //예외 발생
			}
			
			view = (String)joinPoint.proceed(); //session_exe() : 원래 호출하려는 메서드  - 세션존재
			
		} catch (Exception e) {
			return view; //실패 페이지 이동
		}
		
		return view;
	}

}
