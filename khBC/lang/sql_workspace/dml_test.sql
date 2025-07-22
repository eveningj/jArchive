/*
    회원 정보를 저장하는 테이블
    아이디 / 비밀번호 / 이름 / 나이 / 전화번호 / 성별 / 회원가입일
*/

create table member_tbl (
    member_id   varchar2(20),
    member_pw   varchar2(30),
    member_name varchar2(30),
    member_age  number,
    member_phone    char(13),
    member_gender   char(3),
    enroll_date date
);

SELECT * FROM MEMBER_TBL;
/*
INSERT : TABLE 에 DATA를 삽입하는 구문(동작 시 TABLE 의 ROW 가 늘어남)

    문법 1. :
    INSERT INTO 테이블이름 (COLUMN1, COLUMN2, COLUMN3, ...) VALUES (VALUE1, VALUE2, ...)
    -> 서순 있음.
*/
    INSERT INTO MEMBER_TBL 
    (MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_AGE,
    MEMBER_PHONE, MEMBER_GENDER, ENROLL_DATE)
    VALUES ('user01','1234','유저1',20,'010-1111-1111','남',sysdate);
    
    INSERT INTO
        MEMBER_TBL(MEMBER_PW, MEMBER_ID, MEMBER_NAME, MEMBER_AGE, MEMBER_PHONE,
        MEMBER_GENDER, ENROLL_DATE)
    VALUES ('user02', '1222', '유저2', 30, '010-2222-2222', '여', sysdate);
    --> 순서
    
    INSERT INTO
        MEMBER_TBL(MEMBER_ID, MEMBER_PW,  MEMBER_AGE, MEMBER_PHONE,
        MEMBER_GENDER, ENROLL_DATE)
    VALUES ('user03', '3333', 33, '010-3333-3333', '여', sysdate);
    
    /*
    INSERT 문법 2.
    
    INSERT INTO 테이블명 VALUES (VALUE1, VALUE2, VALUE3, ...);
    
    (COLUMN 의 순서대로 VALUE 삽입
    
    */
    
    INSERT INTO MEMBER_TBL
        VALUES ('user04','4444','유저4',44,'010-4444-4444','남',sysdate+1);
        
    INSERT INTO MEMBER_TBL
        VALUES('user05','5555',55,null,'010-5555-5555','여',sysdate);
        SELECT * FROM MEMBER_TBL;

    
    UPDATE MEMBER_TBL
    SET MEMBER_NAME = NULL, MEMBER_AGE = 55
    WHERE MEMBER_ID = 'user05';

    SELECT * FROM MEMBER_TBL;

    /* UPDATE
        테이블에 기록된 필드의 값을 수정하는 구문
    
            -> 수행 시 ROW 수는 변화 없음.
    */
    
    /*
        UPDATE 문법 1.
            UPDATE 테이블명 SET COLUMN1 = VALUE1, COLUMN2 = VALUE2
            WHERE 조건식 (어떤 행, ROW에 들어갈지)
    */
    
    UPDATE MEMBER_TBL
    SET MEMBER_NAME = '유저3'
    WHERE MEMBER_ID = 'user03';
    
    UPDATE MEMBER_TBL SET MEMBER_NAME = '유저5', MEMBER_AGE = 50,
    MEMBER_GENDER = '남'
    WHERE MEMBER_ID = 'user05';
    SELECT * FROM MEMBER_TBL;
    
    UPDATE MEMBER_TBL SET MEMBER_AGE = 30
    WHERE MEMBER_GENDER = '여';
    
    commit;
    rollback;
    update member_tbl set member_id = 'user02', member_pw = '1222'
    where member_name= '유저2';
    
    /*
    DELETE :TABLE 의 행을 삭제하는 구문
     -> 수행시 TABLE 의 행이 감소 ( ROW --;)
     
        DELETE 문법 1.
        DELETE FROM 테이블명 WHERE 조건
        
    */
    
    DELETE FROM MEMBER_TBL WHERE MEMBER_ID = 'user0';
    SELECT * FROM MEMBER_TBL;
    
    /*
    특정 칸의 데이터를 지운다면, UPDATE 임.
    */
    
    DELETE FROM MEMBER_TBL WHERE MEMBER_ID='user01';
    
    SELECT SYSDATE FROM DUAL;
    DELETE FROM MEMBER_TBL WHERE TO_CHAR(ENROLL_DATE, 'YYYY-MM-DD') = 
    TO_CHAR(SYSDATE, 'YYYY-MM-DD');
    
    SELECT MEMBER_ID, ENROLL_DATE, SYSDATE, SYSDATE - ENROLL_DATE FROM MEMBER_TBL;
    
    COMMIT;
    
