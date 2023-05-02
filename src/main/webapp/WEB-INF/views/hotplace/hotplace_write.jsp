<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
    <!-- 메인 페이지-->
    <main id="main">
      <!-- ======= 검색 내역 Section ======= -->
      <!-- <section id="contact" class="contact section-bg"> -->
      <div style = "height: 60px;"> </div>
      <div class="container">
      <div class="row g-3">
        <div class="col-md-6  ">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">핫플레이스</span>
          </h4>

         <div id="map" style="width:100%;height:350px;"></div>
          <div id="clickLatlng"></div>
        </div>

        <div class="col-md-6 ">
          <h4 class="mb-3">여행지를 등록해보세요</h4>
          <form class="needs-validation" novalidate>
            <div class="row g-3">
              <div class="col-12">
                <label for="firstName" class="form-label">사진 올려라</label>
                <input
                  type="file"
                  class="form-control"
                  id="firstName"
                  placeholder=""
                  value=""
                  required
                />
                <div class="invalid-feedback">ㄴㅇㄹ</div>
              </div>
              <div class="col-12">
                <label for="firstName" class="form-label">여행지의 이름 </label>
                <input
                  type="text"
                  class="form-control"
                  id="firstName"
                  placeholder=""
                  value=""
                  required
                />
                <div class="invalid-feedback">ㄴㅇㄹ</div>
              </div>

              <div class="col-12">
                <label for="lastName" class="form-label">다녀온 날짜</label>
                <input
                  type="date"
                  class="form-control"
                  id="lastName"
                  placeholder=""
                  value=""
                  required
                />
                <div class="invalid-feedback">ㄴㄹㅇㄹ</div>
              </div>

              <div class="col-12">
                <label for="lastName" class="form-label">장소유형</label>
                <input
                  type="date"
                  class="form-control"
                  id="lastName"
                  placeholder=""
                  value=""
                  required
                />
                <div class="invalid-feedback">ㄴㄹㅇㄹ</div>
              </div>

              <div class="col-8">
                <label for="lastName" class="form-label">상세설명</label>
                <div class="input-group">
                  <textarea class="form-control" aria-label="With textarea"></textarea>
                </div>
              </div>
            

            </div>

            <hr class="my-4" />


            <button class="w-100 btn btn-primary btn-lg" type="submit"> 제출
            </button>
          </form>
        </div>
      </div>
      </div>

      <!-- </section> -->
      <!-- End 검색내역 Section -->
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
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e5f46b0f0ef1df5cba8b565bc80a020&libraries=services"></script>
    <script src="${root}/assets/js/hot.js"></script>
    <script src="${root}/assets/js/main.js"></script>
  </body>
</html>
