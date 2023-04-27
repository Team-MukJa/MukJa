<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
    <div class="container">
      <div style = "height: 200px;"> </div>

      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="orange">마이페이지</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-change" method="POST" action="">
          <div class="mb-3">
              <label for="userpwd" class="form-label">아이디 : </label>
              <input
                type="text"
                class="form-control"
                id="userid"
                name="userid"
                value = "${userInfo.userId}"
                placeholder="아이디"
                readonly
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
            <div class="mb-3">
              <label for="pwdcheck" class="form-label">비밀번호확인 : </label>
              <input
                type="password"
                class="form-control"
                id="pwdcheck"
                placeholder="비밀번호확인..."
              />
            </div>
            <div class="mb-3">
              <label for="emailid" class="form-label">이메일 : </label>
              <div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="emailid"
                  name="emailid"
                  placeholder="이메일아이디"
                />
                <span class="input-group-text">@</span>
                <select
                  class="form-select"
                  id="emaildomain"
                  name="emaildomain"
                  aria-label="이메일 도메인 선택"
                >
                  <option selected>선택</option>
                  <option value="ssafy.com">싸피</option>
                  <option value="google.com">구글</option>
                  <option value="naver.com">네이버</option>
                  <option value="kakao.com">카카오</option>
                </select>
              </div>
            </div>

            <div class="col-auto text-center">
              <button type="button" id="btn_change" class="btn btn-outline-primary mb-3">
                정보 변경
              </button>
              <a href="${root}/index.jsp">
                <button type="button" class="btn btn-outline-success mb-3" id="change_cancle">
                  취소
                </button></a
              >
              <a href="${root}/member?action=Delete&userid=${userInfo.userId}">
                <button type="button" class="btn btn-outline-success mb-3" id="btn_delete" >
                  회원 탈퇴
                </button>
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
      document.querySelector("#btn_change").addEventListener("click", function () {
        if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (
          document.querySelector("#userpwd").value != document.querySelector("#pwdcheck").value
        ) {
          alert("비밀번호 확인!!");
          return;
        } else {
          let form = document.querySelector("#form-change");
          form.setAttribute("action", "${root}/member?action=modify");
          form.submit();
        }
      });
    </script>

  </body>
</html>
