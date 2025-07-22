-- DATA DEFINITION LANGUAGE
    --> C U D -> CREATE, UPDATE, DELETE 'OBJECT'
    
    -- OBJECT
    -- USER, TABLE, VIEW, SEQUENCE, INDEX, PACKAGE, 
        --PROCEDUAL, FUNCTION, TRIGGER, SYNONYM

    -- ACCOUNT
        --ADMIN
        --USER


--  DATA CONTROL LANGUAGE
    -- CREATE
        --> 다양한 DB 객체 생성 구문.
        
        --USER (ADMIN ROLE)
        create user DDL_TEST identified by 1234;
        grant connect, resource to DDL_TEST;
        
        --> GRANT, REVOKE 를 통한 ROLE 부여, 해제
        --> CONNECT, RESOURCE 를 통한 DB 연결, 생성 권한 부여
        
        
        
    -- 1. CREATE TABLE
          /*  CREATE TABLE TABLE_TITLE (COLUMN_TITLE TYPE(SIZE) ...)
          
          CREATE TABLE TABLE_TITLE (
          COLUMN_TITLE1  TYPE(SIZE)
          COLUMN_TITLE2  TYPE(SIZE)
          COLUMN_TITLE3  TYPE(SIZE)
        ,,,
        -> Camel, PASCAL 표기 모두 사용 불가 -> 대/소문자 구분 X
        -> 단어와 단어 사이를 UNDERSCORE (_) 로 연결 : SNAKE 표기법
        PhOnE_NUmBeR
        
        */
        
        /*
        회원 정보를 저장하는 테이블
            -> 아이디/ 비밀번호 / 이름 / 나이 / 전화번호 / 성별 / 회원가입일
            TABLE TITLE : MEMBER_TBL, MEMBER, USER_TBL ...
             -> USER_TBL
             항목     COLUMN 이름   자료형     -> TABLE 이름을 앞에 붙이는 것이 CONVENTION.
             아이디 -> USER_ID   ->  문자열 VARCHAR2(20) 
             비밀번호-> USER_PW  ->  문자열 VARCHAR2(30) / CHAR(60)
             이름    -> USER_NAME-> 문자열  VARCHAR2(30)
             나이    -> USER_AGE -> 숫자    NUMBER
             전화번호->USER_PHONE-> 문자열 CHAR(13)
             성별    ->USER_GENDER-> 문자열 CHAR(6)
             회원가입일->USER_DATE -> 날짜 DATE / 문자열
             
            */
            
            CREATE TABLE USER_TBL(
            USER_ID     VARCHAR2(20),
            USER_PW     VARCHAR2(30),
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13),
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            
            SELECT * FROM USER_TBL;
            
            --COMMENT
            COMMENT ON COLUMN USER_TBL.USER_ID IS '회원 아이디';
            COMMENT ON COLUMN USER_TBL.USER_PW IS '회원 비밀번호';
            
            INSERT INTO USER_TBL
            VALUES ('kh01234','010101','홍길동',24,'010-1234-5678','남',sysdate);
            
            INSERT INTO USER_TBL
            VALUES ('kh43210','101010','동길홍',24,'010-8765-4321','여',sysdate);
            
            INSERT INTO USER_TBL
            VALUES ('userunknown','xxxxxxxx', null,18,null,null,sysdate);
            
            UPDATE USER_TBL
            SET USER_age = null
            WHERE USER_ID = 'undefineduser01';
            
            SELECT *
            FROM USER_TBL
            WHERE USER_ID = 'kh01234'
            AND USER_PW = '010101';
            
            DELETE
            FROM USER_TBL
            WHERE USER_NAME IS NULL;
            SELECT * FROM USER_TBL;
            
            --제약조건
                --> 데이터 무결성을 지키기 위해 제한된 조건
                --> 각 컬럼에 대해 제약조건 설정 가능
                    -- NOT NULL, UNIQUE, PRIMARY KEY(not null && unique + 상징적인 의미, column 고유식별자. -> 검색 최적화.),
                    -- FOREIGN KEY (참조되는 tbl 의 column 이 존재하면 허용), 
                    -- CHECK (데이터 값의 범위나 조건을 지정하여 설정한 값만 허용)
                    
            /*
            NOT NULL : 해당 COLUMN 에 NULL 을 허용하지 않음 / 반드시 데이터가 기록되어야 하는 경우 사용
                -> INSERT/UPDATE 시 NULL 을 사용할 수 없음
            */
            
             CREATE TABLE USER_TBL_NN(
            USER_ID     VARCHAR2(20) NOT NULL , -- NOT NULL 제약 조건은 COLUMN LEVEL 에서만 설정 가능
            USER_PW     VARCHAR2(30) NOT NULL,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) NOT NULL,
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            INSERT INTO USER_TBL_NN
            VALUES ('kh01234','010101','홍길동',24,'010-1234-5678','남',sysdate);
            
            INSERT INTO USER_TBL_NN
            VALUES ('userunknown','xxxxxxxx', null,18,null,null,sysdate);
            
            UPDATE USER_TBL_NN
            SET USER_PW = NULL WHERE USER_ID = 'kh01234';
            
            /*
            unique(unique key) : Column 입력값에 대해 중복을 제한하는 제약조건
                -> NULL 은 데이터가 아니므로 중복되어도 상관 없음.
            */
            
             CREATE TABLE USER_TBL_UK1(
            USER_ID     VARCHAR2(20) UNIQUE ,--COLUMN LEVEL 에서 제약조건 설정
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) UNIQUE,--COLUMN LEVEL 에서 제약조건 설정
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_UK1
            VALUES ('kh01234','010101','홍길동',24,'010-1234-5678','남',sysdate);
            UPDATE USER_TBL_UK1
            SET USER_ID = K WHERE USER_ID = 'kh01234';
            
            SELECT * FROM USER_TBL_UK1;
            ----------------------------------------------
              CREATE TABLE USER_TBL_UK2(
            USER_ID     VARCHAR2(20) UNIQUE , 
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) UNIQUE,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            UNIQUE(USER_ID),
            UNIQUE(USER_PHONE)--TABLE LEVEL 에서 제약조건 설정
            );
            CREATE TABLE USER_TBL_UK3(
            USER_ID     VARCHAR2(20) UNIQUE , 
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) UNIQUE,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            UNIQUE(USER_ID, USER_PHONE) --TABLE LEVEL 에서 제약조건 설정
            ); -- 복합키, 동시에 중복되었을 때 INSERT 불가능.
            ------------------------------------------------
            INSERT INTO USER_TBL_UK3
            VALUES ('kh01234','010101','홍길동',24,'010-1234-5678','남',sysdate);
            
            
            
            /*
            PRIMARY KEY : 한 테이블에서 한 행의 정보를 구분하기 위한 식별자 역할
                NOT NULL + UNIQUE
                 -> 한 테이블 당 1개만 설정 가능함.
            */
            
             CREATE TABLE USER_TBL_PK1(
            USER_ID     VARCHAR2(20)    PRIMARY KEY, -- COLUMN LEVEL 에서 설정
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) ,
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_PK1 VALUES('user01','1111','유저1',20,'010-1111-1111','여자',sysdate);
            INSERT INTO USER_TBL_PK1 VALUES('user02','2222','유저2',22,'010-2222-2222','여자',sysdate);
            INSERT INTO USER_TBL_PK1 VALUES('user02','3333','유저3',24,'010-3333-3333','여자',sysdate);
            
            --
            
            CREATE TABLE USER_TBL_PK2(
            USER_ID     VARCHAR2(20) ,
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) ,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            PRIMARY KEY(USER_ID)    --TABLE LEVEL 에서 설정
            );
            
            INSERT INTO USER_TBL_PK2 VALUES('user01','1111','유저1',20,'010-1111-1111','여자',sysdate);
            INSERT INTO USER_TBL_PK2 VALUES('user02','2222','유저2',22,'010-2222-2222','여자',sysdate);
            INSERT INTO USER_TBL_PK2 VALUES('user02','3333','유저3',24,'010-3333-3333','여자',sysdate);
            
            --
            CREATE TABLE USER_TBL_PK3(
            USER_ID     VARCHAR2(20) ,
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) ,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            PRIMARY KEY(USER_ID, USER_PW)    --TABLE LEVEL 에서 설정 (복합 키 설정)
            );
            -- FOREIGN KEY --> 참조 무결성 유지, 테이블간 관계 형성 (참조되는 값 일치, NULL 가능)
                -- 참조되는 COLUMN 의 값은 UNIQUE 나 PRIMARY KEY 를 가져야함.
                -- 참조되는 값과 참조하는 값의 'TYPE은' 일치해야함.
                
            -- FOREIGN KEY 를 위한 가정
                --1) 쇼핑몰 데이터베이스 구현
                --2) 이 쇼핑몰은 반드시 회원가입을 하고 로그인을 한 상태로만 물건 구입 가능
                --3) 구매자 정보는 회원 테이블에서 가져올 수 있어야함.
                
                --> 
            CREATE TABLE shopt_member(
            USER_NO     NUMBER  PRIMARY KEY,
            USER_ID     VARCHAR2(20) NOT NULL UNIQUE, -- , (COMMA 찍으면 안됨./ 여러 제약조건은 띄어쓰기로.)
            USER_PW     VARCHAR2(30) NOT NULL,
            USER_NAME   VARCHAR2(30)
            );
            
            INSERT INTO SHOPT_MEMBER VALUES(1,'user01','1111','유저1');
            INSERT INTO SHOPT_MEMBER VALUES(2,'user02','2222','유저2');
            INSERT INTO SHOPT_MEMBER VALUES(3,'user03','3333','유저3');
            
            SELECT * FROM SHOPT_MEMBER;
            
            CREATE TABLE SHOP_BUY_1(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            BUY_ID     VARCHAR2(30) ,
            BUY_DATE   DATE
            )
            ;
            
            INSERT INTO SHOP_BUY_1 VALUES (1,'아이폰','user01', sysdate);
            INSERT INTO SHOP_BUY_1 VALUES (2,'로메인','user00', sysdate);
            select * from shop_buy_1;
            
            CREATE TABLE SHOP_BUY_2(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            BUY_ID     VARCHAR2(30) REFERENCES SHOPT_MEMBER (USER_ID) , --COLUMN LEVLE 설정
            BUY_DATE   DATE
            )
            ;
            SELECT USER_ID FROM SHOPT_MEMBER ;
            INSERT INTO SHOP_BUY_2 VALUES (1,'아이폰','user01', sysdate);
            INSERT INTO SHOP_BUY_2 VALUES (2,'로메인','user00', sysdate);
            select * from shop_buy_2;
            ---------
            CREATE TABLE SHOP_BUY_3(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            BUY_ID     VARCHAR2(30) ,
            BUY_DATE   DATE,
            FOREIGN KEY(BUY_ID) REFERENCES SHOPT_MEMBER (USER_ID)  --TABLE LEVEL 설정
            );
            
            INSERT INTO SHOP_BUY_3 VALUES (1,'아이폰','user01', sysdate);
            INSERT INTO SHOP_BUY_3 VALUES (2,'로메인','user00', sysdate);
            select * from shop_buy_3;
            
            ---------
            CREATE TABLE SHOP_BUY_4(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER(USER_NO),
            BUY_DATE   DATE
            );
            
            INSERT INTO SHOP_BUY_3 VALUES (1,'아이폰','user01', sysdate);
            INSERT INTO SHOP_BUY_3 VALUES (2,'로메인','user00', sysdate);
            select * from shop_buy_3;
            
              CREATE TABLE SHOP_BUY_5(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER, -- 자동으로 PRIMARY KEY 를 참조함. (COLUMN 생략)
            BUY_DATE   DATE
            );
            
            
            SELECT
                BUY_NO, BUY_PRODUCT, USER_NAME, BUY_DATE
            FROM SHOP_BUY2
            JOIN SHOPT_MEMBER ON (BUY_ID = USER_ID);
            
            -------------

            INSERT INTO SHOP_BUY_5 VALUES (1,'모니터',2, sysdate);
            SELECT * FROM SHOP_BUY_5;
            SELECT * FROM SHOPT_MEMBER;
            DELETE FROM SHOP_BUY_5 WHERE USER_NO=2;
            DELETE FROM SHOPT_MEMBER WHERE USER_NO=2; 
            --참조하는 값이 존재할 경우 참조되는 값은 바로 지워지지 않음.
            --> 참조하는 값 먼저 지워야함.
                --> 참조 무결성.
            
            
            --  FOREIGN KEY --> DELETE OPTION
                --1. ON DELETE RESTRICTED -> 참조하는 값 삭제해야함.
                --2. ON DELETE SET NULL -> 자식 COLUMN NULL
                --3. ON DELETE CASCADE -> 자식 COLUMN 삭제
            
            --2.    
            CREATE TABLE SHOP_BUY_6(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER ON DELETE SET NULL, -- 자동으로 PRIMARY KEY 를 참조함. (COLUMN 생략)
            BUY_DATE   DATE
            );
            
            INSERT INTO SHOP_BUY_6 VALUES (1,'모니터',1, sysdate);
            INSERT INTO SHOP_BUY_6 VALUES (2,'과자',2, sysdate);
            SELECT * FROM SHOP_BUY_6;
            SELECT * FROM SHOPT_MEMBER;
            
            DELETE FROM SHOPT_MEMBER WHERE USER_NO=2;
            
            --3.
            CREATE TABLE SHOP_BUY_7(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER ON DELETE CASCADE,
            BUY_DATE   DATE
            );
            INSERT INTO SHOP_BUY_7 VALUES (1,'모니터',1, sysdate);
            INSERT INTO SHOP_BUY_7 VALUES (2,'과자',2, sysdate);
            SELECT * FROM SHOP_BUY_7;
            SELECT * FROM SHOPT_MEMBER;
            
            DELETE FROM SHOPT_MEMBER WHERE USER_NO=1; --1번이 안지워 지는 이유는 DELETE OPTION 없는 TABLE 1~5 가 참조하고 있기 때문.
            
            -- 유저2가 참조되는 데이터 삭제됨.
            
            -------------------0626
            
            CREATE TABLE USER_TBL_DEFAULT(
            USER_ID     VARCHAR2(20),
            USER_PW     VARCHAR2(30),
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER ,
            USER_PHONE  CHAR(13),
            USER_GENDER CHAR(6) CHECK (USER_GENDER IN ('남자', '여자')), -- NULL도 가능함.
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_CHECK
            VALUES ('user01','1111','유저1',2,'010-1111-5678','남자',sysdate);
            
            INSERT INTO USER_TBL_CHECK
            VALUES ('kh43210','101010','동길홍',24,'010-8765-4321','여자',sysdate);
            
            INSERT INTO USER_TBL_check
            VALUES ('userunknown','xxxxxxxx', null,18,null,null,sysdate);
            
            --  default
            /* INSERT 시 기본값 설정이 가능.
            */
             CREATE TABLE USER_TBL_DEFAULT(
            USER_ID     VARCHAR2(20),
            USER_PW     VARCHAR2(30),
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER DEFAULT 0 not null ,
            USER_PHONE  CHAR(13),
            USER_GENDER CHAR(6) ,
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_DEFAULT(
            USER_ID,USER_PW,USER_NAME,USER_AGE,USER_PHONE,USER_GENDER,USER_DATE)
            VALUES ('user01', '1111','유저1',20,'010-1111-1111','남자',sysdate);
            
            SELECT * FROM USER_TBL_DEFAULT;
            
            INSERT INTO USER_TBL_DEFAULT(
            USER_ID,USER_PW,USER_NAME,USER_AGE,USER_PHONE,USER_DATE)
            VALUES ('user02', '2222','유저2',22,'010-2222-2222',sysdate);
            
            INSERT INTO USER_TBL_DEFAULT(
            USER_ID,USER_PW,USER_NAME,USER_DATE)
            VALUES ('user03', '3333','유저3',sysdate);
            
            INSERT INTO --> 무조건 모든 COLUMN 의 값을 다 지정해줘야함. -- INSERT 에 한정해, DEFAULT 로 값 지정 가능.
            USER_TBL_DEFAULT VALUES('user04', '4444', '유저4', DEFAULT, '010-4444-4444', '여자',sysdate);
            
            SELECT * FROM USER_TBL_DEFAULT;
            
            -----
            SELECT * FROM USER_TBL_UK2;
            
            --SELECT 문을 이용해 테이블 복사
                --COLUMN 이름, 자료형(길이), 조회된 데이터까지 복사
                --CONSTRAINT 복사 x (NOT NULL 만 복사)
            CREATE TABLE USER_TBL_COPY
            AS SELECT * FROM USER_TBL_UK3;
        
            --ALTER : DDL 의 한 종류로, CREATE 로 만들어진 내용을 수정할 때 사용
            
            -- COLUMN 추가
            ALTER TABLE USER_TBL_COPY
            ADD (USER_ADDR VARCHAR2 (50)) ;
            
            SELECT * FROM USER_TBL_COPY;
            
            ALTER TABLE USER_TBL_COPY
            ADD (TEST_COL VARCHAR2 (20) DEFAULT 'test' NOT NULL) ;
            
            -- COLUMN 수정
            ALTER TABLE USER_TBL_COPY
            MODIFY USER_NAME VARCHAR2 (60);
            
            ALTER TABLE USER_TBL_COPY
            MODIFY USER_GENDER CHAR(3);
            
            UPDATE USER_TBL_COPY
            SET USER_GENDER = DECODE(USER_GENDER, '남자','남','여자','여');
            
            -- COLUMN 삭제
            ALTER TABLE USER_TBL_COPY
            DROP COLUMN USER_ADDR; -- 다른 TABLE 에서 FOREIGN KEY 로 참조하고 있는 컬럼은 삭제 불가함.
            
            
            -- COLUMN 이름 변경
            ALTER TABLE USER_TBL_COPY
            RENAME COLUMN USER_ADDR TO USER_ADDRESS;
            
            RENAME TABLE SHOPT_MEMBER TO SHOP_MEMBER;
            
            -- TABLE 에 적용되어 있는 제약조건 확인하는 문법
            SELECT
                UC.CONSTRAINT_NAME,
                UC.CONSTRAINT_TYPE,
                UC.TABLE_NAME,
                UCC.COLUMN_NAME,
                UC.SEARCH_CONDITION
            FROM USER_CONSTRAINTS UC
            JOIN USER_CONS_COLUMNS UCC ON (UC.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME)
            WHERE UC.TABLE_NAME = 'DROP_TEST2'
            ; 
            --TABLE 이름은 반드시 대문자.
            
            CREATE TABLE TEST_TBL(
                test_no     number      primary key,
                test_data1   varchar2(20)    unique,
                test_data2   varchar2(30)   not null,
                test_data3   varchar2(20)
            );
            select * from user_tables;
            
            --ADD CONSTRAINT
            ALTER TABLE TEST_TBL
            ADD CONSTRAINT TEST_TBL_UQ UNIQUE(TEST_DATA2);
            
            ALTER TABLE TEST_TBL
            MODIFY TEST_DATA1 
            CONSTRAINT TEST_DATA1_NN NOT NULL; --NOT NULL CONSTRAINT 는 MODIFY 로 추가
            
            -- 제약조건 삭제
            ALTER TABLE TEST_TBL
            DROP CONSTRAINT SYS_C007058;
            
            ALTER TABLE TEST_TBL
            MODIFY TEST_DATA1 NULL; --NOT NULL 제약 조건은 삭제할 때도 MODIFY (NULL)
            
            -- 제약조건 이름 변경
            ALTER TABLE TEST_TBL
            RENAME CONSTRAINT SYS_C007059 TO TEST_TBL_PK;
            
            ALTER TABLE TEST_TBL
            RENAME CONSTRAINT SYS_C007060 TO TEST_TBL_UQ2;
            
            -- TABLE 이름 변경
            ALTER TABLE TEST_TBL
            RENAME TO ALTER_TEST;
            
            COMMIT;
            
            select * from alter_test;
            drop table alter_test; --foreign key 연결 되어 있으면 끊고 삭제해야함.
            
            CREATE TABLE DROP_TEST1 (
                TEST_NO NUMBER  PRIMARY KEY,
                TEST_DATA   VARCHAR2(20)    NOT NULL
                );
            CREATE TABLE DROP_TEST2 (
                TEST_NO2    NUMBER,
                TEST_NO3    REFERENCES DROP_TEST1
                );
            
            DROP USER DML_TEST CASCADE; -- 종속성 제거
                
            ALTER TABLE DROP_TEST2
            DROP CONSTRAINT SYS_C007070;
                
            DROP TABLE DROP_TEST1;
            
            DROP TABLE DROP_TEST1 CASCADE CONSTRAINTS; -- 참조하고 있어도 지워.
            
        
                