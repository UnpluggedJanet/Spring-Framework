<%@ include file="notLoginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
              <h1>나만의 스타일을 정리해줄 옷장입니다.</h1>
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