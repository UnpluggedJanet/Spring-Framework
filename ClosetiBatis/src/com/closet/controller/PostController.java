package com.closet.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.closet.domain.Post;
import com.closet.domain.User;
import com.closet.domain.logic.ManagePost;
import com.closet.domain.logic.ManageUser;

@Controller
/*@RequestMapping("/newPost.do")*/
public class PostController {
	private ManagePost mngPost;
	private ManageUser mngUser;
	
	@Autowired
	public void setMngPost(ManagePost mngPost) {
		this.mngPost = mngPost;
	}
	
	@Autowired
	public void setMngUser(ManageUser mngUser) {
		this.mngUser = mngUser;
	}
	
	@RequestMapping(value="/newPost.do", method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("postForm");		
		mav.addObject("categoryList1", mngPost.getCategory1());
		mav.addObject("categoryList2", mngPost.getCategory2());
		
		mav.addObject("post", new Post());
		return mav;
	}
	
	@RequestMapping(value="/newPost.do", method=RequestMethod.POST)
	public ModelAndView newPost(Post post, HttpSession session) {
		User user = (User) session.getAttribute("loginUserInfo");
		ModelAndView mav; 
		if (user==null){
			mav = new ModelAndView("home");
			return mav;
		}
		
		MultipartFile imgUpload = post.getImgFile();
		
		//빈칸이 있는지 체크
		if(post.getText() == null || post.getText().trim().isEmpty()){
			mav = new ModelAndView("postForm");
			mav.addObject("categoryList1", mngPost.getCategory1());
			mav.addObject("categoryList2", mngPost.getCategory2());
			mav.addObject("blank", "글을 입력 해 주세요");
			return mav;
		}if(post.getImgFile() == null){
			mav = new ModelAndView("postForm");
			mav.addObject("categoryList1", mngPost.getCategory1());
			mav.addObject("categoryList2", mngPost.getCategory2());
			mav.addObject("blank", "사진을 등록 해 주세요");
			return mav;
		}if(post.getCategoryList1() == null){
			mav = new ModelAndView("postForm");
			mav.addObject("categoryList1", mngPost.getCategory1());
			mav.addObject("categoryList2", mngPost.getCategory2());
			mav.addObject("blank", "날씨 카테고리를 선택해 주세요");
			return mav;
		}if(post.getCategoryList2() == null){
			mav = new ModelAndView("postForm");
			mav.addObject("categoryList1", mngPost.getCategory1());
			mav.addObject("categoryList2", mngPost.getCategory2());
			mav.addObject("blank", "상황 카테고리를 선택해 주세요");
			return mav;
		}
		
		
		System.out.println("파일이름 : " + imgUpload.getName());
		System.out.println("파일크기 : " + imgUpload.getSize());
		System.out.println("파일존재 : " + imgUpload.isEmpty());
		System.out.println("파일이름 : " + imgUpload.getOriginalFilename());
		
		Date date = new Date();
		System.out.println(date.getTime());
		long time = date.getTime();
		String fName = user.getId() +"_" + time +".jpg" ;
		post.setImg(fName);
		File f= new File("C:/SWSD2/ClosetiBatis/WebContent/img/"+ fName);
		
		try{
			imgUpload.transferTo(f);
			System.out.println("파일쓰기 완료");
		}catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		//생성 가능한 경우...
		
		mav = new ModelAndView("newsfeed");
		//현재 세션의 유저 아이디 포스트에 추가
		
		post.setMemberid(user.getId());
		//카테고리 포스트에 추가
		int category = this.mngPost.getCategory(post);
		post.setCategory(category);
		//포스트 생성
		this.mngPost.createPost(post);
		
		
		mav.addObject(mngPost.showNewsfeed(user.getId()));
		return mav;
	}
	

	@RequestMapping("myPage.do")
	public ModelAndView myPost(HttpSession session) {
		//현재 세션의 유저 아이디 포스트에 추가
		User user = (User) session.getAttribute("loginUserInfo");
		ModelAndView mav = new ModelAndView("myPage");
		
		if (user==null){
			mav = new ModelAndView("home");
			return mav;
		}
		
		
		mav.addObject("postList", mngPost.getUserPosts(user.getId()));
		mav.addObject("followers", mngUser.howManyFollowers(user.getId()));
		mav.addObject("following", mngUser.howManyFollowing(user.getId()));
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping("user.do")
	public ModelAndView myPost(int id, HttpSession session) {
		User user = (User) session.getAttribute("loginUserInfo");
		//파라미터로 넘어온 아이디의 유저 포스트
		ModelAndView mav = new ModelAndView("myPage");
		
		if (user==null){
			mav = new ModelAndView("home");
			return mav;
		}
		
		mav.addObject("postList", mngPost.getUserPosts(id));
		mav.addObject("user", mngUser.findUser(id));
		
		int my_id = user.getId();

		//이사람 팔로윙 했는지 안했는지 여부 같이 넘기기
		boolean result = mngUser.isFollowing(my_id, id);
		
		mav.addObject("isFollowing", result);
		
		return mav;
	}

}
