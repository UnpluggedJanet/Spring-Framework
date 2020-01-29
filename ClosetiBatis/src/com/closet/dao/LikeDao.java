package com.closet.dao;

import org.springframework.dao.DataAccessException;


public interface LikeDao {

	void insertLike(int p_id, int u_id) throws DataAccessException;
	void cancelLike (int p_id, int u_id) throws DataAccessException;
	int  checkLike(int p_id, int u_id) throws DataAccessException;
	void insertDisLike(int p_id, int u_id) throws DataAccessException;
	void cancelDisLike (int p_id, int u_id) throws DataAccessException;
	int  checkDisLike(int p_id, int u_id) throws DataAccessException;
	
}
