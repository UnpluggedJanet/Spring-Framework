package com.closet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.closet.domain.Post;

public interface FollowDao {

	void createFollow(int id, int f_id) throws DataAccessException;
	List<Integer> getFollowing (int id) throws DataAccessException;
	List<Integer> getFollowers (int id) throws DataAccessException;
}
