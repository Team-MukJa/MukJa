<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
    <!-- 메인 페이지-->
    <main id="main">
      <!-- ======= 검색 내역 Section ======= -->
      <section id="contact" class="contact section-bg ">
        <div style="height: 100px"></div>
        <div class="container" data-aos="fade-up">
          <div class="section-title mt-3">
            <h2>여행 계획을 세워보세요!</h2>
          </div>
          <!-- 검색 창 시작 -->
          <div class="row ">
            <form class="d-flex my-3" onsubmit="return false;" role="search">
              <input
                id="search-keyword""WebContent/assets/js/plan.js"
                class="form-control me-2"
                type="search"
                placeholder="검색어"
                aria-label="검색어"
              />
              <button
                id="btn-plan-search"
                class="btn btn-outline-success"
                type="button"
              >
                검색
              </button>
            </form>
          </div>
          <!-- 검색 창 끝 -->
          <!-- 지도 시작 -->
          <div class="row">
            <div class="col-lg-12">
              <!-- <div id="map" class="mt-3" style="width: 100%; height: 600px"></div> -->
              <div class="map_wrap">
                <div id="map" style="width:100%;height:700px;position:relative;overflow:hidden;"></div>
                <div id="menu_wrap" class="bg_white">
                    <div class="option">
                        <div>
                            <form id onsubmit="searchPlaces(); return false;">
                                결과 목록 
                                <button type="submit" id = "save">저장하기</button>
                                 
                            </form>
                          </div>
                        </div>
                        <hr>
                        <ul id="placesList"></ul>
                        <div id="pagination"></div>
                      </div>
            </div>
            </div>
          </div>
          
          <!-- 지도 끝 -->
        </div>
        <div style="height: 300px"></div>
  
      </section>
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
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e5f46b0f0ef1df5cba8b565bc80a020&libraries=services"
    ></script>
    <script src="${root}/assets/js/plan.js"></script>
    <script src="${root}/assets/js/main.js"></script>
  </body>
</html>
