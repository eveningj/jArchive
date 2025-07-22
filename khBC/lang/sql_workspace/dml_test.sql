/*
    ȸ�� ������ �����ϴ� ���̺�
    ���̵� / ��й�ȣ / �̸� / ���� / ��ȭ��ȣ / ���� / ȸ��������
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
INSERT : TABLE �� DATA�� �����ϴ� ����(���� �� TABLE �� ROW �� �þ)

    ���� 1. :
    INSERT INTO ���̺��̸� (COLUMN1, COLUMN2, COLUMN3, ...) VALUES (VALUE1, VALUE2, ...)
    -> ���� ����.
*/
    INSERT INTO MEMBER_TBL 
    (MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_AGE,
    MEMBER_PHONE, MEMBER_GENDER, ENROLL_DATE)
    VALUES ('user01','1234','����1',20,'010-1111-1111','��',sysdate);
    
    INSERT INTO
        MEMBER_TBL(MEMBER_PW, MEMBER_ID, MEMBER_NAME, MEMBER_AGE, MEMBER_PHONE,
        MEMBER_GENDER, ENROLL_DATE)
    VALUES ('user02', '1222', '����2', 30, '010-2222-2222', '��', sysdate);
    --> ����
    
    INSERT INTO
        MEMBER_TBL(MEMBER_ID, MEMBER_PW,  MEMBER_AGE, MEMBER_PHONE,
        MEMBER_GENDER, ENROLL_DATE)
    VALUES ('user03', '3333', 33, '010-3333-3333', '��', sysdate);
    
    /*
    INSERT ���� 2.
    
    INSERT INTO ���̺�� VALUES (VALUE1, VALUE2, VALUE3, ...);
    
    (COLUMN �� ������� VALUE ����
    
    */
    
    INSERT INTO MEMBER_TBL
        VALUES ('user04','4444','����4',44,'010-4444-4444','��',sysdate+1);
        
    INSERT INTO MEMBER_TBL
        VALUES('user05','5555',55,null,'010-5555-5555','��',sysdate);
        SELECT * FROM MEMBER_TBL;

    
    UPDATE MEMBER_TBL
    SET MEMBER_NAME = NULL, MEMBER_AGE = 55
    WHERE MEMBER_ID = 'user05';

    SELECT * FROM MEMBER_TBL;

    /* UPDATE
        ���̺� ��ϵ� �ʵ��� ���� �����ϴ� ����
    
            -> ���� �� ROW ���� ��ȭ ����.
    */
    
    /*
        UPDATE ���� 1.
            UPDATE ���̺�� SET COLUMN1 = VALUE1, COLUMN2 = VALUE2
            WHERE ���ǽ� (� ��, ROW�� ����)
    */
    
    UPDATE MEMBER_TBL
    SET MEMBER_NAME = '����3'
    WHERE MEMBER_ID = 'user03';
    
    UPDATE MEMBER_TBL SET MEMBER_NAME = '����5', MEMBER_AGE = 50,
    MEMBER_GENDER = '��'
    WHERE MEMBER_ID = 'user05';
    SELECT * FROM MEMBER_TBL;
    
    UPDATE MEMBER_TBL SET MEMBER_AGE = 30
    WHERE MEMBER_GENDER = '��';
    
    commit;
    rollback;
    update member_tbl set member_id = 'user02', member_pw = '1222'
    where member_name= '����2';
    
    /*
    DELETE :TABLE �� ���� �����ϴ� ����
     -> ����� TABLE �� ���� ���� ( ROW --;)
     
        DELETE ���� 1.
        DELETE FROM ���̺�� WHERE ����
        
    */
    
    DELETE FROM MEMBER_TBL WHERE MEMBER_ID = 'user0';
    SELECT * FROM MEMBER_TBL;
    
    /*
    Ư�� ĭ�� �����͸� ����ٸ�, UPDATE ��.
    */
    
    DELETE FROM MEMBER_TBL WHERE MEMBER_ID='user01';
    
    SELECT SYSDATE FROM DUAL;
    DELETE FROM MEMBER_TBL WHERE TO_CHAR(ENROLL_DATE, 'YYYY-MM-DD') = 
    TO_CHAR(SYSDATE, 'YYYY-MM-DD');
    
    SELECT MEMBER_ID, ENROLL_DATE, SYSDATE, SYSDATE - ENROLL_DATE FROM MEMBER_TBL;
    
    COMMIT;
    
