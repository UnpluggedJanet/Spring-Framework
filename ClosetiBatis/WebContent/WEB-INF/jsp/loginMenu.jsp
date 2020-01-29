<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Form</title>
<!-- Bootstrap, css 설정 -->
<link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<style type="text/css">
	<style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }


      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
     
</style>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>"/>

</head>
<body>

	<div class="container">
		<div class="masthead">
			<h3 class="muted">This is your Closet! 옷장</h3>
      <div class="navbar">
      	<div class="navbar-inner">
          <div class="container">
            <ul class="nav">

             	<li><a href="myPage.do">MyPage <i class="icon-heart"></i></a></li>
             	<li><a href="newsfeed.do">Newsfeed <i class="icon-list-alt"></i></a></li>
             	<li><a href="newPost.do">NewPost <i class="icon-camera"></i></a></li>
             	<li><a href="searchPost.do">Search <i class="icon-search"></i></a></li>
             	<li><a href="following.do">Following <i class="icon-random"></i></a></li>
             	<li><a href="finduser.do">Find User <i class="icon-search"></i></a></li>
             	<li><a href="logout.do">Logout <i class="icon-off"></i></a></li>
            </ul>
          </div>
        </div>
      </div><!-- /.navbar -->
    </div>
   </div>
     
	