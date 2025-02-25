# 약국 유통기한 임박 자동 알림 사이트 AAP (AutoAlertPharm)
https://www.youtube.com/watch?v=3SfG-X87CH4&t=3s
## 프로젝트 개요

### 수행 기간
- 2024년 7월 2일 ~ 2024년 7월 21일

### 수행 인원
- 1명

### 프로젝트 주제
- 약국 유통기한 임박 자동 알림 사이트 AAP (AutoAlertPharm)

### 목적과 목표
1. 이메일을 통해 약사들이 자신의 약국에 유통기한이 임박한 약품들을 인지할 수 있도록 함
2. 약품 구매 시 보유 약품 품목에서 유통기한과 고유번호가 일치할 경우 품목 개수를 자동으로 증가시키거나 새로운 품목으로 추가
3. 처방전 작성 시 보유하고 있는 약품을 사용했을 경우 자동으로 차감

## 기술 아키텍처

### 프로그래밍 언어
- Java

### 프레임워크
- Spring Tool Suite
- Ajax

### 데이터베이스
- MySQL

### 프론트엔드
- HTML
- CSS
- JavaScript
- JQuery
- Bootstrap

### 버전 관리
- Git
- GitHub

### 배포 환경
- 로컬 서버 (Tomcat)

## 주요 기능 & 기술

1. **보유하고 있는 약품 목록 수정 및 삭제**
    - 회원 정보의 PK를 사용해 DB에서 본인에게 해당하는 약품들을 전부 출력
    - 남아있는 약들의 유통기한 및 남은 수량 수정 가능
    - 잘못 입력한 약들은 삭제 가능

2. **약 구매 시 자동 추가 및 누락된 약 검색**
    - 사이트에서 약 구매 시 이름과 유통기한이 일치하는 약이 있을 시 수량 증가
    - 이름이 일치하되 유통기한이 다르면 다른 약으로 판단하여 새로운 개체로 추가
    - 구매 이외에 추가로 기재해야 하는 약들도 유통기한이 일치하면 수량이 증가하고 다른 값일 경우 새로운 데이터 생성

3. **처방전 작성 시 상세 정보 저장 및 자동 차감**
    - 처방전 작성 시 해당 처방전에 대한 약품 정보를 별도로 저장 (처방전 PK 참조)
    - 처방전 작성 시 사용자가 보유한 약품에서 자동으로 차감
    - 작성한 처방전을 상세히 보거나 수정 및 삭제 가능

4. **로그인 및 회원가입 기능**
    - 회원 가입 시 근무하는 병원, 전문가 면허, 근무지 전화번호, 전문가 면허 파일 참조
    - 관리자가 회원 대기 명단에서 가입 허가 시 등급 상승
    - 아이디와 비밀번호 찾기 시 이메일로 인증코드 전송하여 일치 시 비밀번호 초기화
    - 로그인이 안 되거나 등급 상승 전에 사이트에 접근 시 로그인 화면으로 반환
    - 관리자는 전문가 회원 허가를 위한 업로드된 파일 다운로드 가능
    - 카카오톡 API를 이용한 카카오톡 로그인 필수

5. **유통기한 임박 약품 이메일 알림**
    - 로그인 시 사용자가 보유하고 있는 유통기한이 임박한 약품 목록을 이메일로 전달

## 역할과 기여

- 프로젝트 기획 및 전체적인 코드 구현
- PPT 작성 및 API 자료 서치
- DB 설계 및 작성
- 기능 사용법 촬영 및 편집

---

## 사용된 기술 스택

- **프로그래밍 언어**: Java
- **프레임워크**: Spring Tool Suite, Ajax
- **데이터베이스**: MySQL
- **프론트엔드**: HTML, CSS, JavaScript, JQuery, Bootstrap
- **버전 관리**: Git, GitHub
- **배포 환경**: 로컬 서버 (Tomcat)

---
