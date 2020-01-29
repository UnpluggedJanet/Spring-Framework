package com.closet.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.closet.domain.User;
import com.closet.domain.logic.Login;
import com.closet.domain.logic.ManagePost;
import com.closet.validator.LoginValidator;

@Controller
public class LoginController {
	
	private Login login;
	private ManagePost mngPost;
	
	@Autowired
	public void setLogin(Login login) {
		this.login = login;
	}
	
	@Autowired
	public void setManagePost(ManagePost mngPost) {
		this.mngPost = mngPost;
	}	
	

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String form() {
		return "loginForm";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView submit(User user, BindingResult result, HttpSession session) { //ModelAttribute로 login을 view에 전달될 객체로 지정.
				
		ModelAndView mav;
		new LoginValidator().validate(user, result);
		if (result.hasErrors()) {
			return mav = new ModelAndView("loginForm");
		}
		 
		
		//먼저 해당 아이디 있는지 체크, 있으면 비밀번호가 맞는지 체크 - 아닌 경우에 맞는 메시지 적용. 
		if (login.existUser(user.getEmail())){
			if (login.checkPassword(user.getEmail(), user.getPassword())) {
				//아이디 존재하고, 비번이 맞는 경우 
				System.out.println(user.getEmail() + "님 로그인 성공");
				User loginUserInfo = login.getUserInfo(user.getEmail());
				session.setAttribute("loginUserInfo", loginUserInfo);
				mav = new ModelAndView("newsfeed");

				mav.addObject(mngPost.showNewsfeed(loginUserInfo.getId()));
				return mav;
			}
			else {
				//아이디 존재하지만 비번이 맞지 않는 경우
				System.out.println(user.getEmail() + "님 잘못된 비번");
				return mav = new ModelAndView("loginForm", "error_message", "잘못된 비밀번호 입니다.");
			}
		}
		else{ 
			//아이디가 존재하지 않는 경우
			System.out.println(user.getEmail() + "는 존재하지 않는 아이디");
			return mav = new ModelAndView("loginForm", "error_message", "존재하지 않는 ID입니다. 다시 입력해 주십시오.");
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		//로그인 세션 없애기
		session.setAttribute("loginUserInfo", null);
		System.out.println("세션 종료");
		return "home";
	}
	
}
