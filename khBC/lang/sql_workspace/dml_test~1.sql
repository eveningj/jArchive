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
        --> �پ��� DB ��ü ���� ����.
        
        --USER (ADMIN ROLE)
        create user DDL_TEST identified by 1234;
        grant connect, resource to DDL_TEST;
        
        --> GRANT, REVOKE �� ���� ROLE �ο�, ����
        --> CONNECT, RESOURCE �� ���� DB ����, ���� ���� �ο�
        
        
        
    -- 1. CREATE TABLE
          /*  CREATE TABLE TABLE_TITLE (COLUMN_TITLE TYPE(SIZE) ...)
          
          CREATE TABLE TABLE_TITLE (
          COLUMN_TITLE1  TYPE(SIZE)
          COLUMN_TITLE2  TYPE(SIZE)
          COLUMN_TITLE3  TYPE(SIZE)
        ,,,
        -> Camel, PASCAL ǥ�� ��� ��� �Ұ� -> ��/�ҹ��� ���� X
        -> �ܾ�� �ܾ� ���̸� UNDERSCORE (_) �� ���� : SNAKE ǥ���
        PhOnE_NUmBeR
        
        */
        
        /*
        ȸ�� ������ �����ϴ� ���̺�
            -> ���̵�/ ��й�ȣ / �̸� / ���� / ��ȭ��ȣ / ���� / ȸ��������
            TABLE TITLE : MEMBER_TBL, MEMBER, USER_TBL ...
             -> USER_TBL
             �׸�     COLUMN �̸�   �ڷ���     -> TABLE �̸��� �տ� ���̴� ���� CONVENTION.
             ���̵� -> USER_ID   ->  ���ڿ� VARCHAR2(20) 
             ��й�ȣ-> USER_PW  ->  ���ڿ� VARCHAR2(30) / CHAR(60)
             �̸�    -> USER_NAME-> ���ڿ�  VARCHAR2(30)
             ����    -> USER_AGE -> ����    NUMBER
             ��ȭ��ȣ->USER_PHONE-> ���ڿ� CHAR(13)
             ����    ->USER_GENDER-> ���ڿ� CHAR(6)
             ȸ��������->USER_DATE -> ��¥ DATE / ���ڿ�
             
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
            COMMENT ON COLUMN USER_TBL.USER_ID IS 'ȸ�� ���̵�';
            COMMENT ON COLUMN USER_TBL.USER_PW IS 'ȸ�� ��й�ȣ';
            
            INSERT INTO USER_TBL
            VALUES ('kh01234','010101','ȫ�浿',24,'010-1234-5678','��',sysdate);
            
            INSERT INTO USER_TBL
            VALUES ('kh43210','101010','����ȫ',24,'010-8765-4321','��',sysdate);
            
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
            
            --��������
                --> ������ ���Ἲ�� ��Ű�� ���� ���ѵ� ����
                --> �� �÷��� ���� �������� ���� ����
                    -- NOT NULL, UNIQUE, PRIMARY KEY(not null && unique + ��¡���� �ǹ�, column �����ĺ���. -> �˻� ����ȭ.),
                    -- FOREIGN KEY (�����Ǵ� tbl �� column �� �����ϸ� ���), 
                    -- CHECK (������ ���� ������ ������ �����Ͽ� ������ ���� ���)
                    
            /*
            NOT NULL : �ش� COLUMN �� NULL �� ������� ���� / �ݵ�� �����Ͱ� ��ϵǾ�� �ϴ� ��� ���
                -> INSERT/UPDATE �� NULL �� ����� �� ����
            */
            
             CREATE TABLE USER_TBL_NN(
            USER_ID     VARCHAR2(20) NOT NULL , -- NOT NULL ���� ������ COLUMN LEVEL ������ ���� ����
            USER_PW     VARCHAR2(30) NOT NULL,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) NOT NULL,
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            INSERT INTO USER_TBL_NN
            VALUES ('kh01234','010101','ȫ�浿',24,'010-1234-5678','��',sysdate);
            
            INSERT INTO USER_TBL_NN
            VALUES ('userunknown','xxxxxxxx', null,18,null,null,sysdate);
            
            UPDATE USER_TBL_NN
            SET USER_PW = NULL WHERE USER_ID = 'kh01234';
            
            /*
            unique(unique key) : Column �Է°��� ���� �ߺ��� �����ϴ� ��������
                -> NULL �� �����Ͱ� �ƴϹǷ� �ߺ��Ǿ ��� ����.
            */
            
             CREATE TABLE USER_TBL_UK1(
            USER_ID     VARCHAR2(20) UNIQUE ,--COLUMN LEVEL ���� �������� ����
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) UNIQUE,--COLUMN LEVEL ���� �������� ����
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_UK1
            VALUES ('kh01234','010101','ȫ�浿',24,'010-1234-5678','��',sysdate);
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
            UNIQUE(USER_PHONE)--TABLE LEVEL ���� �������� ����
            );
            CREATE TABLE USER_TBL_UK3(
            USER_ID     VARCHAR2(20) UNIQUE , 
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) UNIQUE,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            UNIQUE(USER_ID, USER_PHONE) --TABLE LEVEL ���� �������� ����
            ); -- ����Ű, ���ÿ� �ߺ��Ǿ��� �� INSERT �Ұ���.
            ------------------------------------------------
            INSERT INTO USER_TBL_UK3
            VALUES ('kh01234','010101','ȫ�浿',24,'010-1234-5678','��',sysdate);
            
            
            
            /*
            PRIMARY KEY : �� ���̺��� �� ���� ������ �����ϱ� ���� �ĺ��� ����
                NOT NULL + UNIQUE
                 -> �� ���̺� �� 1���� ���� ������.
            */
            
             CREATE TABLE USER_TBL_PK1(
            USER_ID     VARCHAR2(20)    PRIMARY KEY, -- COLUMN LEVEL ���� ����
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) ,
            USER_GENDER CHAR(6),
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_PK1 VALUES('user01','1111','����1',20,'010-1111-1111','����',sysdate);
            INSERT INTO USER_TBL_PK1 VALUES('user02','2222','����2',22,'010-2222-2222','����',sysdate);
            INSERT INTO USER_TBL_PK1 VALUES('user02','3333','����3',24,'010-3333-3333','����',sysdate);
            
            --
            
            CREATE TABLE USER_TBL_PK2(
            USER_ID     VARCHAR2(20) ,
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) ,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            PRIMARY KEY(USER_ID)    --TABLE LEVEL ���� ����
            );
            
            INSERT INTO USER_TBL_PK2 VALUES('user01','1111','����1',20,'010-1111-1111','����',sysdate);
            INSERT INTO USER_TBL_PK2 VALUES('user02','2222','����2',22,'010-2222-2222','����',sysdate);
            INSERT INTO USER_TBL_PK2 VALUES('user02','3333','����3',24,'010-3333-3333','����',sysdate);
            
            --
            CREATE TABLE USER_TBL_PK3(
            USER_ID     VARCHAR2(20) ,
            USER_PW     VARCHAR2(30) ,
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER,
            USER_PHONE  CHAR(13) ,
            USER_GENDER CHAR(6),
            USER_DATE   DATE,
            PRIMARY KEY(USER_ID, USER_PW)    --TABLE LEVEL ���� ���� (���� Ű ����)
            );
            -- FOREIGN KEY --> ���� ���Ἲ ����, ���̺� ���� ���� (�����Ǵ� �� ��ġ, NULL ����)
                -- �����Ǵ� COLUMN �� ���� UNIQUE �� PRIMARY KEY �� ��������.
                -- �����Ǵ� ���� �����ϴ� ���� 'TYPE��' ��ġ�ؾ���.
                
            -- FOREIGN KEY �� ���� ����
                --1) ���θ� �����ͺ��̽� ����
                --2) �� ���θ��� �ݵ�� ȸ�������� �ϰ� �α����� �� ���·θ� ���� ���� ����
                --3) ������ ������ ȸ�� ���̺��� ������ �� �־����.
                
                --> 
            CREATE TABLE shopt_member(
            USER_NO     NUMBER  PRIMARY KEY,
            USER_ID     VARCHAR2(20) NOT NULL UNIQUE, -- , (COMMA ������ �ȵ�./ ���� ���������� �����.)
            USER_PW     VARCHAR2(30) NOT NULL,
            USER_NAME   VARCHAR2(30)
            );
            
            INSERT INTO SHOPT_MEMBER VALUES(1,'user01','1111','����1');
            INSERT INTO SHOPT_MEMBER VALUES(2,'user02','2222','����2');
            INSERT INTO SHOPT_MEMBER VALUES(3,'user03','3333','����3');
            
            SELECT * FROM SHOPT_MEMBER;
            
            CREATE TABLE SHOP_BUY_1(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            BUY_ID     VARCHAR2(30) ,
            BUY_DATE   DATE
            )
            ;
            
            INSERT INTO SHOP_BUY_1 VALUES (1,'������','user01', sysdate);
            INSERT INTO SHOP_BUY_1 VALUES (2,'�θ���','user00', sysdate);
            select * from shop_buy_1;
            
            CREATE TABLE SHOP_BUY_2(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            BUY_ID     VARCHAR2(30) REFERENCES SHOPT_MEMBER (USER_ID) , --COLUMN LEVLE ����
            BUY_DATE   DATE
            )
            ;
            SELECT USER_ID FROM SHOPT_MEMBER ;
            INSERT INTO SHOP_BUY_2 VALUES (1,'������','user01', sysdate);
            INSERT INTO SHOP_BUY_2 VALUES (2,'�θ���','user00', sysdate);
            select * from shop_buy_2;
            ---------
            CREATE TABLE SHOP_BUY_3(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            BUY_ID     VARCHAR2(30) ,
            BUY_DATE   DATE,
            FOREIGN KEY(BUY_ID) REFERENCES SHOPT_MEMBER (USER_ID)  --TABLE LEVEL ����
            );
            
            INSERT INTO SHOP_BUY_3 VALUES (1,'������','user01', sysdate);
            INSERT INTO SHOP_BUY_3 VALUES (2,'�θ���','user00', sysdate);
            select * from shop_buy_3;
            
            ---------
            CREATE TABLE SHOP_BUY_4(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER(USER_NO),
            BUY_DATE   DATE
            );
            
            INSERT INTO SHOP_BUY_3 VALUES (1,'������','user01', sysdate);
            INSERT INTO SHOP_BUY_3 VALUES (2,'�θ���','user00', sysdate);
            select * from shop_buy_3;
            
              CREATE TABLE SHOP_BUY_5(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER, -- �ڵ����� PRIMARY KEY �� ������. (COLUMN ����)
            BUY_DATE   DATE
            );
            
            
            SELECT
                BUY_NO, BUY_PRODUCT, USER_NAME, BUY_DATE
            FROM SHOP_BUY2
            JOIN SHOPT_MEMBER ON (BUY_ID = USER_ID);
            
            -------------

            INSERT INTO SHOP_BUY_5 VALUES (1,'�����',2, sysdate);
            SELECT * FROM SHOP_BUY_5;
            SELECT * FROM SHOPT_MEMBER;
            DELETE FROM SHOP_BUY_5 WHERE USER_NO=2;
            DELETE FROM SHOPT_MEMBER WHERE USER_NO=2; 
            --�����ϴ� ���� ������ ��� �����Ǵ� ���� �ٷ� �������� ����.
            --> �����ϴ� �� ���� ��������.
                --> ���� ���Ἲ.
            
            
            --  FOREIGN KEY --> DELETE OPTION
                --1. ON DELETE RESTRICTED -> �����ϴ� �� �����ؾ���.
                --2. ON DELETE SET NULL -> �ڽ� COLUMN NULL
                --3. ON DELETE CASCADE -> �ڽ� COLUMN ����
            
            --2.    
            CREATE TABLE SHOP_BUY_6(
            BUY_NO     NUMBER  PRIMARY KEY,
            BUY_PRODUCT     VARCHAR2(30) NOT NULL,
            USER_NO     NUMBER REFERENCES SHOPT_MEMBER ON DELETE SET NULL, -- �ڵ����� PRIMARY KEY �� ������. (COLUMN ����)
            BUY_DATE   DATE
            );
            
            INSERT INTO SHOP_BUY_6 VALUES (1,'�����',1, sysdate);
            INSERT INTO SHOP_BUY_6 VALUES (2,'����',2, sysdate);
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
            INSERT INTO SHOP_BUY_7 VALUES (1,'�����',1, sysdate);
            INSERT INTO SHOP_BUY_7 VALUES (2,'����',2, sysdate);
            SELECT * FROM SHOP_BUY_7;
            SELECT * FROM SHOPT_MEMBER;
            
            DELETE FROM SHOPT_MEMBER WHERE USER_NO=1; --1���� ������ ���� ������ DELETE OPTION ���� TABLE 1~5 �� �����ϰ� �ֱ� ����.
            
            -- ����2�� �����Ǵ� ������ ������.
            
            -------------------0626
            
            CREATE TABLE USER_TBL_DEFAULT(
            USER_ID     VARCHAR2(20),
            USER_PW     VARCHAR2(30),
            USER_NAME   VARCHAR2(30),
            USER_AGE    NUMBER ,
            USER_PHONE  CHAR(13),
            USER_GENDER CHAR(6) CHECK (USER_GENDER IN ('����', '����')), -- NULL�� ������.
            USER_DATE   DATE
            );
            
            INSERT INTO USER_TBL_CHECK
            VALUES ('user01','1111','����1',2,'010-1111-5678','����',sysdate);
            
            INSERT INTO USER_TBL_CHECK
            VALUES ('kh43210','101010','����ȫ',24,'010-8765-4321','����',sysdate);
            
            INSERT INTO USER_TBL_check
            VALUES ('userunknown','xxxxxxxx', null,18,null,null,sysdate);
            
            --  default
            /* INSERT �� �⺻�� ������ ����.
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
            VALUES ('user01', '1111','����1',20,'010-1111-1111','����',sysdate);
            
            SELECT * FROM USER_TBL_DEFAULT;
            
            INSERT INTO USER_TBL_DEFAULT(
            USER_ID,USER_PW,USER_NAME,USER_AGE,USER_PHONE,USER_DATE)
            VALUES ('user02', '2222','����2',22,'010-2222-2222',sysdate);
            
            INSERT INTO USER_TBL_DEFAULT(
            USER_ID,USER_PW,USER_NAME,USER_DATE)
            VALUES ('user03', '3333','����3',sysdate);
            
            INSERT INTO --> ������ ��� COLUMN �� ���� �� �����������. -- INSERT �� ������, DEFAULT �� �� ���� ����.
            USER_TBL_DEFAULT VALUES('user04', '4444', '����4', DEFAULT, '010-4444-4444', '����',sysdate);
            
            SELECT * FROM USER_TBL_DEFAULT;
            
            -----
            SELECT * FROM USER_TBL_UK2;
            
            --SELECT ���� �̿��� ���̺� ����
                --COLUMN �̸�, �ڷ���(����), ��ȸ�� �����ͱ��� ����
                --CONSTRAINT ���� x (NOT NULL �� ����)
            CREATE TABLE USER_TBL_COPY
            AS SELECT * FROM USER_TBL_UK3;
        
            --ALTER : DDL �� �� ������, CREATE �� ������� ������ ������ �� ���
            
            -- COLUMN �߰�
            ALTER TABLE USER_TBL_COPY
            ADD (USER_ADDR VARCHAR2 (50)) ;
            
            SELECT * FROM USER_TBL_COPY;
            
            ALTER TABLE USER_TBL_COPY
            ADD (TEST_COL VARCHAR2 (20) DEFAULT 'test' NOT NULL) ;
            
            -- COLUMN ����
            ALTER TABLE USER_TBL_COPY
            MODIFY USER_NAME VARCHAR2 (60);
            
            ALTER TABLE USER_TBL_COPY
            MODIFY USER_GENDER CHAR(3);
            
            UPDATE USER_TBL_COPY
            SET USER_GENDER = DECODE(USER_GENDER, '����','��','����','��');
            
            -- COLUMN ����
            ALTER TABLE USER_TBL_COPY
            DROP COLUMN USER_ADDR; -- �ٸ� TABLE ���� FOREIGN KEY �� �����ϰ� �ִ� �÷��� ���� �Ұ���.
            
            
            -- COLUMN �̸� ����
            ALTER TABLE USER_TBL_COPY
            RENAME COLUMN USER_ADDR TO USER_ADDRESS;
            
            RENAME TABLE SHOPT_MEMBER TO SHOP_MEMBER;
            
            -- TABLE �� ����Ǿ� �ִ� �������� Ȯ���ϴ� ����
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
            --TABLE �̸��� �ݵ�� �빮��.
            
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
            CONSTRAINT TEST_DATA1_NN NOT NULL; --NOT NULL CONSTRAINT �� MODIFY �� �߰�
            
            -- �������� ����
            ALTER TABLE TEST_TBL
            DROP CONSTRAINT SYS_C007058;
            
            ALTER TABLE TEST_TBL
            MODIFY TEST_DATA1 NULL; --NOT NULL ���� ������ ������ ���� MODIFY (NULL)
            
            -- �������� �̸� ����
            ALTER TABLE TEST_TBL
            RENAME CONSTRAINT SYS_C007059 TO TEST_TBL_PK;
            
            ALTER TABLE TEST_TBL
            RENAME CONSTRAINT SYS_C007060 TO TEST_TBL_UQ2;
            
            -- TABLE �̸� ����
            ALTER TABLE TEST_TBL
            RENAME TO ALTER_TEST;
            
            COMMIT;
            
            select * from alter_test;
            drop table alter_test; --foreign key ���� �Ǿ� ������ ���� �����ؾ���.
            
            CREATE TABLE DROP_TEST1 (
                TEST_NO NUMBER  PRIMARY KEY,
                TEST_DATA   VARCHAR2(20)    NOT NULL
                );
            CREATE TABLE DROP_TEST2 (
                TEST_NO2    NUMBER,
                TEST_NO3    REFERENCES DROP_TEST1
                );
            
            DROP USER DML_TEST CASCADE; -- ���Ӽ� ����
                
            ALTER TABLE DROP_TEST2
            DROP CONSTRAINT SYS_C007070;
                
            DROP TABLE DROP_TEST1;
            
            DROP TABLE DROP_TEST1 CASCADE CONSTRAINTS; -- �����ϰ� �־ ����.
            
        
                