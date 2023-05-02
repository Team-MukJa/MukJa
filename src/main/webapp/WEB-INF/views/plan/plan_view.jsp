<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

    <!-- 메인 페이지-->
    <main id="main">
        <div class="container">
            <div style = "height: 200px;"> </div>
            <div class="section-title mt-3">
            <h2>나의 여행 계획</h2>
          </div>
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="http://tong.visitkorea.or.kr/cms/resource/67/2612467_image2_1.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>해운대 해수욕</h5>
                  <p>부산 대표 해수욕장, 해운대해수욕장 부산의 대표 해수욕장인 해운대해수욕장.'
                  </p>
                  <p>위치
                  </p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="http://tong.visitkorea.or.kr/cms/resource/65/1804865_image2_1.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>해운대 동백섬</h5>
                  <p>'해운대해수욕장에서 탁 트인 바다를 바라보다 오른편으로눈길을 돌리면 백사장이 끝나는 지점에 조선비치호텔이 있고 그 뒤편에 아담하게 동백섬이 자리하고 있다.</p>
                </div>
              </div>
           
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
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
    <script src="${root}/assets/js/main.js"></script>
  </body>
</html>
