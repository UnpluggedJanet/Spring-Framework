package com.closet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.closet.domain.Post;

public interface SearchDao {
	List<Post> searchPost(int category) throws DataAccessException;
}
