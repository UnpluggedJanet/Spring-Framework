package com.closet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.closet.domain.User;

public interface UserDao {

    User getAccount(String email) throws DataAccessException;
    User getAccount(int id) throws DataAccessException;
//
//  User getAccount(String username, String password) throws DataAccessException;
//
	void insertUser(User user) throws DataAccessException;
	User isNewUser(String email) throws DataAccessException;
	List<User> findUser(String email) throws DataAccessException;
//  void updateAccount(User account) throws DataAccessException;
//
//  List<String> getUsernameList() throws DataAccessException;

}
