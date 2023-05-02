<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Enjoy Trip!</title>
    <link rel="shortcut icon" href="/assets/img/travel.jpg" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <link href="${root}/assets/css/list.css" rel="stylesheet" type="text/css" />
    <link href="${root}/assets/css/main.css" rel="stylesheet" type="text/css" />

    <script src="${root}/assets/js/key.js"></script>
  </head>
  <body>
    <!-- 상단 navbar start -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold"
				href="${root}/index.jsp"> <img src="${root}/assets/img/캡처.PNG"
				alt="" width="60" /> Enjoy Trip
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
						href="#">공지사항</a></li>
				</ul>
				<!-- 로그인 전 -->
				<c:if test="${empty userInfo}">
					<ul class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="#" id="E";>여행지 검색 </a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="#" id="E";>여행 계획</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="#" id="E";>핫플레이스</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${root}/member?action=mvjoin" id="A">회원가입</a>
						</li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${root}/member?action=mvlogin" id="B">로그인</a>
						</li>
					</ul>
			</div>
		</div>
	</nav>
	</c:if>
	<c:if test="${not empty userInfo}">
		<!-- 로그인 후 -->
		<ul class="navbar-nav mb-2 me-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/member?action=logout" id="C">로그아웃</a>
			</li>
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="${root}/member?action=mypage" id="D">마이페이지</a>
			</li>
		</ul>
	</div>
	</div>
	</nav>
	</c:if>
	<!-- 상단 navbar end -->
    <div class="container">
      <div style = "height: 200px;"> </div>

      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="orange">로그인</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-login" method="POST" action="">
            <div class="form-check mb-3 float-end">
              <input
                class="form-check-input"
                type="checkbox"
                value="ok"
                id="saveid"
                name="saveid"
              />
              <label class="form-check-label" for="saveid"> 아이디저장 </label>
            </div>
            <div class="mb-3">
              <label for="userid" class="form-label">아이디 : </label>
              <input
                type="text"
                class="form-control"
                id="userid"
                name="userid"
                placeholder="아이디..."
              />
            </div>
            <div class="mb-3">
              <label for="userpwd" class="form-label">비밀번호 : </label>
              <input
                type="password"
                class="form-control"
                id="userpwd"
                name="userpwd"
                placeholder="비밀번호..."
              />
            </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">
                로그인
              </button>
              <a href="${root}/member?action=mvjoin">
                <button type="button" class="btn btn-outline-success mb-3">회원가입</button>
              </a>
              <a href="${root}/index.jsp">
                <button type="button" class="btn btn-outline-success mb-3">취소</button>
              </a>
            </div>
          </form>
        </div>
      </div>
    </div>
    	<!-- ======= Footer ======= -->
	<div class="container mt-5">
		<footer class="py-3 my-4">

			<p class="text-center text-muted">© 2023 HongCompany, Inc</p>
		</footer>
	</div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script>
      document.querySelector("#btn-login").addEventListener("click", function () {
        if (!document.querySelector("#userid").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-login");
          form.setAttribute("action", "${root}/member?action=login");
          form.submit();
        }
      });
    </script>
  </body>
</html>

