<div align="center">

# 🍕 먹고 , 🛌 자고 ! 즐거운 여행 ✈️
국내 관광지 정보와 여행 계획 서비스를 제공하는 웹사이트

##  🔥 Member 🔥 

|[<img src = "https://avatars.githubusercontent.com/u/101040824?v=4" width=100>](https://github.com/1212Hong)|[<img src = "https://avatars.githubusercontent.com/u/46624130?v=4" width = 100>](https://github.com/soo0300)| [<img src = "https://avatars.githubusercontent.com/u/82308415?v=4" width = 100>](https://github.com/https://github.com/byunyc0124)  | [<img src = "https://avatars.githubusercontent.com/u/107923409?v=4" width =100>](https://github.com/SeungJun) |
|:---:|------------------|---|:-------------------------------------------------------------------------------------------------------------:|
| 김대홍 |김수진|변영채|홍승준|

</div>

## :heavy_check_mark: 프로젝트 소개
- 국내 관광지 활성화를 위해 한국관광공사의 관광정보 서비스 API를 이용해 여행지 추천 서비스를 제공한다.
- 여행 계획과 나만의 핫플레이스르 작성해 공유하는 기능, 여행지를 검색하고 리뷰를 작성하는 기능을 제공한다.

## :heavy_check_mark: 기술 스택
<div >
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
 </div>
 <div>
<img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
 </div>
<div>
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
</div>

## :heavy_check_mark: 사용한 외부 API
- [한국국문관광공사 국문 관광정보 서비스 GW](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15101578)
- [한국천문연구원 출몰시각 정보](https://www.data.go.kr/iim/api/selectAPIAcountView.do)
- [카카오맵](https://apis.map.kakao.com/web/)

## :heavy_check_mark: ERD 다이어그램
![Image Pasted at 2023-4-14 17-15](https://user-images.githubusercontent.com/107923409/232202431-07efeb42-de16-44e1-b84f-1423378274d9.png)

## :heavy_check_mark: 핵심기능
- 로그인/회원가입 : Spring Security, JWT를 이용하여 인증, 인가, 비밀번호 암호화 구현
- 여행 계획 : 일자별 여행 계획 등록, 여행지 검색 후 선택, 일차 순으로 여행 계획 보기 
- 리뷰 : 검색한 여행지에 대한 리뷰 및 별점 등록
- 핫플레이스 : 카카오 api를 이용하여 장소 검색, 본인이 찍은 사진을 업로드해 핫플레이스 공유
- 마이페이지 : 자신이 쓴 글 확인

## :heavy_check_mark: 기능별 화면
- 메인 화면
![메인화면](https://github.com/Team-MukJa/MukJa/assets/101040824/5e79a8fc-1998-494c-aa1f-fb83da92f57f)
- 여행 계획
![여행 계획 작성](https://github.com/Team-MukJa/MukJa/assets/107923409/f2cf6c37-0813-4c35-a834-3221a846138b)
![여행 상세보기 작성](https://github.com/Team-MukJa/MukJa/assets/107923409/b851380e-7b8d-4539-8761-0bb99b7aa210)
- 여행 리뷰 
![여행지 검색 리뷰](https://github.com/Team-MukJa/MukJa/assets/107923409/e0c04c13-a500-44c1-ba5a-1fbee5e55caf)
- 공지사항
![공지사항](https://github.com/Team-MukJa/MukJa/assets/107923409/09c31b58-0391-49af-9580-65fec04c3a6d)
- 핫플레이스
![핫플레이스 작성](https://github.com/Team-MukJa/MukJa/assets/101040824/cf251e3b-b735-4a96-8da6-cd9f0d4b08f2)
![핫플 상세보기, 삭제](https://github.com/Team-MukJa/MukJa/assets/101040824/f11f8bf0-7862-4c94-80f4-23f1f4b6997e)

## **:sparkles: commit 규칙**
- feat: 새로운 파일 추가
- modify: 기능 변경
- update: 기능 추가
- delete: 파일 혹은 기능 삭제
- commenat: 주석 추가/삭제/변경
- fix: 버그 수정
- design: css나 ui 디자인 변경
- ename: 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
- refactor: 기능에 영향을 주지 않고 구조 수정
