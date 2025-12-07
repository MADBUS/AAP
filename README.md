# 💊 AAP (AutoAlertPharm)

<div align="center">

### 약국 유통기한 임박 자동 알림 시스템

[![Demo Video](https://img.shields.io/badge/Demo-YouTube-red?style=for-the-badge&logo=youtube)](https://www.youtube.com/watch?v=3SfG-X87CH4&t=3s)
[![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com)

</div>

---

## 📋 목차

- [프로젝트 소개](#-프로젝트-소개)
- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [시스템 아키텍처](#-시스템-아키텍처)
- [화면 구성](#-화면-구성)
- [개발 환경](#️-개발-환경)

---

## 🎯 프로젝트 소개

### 📅 프로젝트 정보

| 항목 | 내용 |
|------|------|
| **프로젝트명** | AAP (AutoAlertPharm) - 약국 유통기한 임박 자동 알림 시스템 |
| **개발 기간** | 2024.07.02 ~ 2024.07.21 (3주) |
| **개발 인원** | 1명 (개인 프로젝트) |
| **프로젝트 유형** | 웹 애플리케이션 |

### 💡 기획 배경

약국에서 유통기한이 임박한 의약품 관리의 어려움을 해결하기 위해 기획된 자동화 시스템입니다.

### 🎯 핵심 목표
```
✉️ 이메일 자동 알림
   → 유통기한 임박 약품을 이메일로 자동 통지

📦 재고 자동 관리
   → 약품 구매 시 자동으로 재고 수량 업데이트

💊 처방전 연동
   → 처방전 작성 시 보유 약품 자동 차감
```

---

## ✨ 주요 기능

### 1️⃣ 약품 재고 관리
```
- 보유 약품 목록 조회 및 관리
- 유통기한 및 수량 실시간 수정
- 불필요한 약품 삭제 기능
```

**기술 구현**
- 회원 PK 기반 약품 데이터 조회
- AJAX를 통한 비동기 데이터 업데이트

---

### 2️⃣ 스마트 약품 입고 시스템
```
- 자동 재고 증가
  - 동일 약품(이름 + 유통기한 일치) → 수량 증가
  
- 신규 약품 자동 등록
  - 동일 이름 + 다른 유통기한 → 별도 품목 추가
```

**기술 구현**
- 약품명 + 유통기한 기반 중복 검사 로직
- 트랜잭션 처리를 통한 데이터 정합성 보장

---

### 3️⃣ 처방전 관리 시스템
```
📝 처방전 작성
   → 상세 정보 자동 저장

📉 재고 자동 차감
   → 처방 약품 사용 시 보유 약품에서 자동 차감

🔍 처방전 이력 관리
   → 조회, 수정, 삭제 기능
```

**기술 구현**
- 처방전-약품 매핑 테이블 설계 (FK 참조)
- 트리거를 활용한 재고 자동 차감

---

### 4️⃣ 회원 인증 시스템

#### 🔐 회원가입 및 승인 프로세스
```
회원가입 → 전문가 면허 업로드 → 관리자 승인 대기 → 승인 완료 → 서비스 이용
```

**회원가입 필수 정보**
- 근무 병원 정보
- 전문가 면허증
- 근무지 전화번호
- 면허증 파일 업로드

#### 🔑 로그인 기능

- **일반 로그인**: ID/PW 기반 인증
- **소셜 로그인**: 카카오톡 API 연동 (필수)
- **계정 찾기**: 이메일 인증을 통한 ID/PW 찾기

**보안 기능**
- 미승인 회원 접근 차단
- 세션 기반 권한 관리
- 비밀번호 암호화 저장

---

### 5️⃣ 유통기한 알림 시스템
```
📧 자동 이메일 발송
   
   [로그인 시점]
   └─→ 유통기한 임박 약품 목록
       └─→ 사용자 이메일로 자동 전송
```

**발송 조건**
- 유통기한 D-30 이내 약품
- 로그인 시 자동 트리거
- 개인별 맞춤 알림

---

## 🛠 기술 스택

### Backend
![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)

### Frontend
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)
![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jquery&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=flat-square&logo=bootstrap&logoColor=white)

### Tools & Deployment
![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white)
![Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=flat-square&logo=apache-tomcat&logoColor=black)

---

## 🏗 시스템 아키텍처
```
┌─────────────────────────────────────────────────┐
│                   Client Layer                   │
│  (HTML/CSS/JS/jQuery/Bootstrap)                 │
└──────────────────┬──────────────────────────────┘
                   │
                   │ AJAX Request/Response
                   │
┌──────────────────▼──────────────────────────────┐
│              Presentation Layer                  │
│          (Spring MVC Controller)                 │
└──────────────────┬──────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────┐
│               Business Layer                     │
│              (Service Layer)                     │
└──────────────────┬──────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────┐
│              Persistence Layer                   │
│                (DAO/Mapper)                      │
└──────────────────┬──────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────┐
│               Database Layer                     │
│                  (MySQL)                         │
└──────────────────────────────────────────────────┘

        External APIs
        ┌─────────────┐
        │ Kakao Login │
        │  Email API  │
        └─────────────┘
```

---

## 📱 화면 구성

### 주요 화면
- 🏠 메인 대시보드
- 👤 로그인/회원가입
- 💊 약품 재고 관리
- 📝 처방전 작성/조회
- ⚙️ 관리자 페이지
- 📧 알림 설정

---

## 🖥️ 개발 환경

### IDE & Tools
- **IDE**: Spring Tool Suite (STS)
- **Database Tool**: MySQL Workbench
- **API Testing**: Postman
- **Version Control**: Git & GitHub

### Server
- **WAS**: Apache Tomcat 9.0
- **배포**: Local Server

---

## 👨‍💻 개발자 역할

### 📌 담당 업무

| 분야 | 상세 내용 |
|------|----------|
| **기획** | 프로젝트 전체 기획 및 설계 |
| **개발** | Full-Stack 개발 (Frontend + Backend) |
| **DB** | 데이터베이스 설계 및 구축 |
| **문서화** | PPT 제작, API 문서화 |
| **영상** | 시연 영상 촬영 및 편집 |

---

## 📝 프로젝트 특징

### ✅ 강점
- 약사의 업무 효율성 향상을 위한 실용적인 시스템
- 자동화된 재고 관리로 인적 오류 감소
- 이메일 알림을 통한 유통기한 관리 강화
- 관리자 승인 시스템으로 서비스 신뢰도 확보

### 🔄 향후 개선 사항
- 모바일 앱 개발
- 클라우드 배포
- 알림 설정 커스터마이징
- 통계 및 리포트 기능 추가

---

<div align="center">

**Made with ❤️ by [Your Name]**

</div>
