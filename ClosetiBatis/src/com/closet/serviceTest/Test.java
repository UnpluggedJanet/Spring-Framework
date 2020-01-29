package com.closet.serviceTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.closet.domain.logic.ManagePost;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("./applicationContext.xml");
		
		ManagePost mngPost = (ManagePost)ctx.getBean("mngPost");
		
		//Test for insertPost
/*		Post post = new Post("블라블라", "dddd");
		mngPost.createPost(post);*/
		
		//Test for deletePost
/*		Post post = new Post(35);
		mngPost.deletePost(post); */
		
		//Test for newsfeedPost
		//mngPost.showNewsfeed();
	}

}
