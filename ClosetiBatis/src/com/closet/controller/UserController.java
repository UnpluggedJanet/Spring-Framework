package com.closet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.closet.domain.User;
import com.closet.domain.logic.ManageUser;


@Controller
public class UserController {
	
	private ManageUser mngUser;
	
	@Autowired
	public void setSignup(ManageUser mngUser) {
		this.mngUser = mngUser;
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String form() {
		return "signUpForm";
	}

	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public ModelAndView submit(User user) {
		ModelAndView mav;
		//빈칸이 있는지 체크
		if(user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			mav = new ModelAndView("signUpForm");
			mav.addObject("blank_e", "이메일을 반드시 써주세용");
			return mav;
		}
		//빈칸이 있는지 체크
		if(user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			mav = new ModelAndView("signUpForm");
			mav.addObject("blank_p", "비밀번호를 반드시 써주세용");
			return mav;
		}
		
		//빈칸이 있는지 체크
		if(user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			mav = new ModelAndView("signUpForm");
			mav.addObject("blank_u", "유저명을 반드시 써주세용");
			return mav;
		}
			
		//기존에 있는 아이디인지 체크 체크
		boolean result = mngUser.isNewUser(user.getEmail());
		if (result == true) {
			mav = new ModelAndView("loginForm");
			this.mngUser.insertUser(user);
			mav.addObject("message", "회원가입에 성공하셨습니다.");
			return mav;
		}
		else{
			mav = new ModelAndView("signUpForm");
			mav.addObject("message", "이미 존재하는 아이디 입니다.");
			return mav;
		}
		
			
			
		
	}
	
	@RequestMapping(value="/finduser.do", method=RequestMethod.GET)
	public String findUserform() {
		return "findUser";
	}
	
	@RequestMapping(value="/finduser.do", method=RequestMethod.POST)
	public ModelAndView findUser(String email, HttpSession session) {
		ModelAndView mav;
		
		
		
		boolean result;
		User user;
		System.out.println("email = " + email);
		//입력값이 있는지 확인
		if (email == null || email.trim().isEmpty()) {
			return mav = new ModelAndView("findUser", "error_message", "검색할 아이디를 입력해주세요.");
		}
		
		//유저 검색 부분
		List<User> userList = mngUser.findUser(email);
		if (userList == null) {
			return mav = new ModelAndView("findUser", "no_result", "검색된 결과가 없습니다.");
		}else {
			System.out.println("해당 아이디 유저가 있습니다.");
			//for문돌려서 User의 isFollow변수 채워서 넘기기
			// 내아이디
			int my_id = ((User)session.getAttribute("loginUserInfo")).getId();
			for(int i=0; i < userList.size(); i++) {
				//검색결과 유저 하나씩 처리!
				user = userList.get(i);
				if (my_id == user.getId()) { //나는 검색결과에서 제외시키기 
					userList.remove(i);
				}else {
				//팔로우 했는지 체크해서 결과 반환 & user객체에 팔로우 상태로 추가하기.
				result = mngUser.isFollowing(my_id, userList.get(i).getId());
				userList.get(i).setFollowing(result);//following한 상태면 true가 넘어감.
				}
			}
			mav = new ModelAndView("findUser");
			mav.addObject(userList);
			return mav;
		}
		
	}
	
	@RequestMapping(value="/following.do")
	public ModelAndView getfollwing(HttpSession session) {
		ModelAndView mav = new ModelAndView("follow");
		//세션 통해 로그인 유저 정보 가져오기
		User user = (User)session.getAttribute("loginUserInfo");
		
		if (user==null){
			mav = new ModelAndView("home");
			return mav;
		}
		
		//로그인한 유저가 following한 유저 아이디 리스트 가져오기
		List<Integer> following_ids = mngUser.getFollowing(user.getId());
		List<User> userList = new ArrayList<User>();
		int user_size = following_ids.size();
		//following한 유저 정보 가져오기.
		for(int i=0; i<user_size; i++) {
			userList.add(mngUser.findUser(following_ids.get(i)));
		}
		mav.addObject("follow", "스타일러를 ");
		mav.addObject("userList", userList);
		mav.addObject("user_size", user_size);

		return mav;
	}
	
	@RequestMapping(value="/followers.do")
	public ModelAndView getfollwers(HttpSession session) {
		ModelAndView mav = new ModelAndView("follow");
		User user = (User)session.getAttribute("loginUserInfo");
		
		if (user==null){
			mav = new ModelAndView("home");
			return mav;
		}
		
		int my_id = user.getId();
		boolean result;
		
		List<Integer> followers_ids = mngUser.getFollowers(my_id);
		
		List<User> userList = new ArrayList<User>();
		int user_size = followers_ids.size();
		//여기에 내가 following했는지 여부 따지고 친구하기 추가.
		for(int i=0; i<user_size; i++) {
			User follower = mngUser.findUser(followers_ids.get(i));
			//팔로우 했는지 체크해서 결과 반환 & user객체에 팔로우 상태로 추가하기.
			result = mngUser.isFollowing(my_id, follower.getId());
			follower.setFollowing(result);//following한 상태면 true가 넘어감.
			userList.add(follower);
		}
		
		mav.addObject("follow", " 스타일러가 당신을 ");
		mav.addObject("userList", userList);
		mav.addObject("user_size", user_size);
		mav.addObject("isFollowerPage", true);
		return mav;
	}
	
	@RequestMapping(value="/follow.do")
	public ModelAndView follow(int id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int me = ((User)session.getAttribute("loginUserInfo")).getId();
		
		mngUser.insertFollow(me, id);
		mav.setViewName("redirect:/user.do?id="+id);
		return mav;
	}
}
