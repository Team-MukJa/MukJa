# 2023-SSAFY Project

# Enjoy trip

#### Project member : Kim Dae Hong, Hong Seung Jun

---

## Description

사용자에게 한국의 다양한 관광지, 먹거리, 축제, 행사 등을 소개하여 지역 관광 활성화를 위한 지역 관광
소개 페이지를 구축하려고 한다. 한국관광공사에서 제공하는 국문관광정보서비스_GW의 다양한
상세기능정보 API를 활용하여 지역별 관광지 data를 분석하고 화면에 표시한다. 또한 여행계획을 위한
스케줄과 여행경로 공유 등 사용자 편의 기능을 구현하고 나만의 숨은 관광지를 소개하는 페이지와
자유롭게 토론이 가능한 게시판 등을 구현해 본다.
추가적으로 관광지의 날씨정보나 일출, 일몰시각, 관광경로상의 전기차 충전소등 다양한 아이디어를 통한
추가 기능도 구현해 보자.
위 기능들을 화면에 표시하기위해 필요한 Database를 설계하고 구현하여 보자.

## Environment

> html, css, js,jsp 
> Spring Boot
> MySQL, MyBatis
> Swagger
> Eclipse
> Windows

## Manual

## 진행 사항
1. Spring Boot 프로젝트로 변경(완료)

2. MyBatis 연동 (완료)

3. 스토리보드 작성 및 RESTful API 기반 설계 (완료)

4. 구현
- 로그인(로그인, 로그아웃) / 회원가입(회원 추가,삭제,수정,조회) 구현 (완료)
- 공지사항(등록,삭제, 수정, 조회) 구현 (완료)
- 여행지 검색 구현 (완료)
- 핫플레이스 (등록, 삭제, 수정, 조회) 구현 (완료)
- 여행 계획 구현 (진행 중)

## Swagger 실행화면
<img width="1082" alt="image" src="https://user-images.githubusercontent.com/107923409/235693820-04043da4-8ee1-4125-9cdc-2edc4c003fbe.png">

