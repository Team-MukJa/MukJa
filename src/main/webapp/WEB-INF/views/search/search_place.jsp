<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

    <main id="main">
      <!-- ======= 검색 내역 Section ======= -->

      <section id="contact" class="contact section-bg">
        <div class="container" data-aos="fade-up">
          <div class="section-title mt-3">
            <h2>여행정보를 입력하세요</h2>
          </div>
          <!-- 검색 창 시작 -->
          <div class="row">
            <form class="d-flex my-3" onsubmit="return false;" role="search">
              <select id="search-area" class="form-select me-2">
                <option value="0" selected>검색 할 지역 선택</option>
                <option value="1">서울</option>
                <option value="2">인천</option>
                <option value="3">대전</option>
                <option value="4">대구</option>
                <option value="5">광주</option>
                <option value="6">부산</option>
                <option value="7">울산</option>
                <option value="8">세종특별자치시</option>
                <option value="31">경기도</option>
                <option value="32">강원도</option>
                <option value="33">충청북도</option>
                <option value="34">충청남도</option>
                <option value="35">경상북도</option>
                <option value="36">경상남도</option>
                <option value="37">전라북도</option>
                <option value="38">전라남도</option>
                <option value="39">제두도</option>
                
              </select>
              <select id="search-content-id" class="form-select me-2">
                <option value="0" selected>관광지 유형</option>
                <option value="12">관광지</option>
                <option value="14">문화시설</option>
                <option value="15">축제공연행사</option>
                <option value="25">여행코스</option>
                <option value="28">레포츠</option>
                <option value="32">숙박</option>
                <option value="38">쇼핑</option>
                <option value="39">음식점</option>
              </select>
              <input
                id="search-keyword"
                class="form-control me-2"
                type="search"
                placeholder="검색어"
                aria-label="검색어"
              />
              <button
                id="btn-search"
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
                <div
                  id="map"
                  style="
                    width: 100%;
                    height: 700px;
                    position: relative;
                    overflow: hidden;
                  "
                ></div>
                <div id="menu_wrap" class="bg_white">
                  <div class="option">
                    <div>
                      <form onsubmit="searchPlaces(); return false;">
                        결과 목록
                      </form>
                    </div>
                  </div>
                  <hr />
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
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e5f46b0f0ef1df5cba8b565bc80a020&libraries=services"></script>
    <script src="${root}/assets/js/map3.js"></script>
    <script src="${root}/assets/js/main.js"></script>
  </body>
</html>
