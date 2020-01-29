package com.closet.serviceTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.closet.domain.User;
import com.closet.domain.logic.ManageUser;

public class SignUpTest {

	public static void main(String[] args) {
			
		ApplicationContext ctx = new ClassPathXmlApplicationContext("./applicationContext.xml");
		
		ManageUser signup = (ManageUser)ctx.getBean("signup");
		
		User user = new User(1, "e", "d", "d", "d");
		String email = user.getEmail();
		
		signup.insertUser(user);
	/*	if(signup.isNewUser(email)) {
			System.out.println("사용 가능한 이메일 입니다.");
			signup.insertUser(user);
			System.out.println("사용자 계정이 추가되었습니다.");
		}
		else
			System.out.println("이미 존재하는 이메일 입니다.");*/
		
	}

}
