package com.closet.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import java.util.List;

public class Post {
	int postId;
	String postDate;
	String text;
	MultipartFile imgFile;
	String img;
	int memberid;
	String username;
	boolean like;
	boolean disLike;
	List<Integer> categoryList1;
	List<Integer> categoryList2;
	int category;
	int n_like;
	int n_dislike;

	
	public Post(){}
	
	public Post(int postId){
		this.postId=postId;
	}
	public Post(String text,String img){
		this.text=text;
		this.img=img;
	}
	
	public Post(String postDate, String text,String img){
		this.postDate=postDate;
		this.text=text;
		this.img=img;
	}
	
	public Post(int postId, String text,String img){
		this.postId=postId;
		this.text=text;
		this.img=img;
	}
	public Post(int postId, String postDate, String text,String img){
		this.postId=postId;
		this.postDate=postDate;
		this.text=text;
		this.img=img;
	}
	
	public Post(int postId, String postDate, String text,String img, int memberid, String username){
		this.postId=postId;
		this.postDate=postDate;
		this.text=text;
		this.img=img;
		this.memberid = memberid;
		this.username = username;
	}
	
	public Post(String text, String img, List<Integer> categoryList1, List<Integer> categoryList2){
		this.text=text;
		this.img=img;
		this.categoryList1=categoryList1;
		this.categoryList2=categoryList2;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public boolean isDisLike() {
		return disLike;
	}

	public void setDisLike(boolean disLike) {
		this.disLike = disLike;
	}

	public List<Integer> getCategoryList1() {
		return categoryList1;
	}

	public void setCategoryList1(List<Integer> categoryList1) {
		this.categoryList1 = categoryList1;
	}

	public List<Integer> getCategoryList2() {
		return categoryList2;
	}

	public void setCategoryList2(List<Integer> categoryList2) {
		this.categoryList2 = categoryList2;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getN_like() {
		return n_like;
	}

	public void setN_like(int n_like) {
		this.n_like = n_like;
	}

	public int getN_dislike() {
		return n_dislike;
	}

	public void setN_dislike(int n_dislike) {
		this.n_dislike = n_dislike;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	
}
