<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Enjoy Trip!</title>
<link rel="shortcut icon" href="${root}/assets/img/travel.jpg" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
<link href="${root}/assets/css/list.css" rel="stylesheet"
	type="text/css" />
<link href="${root}/assets/css/main.css" rel="stylesheet"
	type="text/css" />

<script src="${root}/assets/js/key.js"></script>
</head>
<body>
	<!-- 상단 navbar start -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold" href="${root}/index.jsp">
				<img src="${root}/assets/img/캡처.PNG" alt="" width="60" /> Enjoy
				Trip
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="${root}/notice?action=list">공지사항</a></li>
				</ul>
				<!-- 로그인 전 -->
				<c:if test="${empty userInfo}">
					<ul class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${root}/search/search_place.jsp" id="E">여행지 검색 </a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="#" id="${root}/plan/plan_list.jsp">여행 계획</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${root}/hotplace/hotplace_list.jsp" id="E">핫플레이스</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${root}/member?action=mvjoin" id="A">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${root}/member?action=mvlogin" id="B">로그인</a></li>
					</ul>
			</div>
		</div>
	</nav>
	</c:if>
	<c:if test="${not empty userInfo}">
		<!-- 로그인 후 -->
		<ul class="navbar-nav mb-2 me-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/search/search_place.jsp" id="E">여행지 검색 </a></li>
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/plan/plan_list.jsp" id="E">여행 계획</a></li>
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/hotplace/hotplace_list.jsp" id="E">핫플레이스</a></li>
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/member?action=logout" id="C">로그아웃</a></li>
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/member?action=mypage" id="D">마이페이지</a></li>
		</ul>
		</div>
		</div>
		</nav>
	</c:if>
	<!-- 상단 navbar end -->