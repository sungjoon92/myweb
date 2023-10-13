<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>12_myweb인트로.html</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="layout.css">
</head>

<body>
  <!-- 참조 : https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_theme_me_complete&stacked=h -->
  
  <!-- 메인 카테고리 시작 -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">HOME</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">게시판</a></li>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">포토갤러리</a></li>
        <li><a href="#">메일보내기</a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- 메인 카테고리 끝 -->

<!-- content 시작 -->
<!-- First Container -->
<div class="container-fluid bg-1 text-center">
  <img src="images/friends.jpg" class="img-responsive img-circle margin" style="display:inline" alt="Bird" width="50%" height="350">
</div>
<!-- content 끝 -->

<!-- Second Container 시작 -->
<div class="container-fluid bg-2 text-center">
  <div class="row">
    <div class="col-xs-12"> 
      <!-- 본문 시작 -->
      여기에 본문 내용 작성합니다.
      <!-- 본문 끝 -->
    </div> <!-- col-xs-12 끝 -->
  </div> <!-- row 끝 -->
</div> 
<!-- Second Container 끝 -->



<footer class="container-fluid bg-4 text-center">
  <p>Bootstrap Theme Made By <a href="https://www.w3schools.com">www.w3schools.com</a></p> 
</footer>

</body>
</html>
