package com.closet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.closet.domain.Post;
import com.closet.domain.logic.ManagePost;
import com.closet.domain.logic.SearchPost;

@Controller
@RequestMapping("/searchPost.do")
public class SearchController {
	private ManagePost mngPost;
	private SearchPost schPost;

	@Autowired
	public void setMngPost(ManagePost mngPost) {
		this.mngPost = mngPost;
	}
	@Autowired
	public void setSchPost(SearchPost schPost) {
		this.schPost = schPost;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView searchform() {
		ModelAndView mav = new ModelAndView("searchForm");		
		mav.addObject("categoryList1", mngPost.getCategory1());
		mav.addObject("categoryList2", mngPost.getCategory2());
		
		mav.addObject("post", new Post());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView searchPost(@ModelAttribute Post post) {
		ModelAndView mav = new ModelAndView("searchResult");	
		
		if(post.getCategoryList1() == null){
			mav = new ModelAndView("searchForm");
			mav.addObject("categoryList1", mngPost.getCategory1());
			mav.addObject("categoryList2", mngPost.getCategory2());
			mav.addObject("blank", "날씨 카테고리를 선택해 주세요");
			return mav;
		}if(post.getCategoryList2() == null){
			mav = new ModelAndView("searchForm");
			mav.addObject("categoryList1", mngPost.getCategory1());
			mav.addObject("categoryList2", mngPost.getCategory2());
			mav.addObject("blank", "상황 카테고리를 선택해 주세요");
			return mav;
		}
		int category = this.mngPost.getCategory(post);
		
		mav.addObject(schPost.searchPost(category));

		return mav;
	}


}
