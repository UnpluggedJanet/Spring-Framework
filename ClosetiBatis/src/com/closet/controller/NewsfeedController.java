package com.closet.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.closet.domain.Post;
import com.closet.domain.User;
import com.closet.domain.logic.ManagePost;

@Controller

public class NewsfeedController {
	
	private ManagePost mngPost;

	@Autowired
	private void setMngPost(ManagePost mngPost) {
		this.mngPost = mngPost;
	}
	
	@RequestMapping("newsfeed.do")
	public ModelAndView newsfeedForm(HttpSession session){
		ModelAndView mav = new ModelAndView("newsfeed");
		User user = (User) session.getAttribute("loginUserInfo");
		//session 없으면 home으로
		if (user==null){
			mav = new ModelAndView("home");
			return mav;
		}
		
		List<Post> postList = mngPost.showNewsfeed(user.getId());
		
		mav.addObject(postList);
		return mav;
	}
	@RequestMapping("deletePost.do")
	private ModelAndView deletePost(int delPostId){
	
		ModelAndView mav = new ModelAndView("newsfeed");
		System.out.println(delPostId);
		mav.addObject("postList", mngPost.deletePost(delPostId));
		
		return mav;
	}
}
