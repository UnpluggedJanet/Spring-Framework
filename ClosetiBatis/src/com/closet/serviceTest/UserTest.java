package com.closet.serviceTest;

import com.closet.dao.ibatis.IBatisUserDaoImpl;
import com.closet.domain.User;

import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.*;

public class UserTest {
	
	public static void main(String[] args) throws Exception{
		String resource = "./sql-map-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		
//		IBatisUserDaoImpl ibatis = new IBatisUserDaoImpl();
		
		User user = new User();
		user.setEmail("test1");
		user.setPassword("1234");
		user.setUsername("won");
		
		sqlMap.insert("insertUser", user);
		
//		ibatis.insertUser(user);	

	}
}
