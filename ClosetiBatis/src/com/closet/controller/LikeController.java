package com.closet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.closet.domain.User;
import com.closet.domain.logic.ManagePost;

@Controller
public class LikeController {
	
	private ManagePost mngPost;
	
	@Autowired
	public void setManagePost(ManagePost mngPost) {
		this.mngPost = mngPost;
	}
	

	@RequestMapping(value="/like.do")
	public ModelAndView like(int p_id, HttpSession session) {
		int u_id = ((User)session.getAttribute("loginUserInfo")).getId();
		//Like생성
		this.mngPost.insertLike(p_id, u_id);
		this.mngPost.clickLikePost(p_id);
		
		ModelAndView mav = new ModelAndView("newsfeed"); 
		mav.addObject(mngPost.showNewsfeed(u_id));
		return mav;
	}
	
	@RequestMapping(value="/dislike.do")
	public ModelAndView dislike(int p_id, HttpSession session) {
		int u_id = ((User)session.getAttribute("loginUserInfo")).getId();
		//DisLike생성
		this.mngPost.insertDisLike(p_id, u_id);
		this.mngPost.clickDisLikePost(p_id);
		
		ModelAndView mav = new ModelAndView("newsfeed"); 
		mav.addObject(mngPost.showNewsfeed(u_id));
		return mav;
	}
	
	@RequestMapping(value="/cancellike.do")
	public ModelAndView cancellike(int p_id, HttpSession session) {
		int u_id = ((User)session.getAttribute("loginUserInfo")).getId();
		//Like취소
		this.mngPost.cancelLike(p_id, u_id);
		this.mngPost.unClickLikePost(p_id);
		
		ModelAndView mav = new ModelAndView("newsfeed");
		mav.addObject(mngPost.showNewsfeed(u_id));
		return mav;
	}
	
	@RequestMapping(value="/canceldislike.do")
	public ModelAndView cancelDislike(int p_id, HttpSession session) {
		int u_id = ((User)session.getAttribute("loginUserInfo")).getId();
		//DisLike취소
		this.mngPost.cancelDisLike(p_id, u_id);
		this.mngPost.unClickDisLikePost(p_id);
		
		ModelAndView mav = new ModelAndView("newsfeed"); //viewPost로 바꾸기
		mav.addObject(mngPost.showNewsfeed(u_id));
		return mav;
	}
	
}
