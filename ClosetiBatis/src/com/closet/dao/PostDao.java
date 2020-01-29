package com.closet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.closet.domain.Post;

public interface PostDao {

	void createPost(Post post) throws DataAccessException;
	void deletePost(int postId) throws DataAccessException;
	Post getPost(int postId) throws DataAccessException;
	List<Post> showNewsfeed() throws DataAccessException;
	List<Post> getUserPosts(int memberId) throws DataAccessException;
	int updatePost(int postId, int n_like, int n_dislike) throws DataAccessException;
}