## ERD 다이어그램
![Image Pasted at 2023-4-14 17-15](https://user-images.githubusercontent.com/107923409/232202431-07efeb42-de16-44e1-b84f-1423378274d9.png)

## 스토리보드 및 API 설계

- 메인화면


  ![Untitled](https://user-images.githubusercontent.com/107923409/235691160-a5377e16-e673-4592-9499-a4a66f80a472.jpeg)

    
    - 화면 중간의 사진을 클릭하면 각 페이지로 이동한다.
- 회원가입
        
        
    ![Untitled 1](https://user-images.githubusercontent.com/107923409/235690304-f637d2fc-6277-4385-9ca0-ad81fa89dc7c.jpeg)


    - 각 항목의 데이터를 입력하여 회원가입
    
    | Method | URL | 기능 | 예시 |
    | --- | --- | --- | --- |
    | POST | /members/new-member | 회원가입 |  |
    | PUT | /members/{user-id} | 회원정보수정 |  |
    | DELETE | /members/{user-id} | 회원탈퇴 |  |
- 로그인
    
    
    ![Untitled 2](https://user-images.githubusercontent.com/107923409/235690351-6cebc143-305c-4d8b-b0c2-180b7cf0e21f.jpeg)


    - 아이디, 비밀번호 일치 확인을 통해 로그인
    - 아이디 저장 기능
    
    | Method | URL | 기능 | 예시 |
    | --- | --- | --- | --- |
    | GET | /members/login | 로그인 |  |
    | GET | /members/logout | 로그아웃 |  |
- 마이페이지

    ![Untitled 3](https://user-images.githubusercontent.com/107923409/235690375-b0829d8a-c230-44ae-a47d-9781f46d5501.jpeg)
    
    - 좌측에 회원의 정보가 표시된다.
    - 우측 여행 계획, 핫플레이스, 문의사항을 누르면 회원이 작성한 글만 보여주게 된다.
- 여행지 검색
    
    
    ![Untitled 4](https://user-images.githubusercontent.com/107923409/235690405-2faf270e-0ceb-4b23-8f1a-a0813b30de5a.jpeg)

    - 시/도, 군/구, 여행 타입을 선택하고 키워드를 입력 한다음 검색을 한다
    - 해당하는 장소들을 마커형식과 좌측 리스트 형식으로 띄워준다.
    - 리스트와 마크에 마우스를 올리면 장소의 정보가 표시 된다.
    
    | Method | URL | 기능 | 예시 |
    | --- | --- | --- | --- |
    | GET | /searches/{sido}/{gogun}/{keyword} | 여행지 검색 |  |
- 여행 계획
    - 여행 계획 리스트

    ![Untitled 5](https://user-images.githubusercontent.com/107923409/235690419-337c944c-b238-4de5-82e5-e2be8515ea85.jpeg)

     - 여행 계획을 위와 같은 형식으로 보여준다. 스크롤을 내리면 여행 계획들이 추가로 보여진다.
     - 여행 계획에는 여행 계획 제목, 요약, 대표사진들이 보여진다.
     - 해당 영역을 클릭했을때 여행 계획 보기로 이동한다.
     - 글 번호를 전달


    - 여행 계획 추가
        
        
      ![Untitled 6](https://user-images.githubusercontent.com/107923409/235690451-bda4104c-6cec-49c3-ba70-fbd5e076ffc9.jpeg)
      
        - 아래 페이지바를 통하여 일차를 선택한다.
        - 여행지를 검색하면 오른쪽 지도에 마커형식과 여행지 형식으로 표시된다.
        - 리스트나 마커를 클릭하면 가장 좌측 형태로 여행지가 추가 된다.
        - 여행지에 대한 간단한 메모를 할 수 있고 오른쪽 -버튼을 통하여 여행지를 삭제 할 수 있다.
        - 저장 버튼을 누르면 여행 계획이 저장된다.
    - 여행 계획 보기
        
        ![Untitled 7](https://user-images.githubusercontent.com/107923409/235691333-9b193300-3ea0-443f-98cb-29ea10b60e35.jpeg)

        - 일차 별로 여행 계획을 보여준다.
    - 여행지 보기
        
        ![Untitled 8](https://user-images.githubusercontent.com/107923409/235691361-17c74ebe-d286-41f3-a460-36a0bef09e1c.jpeg)

        - 여행지 사진이나 이름을 클릭하면 해당하는 여행지의 상세 정보를 보여준다.
    
    | Method | URL | 기능 | 예시 |
    | --- | --- | --- | --- |
    | GET | /plans/ | 여행 계획 리스트  |  |
    | GET | /plans/{plan-id} | 여행 계힉 상세보기 |  |
    | POST | /plans | 여행 계획 생성 |  |
    | POST | /plans/detail | 여행 계획 상세정보 등록 |  |
    | DELETE | /plans/{plan-id} | 여행 계획 삭제 |  |
- 핫플레이스
    - 핫플레이스 게시물 작성
        
        ![Untitled 9](https://user-images.githubusercontent.com/107923409/235691390-575a1c6c-93c6-42b9-a03e-b34d5ef6f1fa.jpeg)

        - 위치 검색을 통해 작성하려고 하는 핫플레이스의 위치를 정해준다
        - 제목, 내용, 이미지 추가를 통해 게시물을 작성한다
    - 핫플레이스 게시물 목록
        
        ![Untitled 10](https://user-images.githubusercontent.com/107923409/235691411-cd4fbd47-0792-486c-914f-31a80c875274.jpeg)

        - 유저들이 작성한 핫플레이스 게시물들을 보여준다
    - 핫플레이스 게시물 상세보기
        
        ![Untitled 11](https://user-images.githubusercontent.com/107923409/235691451-ac140ab6-e3b3-47e9-9832-c29c43bfede9.jpeg)

        - 게시물을 클릭하면 게시물 내용을 상세하게 볼 수 있다
    
    | Method | URL | 기능 | 예시 |
    | --- | --- | --- | --- |
    | POST | /places | 핫플레이스 작성 |  |
    | PUT | /places/{place-id} | 핫플레이스 수정 |  |
    | DELETE | /places/{place-id} | 핫플레이스 삭제 |  |
    | GET | /places | 핫플레이스 리스트 |  |
    | GET | /places/{place-id} | 핫플레이스 상세보기 |  |
    | POST | /places/{place-id} | 핫플레이스 임시 저장 |  |
- 공지사항 / 문의
    - 공지사항 / 문의하기 작성
        
        ![Untitled 12](https://user-images.githubusercontent.com/107923409/235691475-7ea8bcb7-0355-4c09-bc8b-987137266e50.jpeg)

        - 관리자는 공지사항을 작성할 수 있다
        - 일반 유저의 경우에는 1:1 문의하기 게시물을 작성할 수 있다
    - 공지사항 목록
        
        ![Untitled 13](https://user-images.githubusercontent.com/107923409/235691495-4386f5e3-2a56-418e-9299-60d6bd96bd2a.jpeg)

    - 문의사항 목록
        
        ![Untitled 14](https://user-images.githubusercontent.com/107923409/235691514-47616c7d-8152-4996-ac06-7a5eebedc61b.jpeg)

    
    | Method | URL | 기능 | 예시 |
    | --- | --- | --- | --- |
    | POST | /notices | 공지사항 작성 |  |
    | PUT | /notices/{notice-id} | 공지사항 수정 |  |
    | DELETE | /notices/{notice-id} | 공지사항 삭제 |  |
    | GET | /notices | 공지사항 리스트 |  |
    | GET | /notices/{notice-id} | 공지사항 상세보기 |  |
- 공통
    - 로그인 여부를 확인한다. (일단 session으로 진행)
        - 일반 사용자와 관리자를 구분한다.
