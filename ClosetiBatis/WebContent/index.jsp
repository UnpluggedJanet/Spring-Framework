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
<link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>"/>
<style type="text/css">
	<style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }

 /*     
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

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

      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
      


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
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0; */
        
        /* CUSTOMIZE THE CAROUSEL
    -------------------------------------------------- */
		 /* Special class on .container surrounding .navbar, used for positioning it into place. */
    .navbar-wrapper {
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      z-index: 10;
      margin-top: 20px;
      margin-bottom: -90px; /* Negative margin to pull up carousel. 90px is roughly margins and height of navbar. */
    }
    .navbar-wrapper .navbar {

    }

    /* Remove border and change up box shadow for more contrast */
    .navbar .navbar-inner {
      border: 0;
      -webkit-box-shadow: 0 2px 10px rgba(0,0,0,.25);
         -moz-box-shadow: 0 2px 10px rgba(0,0,0,.25);
              box-shadow: 0 2px 10px rgba(0,0,0,.25);
    }

    /* Downsize the brand/project name a bit */
    .navbar .brand {
      padding: 14px 20px 16px; /* Increase vertical padding to match navbar links */
      font-size: 16px;
      font-weight: bold;
      text-shadow: 0 -1px 0 rgba(0,0,0,.5);
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
      
     
     
		
    /* Offset the responsive button for proper vertical alignment */
    .navbar .btn-navbar {
      margin-top: 10px;
    }
    
    /* Carousel base class */
    .carousel {
      margin-bottom: 60px;
    }

    .carousel .container {
      position: relative;
      z-index: 9;
    }

    .carousel-control {
      height: 80px;
      margin-top: 0;
      font-size: 120px;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
      background-color: transparent;
      border: 0;
      z-index: 10;
    }

    .carousel .item {
      height: 500px;
    }
    .carousel img {
      position: absolute;
      top: 0;
      left: 0;
      min-width: 100%;
      height: 500px;
    }

    .carousel-caption {
      background-color: transparent;
      position: static;
      max-width: 550px;
      padding: 0 20px;
      margin-top: 200px;
    }
    .carousel-caption h1,
    .carousel-caption .lead {
      margin: 0;
      line-height: 1.25;
      color: #fff;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
    }
    .carousel-caption .btn {
      margin-top: 10px;
    }
      }
</style>


</head>
<body>

	<div class="container">
		<div class="masthead">
			<h3 class="muted">This is your Closet! 옷장</h3> 
      <div class="navbar">
      	<div class="navbar-inner">
          <div class="container">
            <ul class="nav">
            	<li><a href="home.do">Home</a></li>
             	<li><a href="signup.do">SignUp</a></li>
             	<li><a href="login.do">Login</a></li>
            </ul>
          </div>
        </div>
      </div><!-- /.navbar -->
    </div>
   </div>

 <!-- Carousel
    ================================================== -->
   <div id="myCarousel" class="carousel slide">
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    <li data-target="#myCarousel" data-slide-to="1"></li>
	    <li data-target="#myCarousel" data-slide-to="2"></li>
	  </ol>
    <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="img/closet.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>당신을 위한 스타일을 참고해보세요.</h1>
              <p class="lead">매일 아침 무슨 옷을 입을까 고민하는 당신을 위한 곳입니다. 날씨, 장소에 맞는 스타일을 참고해보세요. </p>
              <a class="btn btn-large btn-primary" href="signup.do">오늘 가입해보세요.</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/fashion2.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>당신의 스타일을 공유해보세요.</h1>
              <p class="lead">오늘은 어떤 옷을 입으셨나요? 친구들에게 자랑해보아요.</p>
              <a class="btn btn-large btn-primary" href="login.do">로그인하기</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/closet2.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>당신의 스타일을 정리해줄 옷장입니다.</h1>
              <p class="lead">여러분의 스타일을 기록해보고, 공유할 수 있습니다. 지금부터 시작해보세요. </p>
              <a class="btn btn-large btn-primary" href="signup.do">오늘부터 시작하기.</a>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->
  </div>


	 <!-- Le javascript
    ================================================== -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
   
  
    <script type="text/javascript"> 
          $('.carousel').carousel() 
    </script>
    <script src="js/holder/holder.js"></script>

</body>
</html>