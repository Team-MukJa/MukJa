<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

<!-- 메인 페이지-->
    <main id="main">
      <div class="container">
        <div style="height: 200px"></div>
        <div class="row justify-content-center">
          <div class="col-lg-8 col-md-10 col-sm-12">
            <div class="row align-self-center mb-2">
              <div class="col-md-2 text-start">
                <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                  글쓰기
                </button>
              </div>
              <div class="col-md-7 offset-3">
                <form class="d-flex">
                  <select
                    id="key"
                    class="form-select form-select-sm ms-5 me-1 w-50"
                    aria-label="검색조건"
                  >
                    <option selected>검색조건</option>
                    <option value="articleno">글번호</option>
                    <option value="subject">제목</option>
                    <option value="userid">작성자</option>
                  </select>
                  <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="검색어..." />
                    <button class="btn btn-dark" type="button">검색</button>
                  </div>
                </form>
              </div>
            </div>
            <table class="table table-hover">
              <thead>
                <tr class="text-center">
                  <th scope="col">글번호</th>
                  <th scope="col">제목</th>
                  <th scope="col">작성자</th>
                  <th scope="col">조회수</th>
                  <th scope="col">작성일</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="notice" items="${articles}">  
                <tr class="text-center">
                  <th scope="row">${notice.articleNo}</th>
                  <td class="text-start">
                    <a
                      href="${root}/notice?action=view"
                      class="article-title link-dark"
                      data-no=""
                      style="text-decoration: none"
                    >
                      ${notice.subject}
                    </a>
                  </td>
                  <td>${notice.userId}</td>
                  <td>${notice.hit}</td>
                  <td>${notice.registerTime}</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <div class="row">
            ${navigation.navigator}
          </div>
        </div>
      </div>
      <form id="form-param" method="get" action="">
      <input type="hidden" id="p-action" name="action" value="">
      <input type="hidden" id="p-pgno" name="pgno" value="">
      <input type="hidden" id="p-key" name="key" value="">
      <input type="hidden" id="p-word" name="word" value="">
    </form>
    </main>

    <!-- ======= Footer ======= -->
    <div class="container mt-5">
      <footer class="py-3 my-4">
        <p class="text-center text-muted">© 2023 Company, Inc</p>
      </footer>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e5f46b0f0ef1df5cba8b565bc80a020&libraries=services"
    ></script>
    <script>
      let titles = document.querySelectorAll(".article-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
          console.log(this.getAttribute("data-no"));
          location.href = "${root}/notice?action=view&articleno=" + this.getAttribute("data-no");
        });
      });

      document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "${root}/notice?action=mvwrite";
      });
      
      document.querySelector("#btn-search").addEventListener("click", function () {
    	  let form = document.querySelector("#form-search");
          form.setAttribute("action", "${root}/notice");
          form.submit();
      });
      
      let pages = document.querySelectorAll(".page-link");
      pages.forEach(function (page) {
        page.addEventListener("click", function () {
          console.log(this.parentNode.getAttribute("data-pg"));
          document.querySelector("#p-action").value = "list";
       	  document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
       	  document.querySelector("#p-key").value = "${param.key}";
       	  document.querySelector("#p-word").value = "${param.word}";
          document.querySelector("#form-param").submit();
        });
      });
    </script>
    <script src="./assets/js/map.js"></script>
    <script src="./assets/js/main.js"></script>
  </body>
</html>