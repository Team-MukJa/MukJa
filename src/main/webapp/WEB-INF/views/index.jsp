<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

	<!-- 메인 페이지-->
	<main id="main">
	<section id="hero">
		<div class="hero-container" data-aos="fade-up">
			<h1>여행을 떠나요!</h1>
			<h2>즐거운 마음으로</h2>
			<div
				style="position: absolute; top: 55%; border-radius: 10px; width: 50%; height: 50%">
				<div class="icon-boxes position-relative">
					<div class="container position-relative">
						<div class="row gy-4 mt-5">
							<div class="col-xl-4 col-md-6" data-aos="fade-up"
								data-aos-delay="100">
								<div class="icon-box">
									<h4 class="title">
										<a href="${root}/search/search_place.jsp" class="stretched-link">여행지
											검색</a>
									</h4>
								</div>
							</div>
							<!--End Icon Box -->

							<div class="col-xl-4 col-md-6" data-aos="fade-up"
								data-aos-delay="200">
								<div class="icon-box">
									<h4 class="title">
										<a href="${root}/hotplace/hotplace_list.jsp" class="stretched-link">핫플레이스</a>
									</h4>
								</div>
							</div>
							<!--End Icon Box -->

							<div class="col-xl-4 col-md-6" data-aos="fade-up"
								data-aos-delay="300">
								<div class="icon-box">
									<h4 class="title">
										<a href="${root}/plan/plan_list.jsp" class="stretched-link">여행 계획</a>
									</h4>
								</div>
							</div>
							<!--End Icon Box -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- End Hero --> </main>
	<!-- 하단 footer end -->

	<!-- ======= Footer ======= -->
	<div class="container mt-5">
		<footer class="py-3 my-4">
			<p class="text-center text-muted">© 2023 HongCompany, Inc</p>
		</footer>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e5f46b0f0ef1df5cba8b565bc80a020&libraries=services"></script>
	<script src="${root}/assets/js/map.js"></script>
	<script src="${root}/assets/js/main.js"></script>
</body>
</html>