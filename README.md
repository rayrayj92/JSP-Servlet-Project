# JSP-Servlet-Project

## 개요
JSP Servlet을 사용하여 게시판과 로그인 기능을 구현해보았습니다. 

## 기술
* Java Servlet 4.0.1
* Maven 3.8.0
* MySQL 8.0.19
* Hibernate 5.2.18
* Bootstrap 4.4.1
* CK Editor 4.14.0

## 기능
* 게시판
    * Input 값 유효성 체크[Back-End, Front-End(HTML5 Attribute)]
    * 작성(Create)
        * 첨부파일 저장
        * 위지위그(CK Editor)
    * 조회(Read)
        * 첨부파일 다운로드
        * 조회수 + 1 Update
    * 수정(Update)
        * 첨부파일 수정 및 저장
        * 위지위그(CK Editor)
    * 삭제(Delete)
        * 일괄삭제[Batch Delete]
* 로그인
    * 모든 페이지 별 세션 체크 및 이용자 ROLE 체크
    * 세션 타이머 값 지정
    * Input 값 유효성 체크[Back-End, Front-End(HTML5 Attribute)]
    * 로그아웃 [세션 파괴]
* 에러 페이지
    * 커스텀 404,500 및 자바 예외처리 에러 페이지
    
## 데모
링크 -> https://youtu.be/-izPTHH8U4c
