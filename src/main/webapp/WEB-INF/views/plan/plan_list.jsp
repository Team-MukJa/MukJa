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
                <tr class="text-center">
                  <th scope="row">1</th>
                  <td class="text-start">
                    <a
                      href="#"
                      class="article-title link-dark"
                      data-no=""
                      style="text-decoration: none"
                    >
                      부산 여행 계획  
                    </a>
                  </td>
                  <td>ssafy</td>
                  <td>1</td>
                  <td>2023.03.28.</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="row">
            <ul class="pagination justify-content-center">
              <li class="page-item">
                <a class="page-link" href="#">이전</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item active">
                <a class="page-link" href="#">2</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">4</a></li>
              <li class="page-item"><a class="page-link" href="#">5</a></li>
              <li class="page-item"><a class="page-link" href="#">다음</a></li>
            </ul>
          </div>
        </div>
      </div>
    </main>
    <!-- 하단 footer end -->

    <!-- ======= Footer ======= -->
    <div class="container mt-5">
      <footer class="py-3 my-4">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
          <li class="nav-item">
            <a href="#" class="nav-link px-2 text-muted">Home</a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link px-2 text-muted">Features</a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link px-2 text-muted">Pricing</a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link px-2 text-muted">FAQs</a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link px-2 text-muted">About</a>
          </li>
        </ul>
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
          location.href =
            "${root}/article?action=view&articleno=" + this.getAttribute("data-no");
        });
      });

      document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "${root}/article?action=mvwrite";
      });
    </script>
    <script src="./assets/js/main.js"></script>
  </body>
</html>
