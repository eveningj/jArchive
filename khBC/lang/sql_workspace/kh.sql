/*select searchColumn; 
from tableName;*/
--Line Comment

--employee table �� ��� Column ��ȸ
select * -- * -> ALL COLUMN
from employee; 
select EMP_NAME, EMAIL, PHONE -- -> COLUMN SEARCH
from employee; --> TABLE

select *
from employee
where emp_name = '������'; --> Context ����  (row)

select * -- ���� ���� 3)
from employee -- ���� ���� 1)
where dept_code = 'D9'; --> ��/�ҹ��� ����, ���ǽ� --���� ���� 2)


--exercise
--1.
select JOB_NAME
from JOB;

--2.
select *
from DEPARTMENT;

--3.
select EMP_NAME, EMAIL, PHONE, HIRE_DATE
from EMPLOYEE;

--4.
select HIRE_DATE, EMP_NAME, SALARY
from EMPLOYEE;

--5.
select EMP_NAME, SAL_LEVEL
from EMPLOYEE
WHERE SALARY >= 2500000;

select emp_name, salary, salary*12 from employee;

--select ���, Column �� ��Ī ����
select emp_name as "�̸�", salary as "����(��)", salary*12  sal --> ��Ī ������,Ư������ ������ ����ǥ ���� ����.
from employee;

select emp_name, salary, salary + salary*bonus as "���� ����" -- ���ʽ� ���� -> null data �� ���� �Ұ���.
from employee;

select emp_name, salary || '��', '��' 
from employee;
--> row �� ���� �� ����. (' ' -> char)
--> || �� ���� ������. Literal �� Column �� �� ó�� ����ϰ� �� �� ����.

--distinct : ��ȸ�� ������� �ߺ��� row �� ����. (���ÿ� �� ��ĥ ��. �̸�, jobcode.)
select distinct emp_name, job_code from employee; 

-- ��������
-- �μ��ڵ尡 D6�̰� �޿��� 2,000,000 ���� ���� �޴� ������ �̸�, �μ��ڵ�, �޿� ��ȸ

select EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' and SALARY > 2000000;

--between and -> ���ϴ� ���� ������ ������ ���ԵǸ� true �� return�ϴ� ������.
-- �޿��� 3500000~6000000�� ������ �̸�, �޿� ��ȸ -> ���ϴ� ���� ����.

select EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;
/* WHERE SALARY >= 3500000 and SALARY <= 6000000;
between �� ���ϴ� ���� ���� (�̻�, ����)
*/

--like : ���Ϸ��� ���� ������ ���ϰ� ��ġ�ϸ� true�� �����ϴ� ������
-- WILDCARD : �ƹ��ų� ��ü�ؼ� ����� �� �ִ� ���� -> like �����ڿ� ������ �� �۵���.
--      _ (underscore) (�ƹ��ų� �� ���ڸ� ��ü)
--      % (percent) ( 0���� �̻� ��ü)
-- ���� '��'���� ������ �̸��� �޿� ��ȸ

select emp_name, salary
from employee
where emp_name like '��%'; -- or '��__' (�� ������ ���)

SELECT * FROM EMPLOYEE;

-- email �� '_' ���� ���ڰ� 3�ڸ��� ������ �̸�, �̸����� ��ȸ


--> escape '\' -> escape \ �� ���ڴ� (escape ���� ���ڴ� wildcard �� �ƴ� ���ڷ� �ν���.)

select EMAIL,EMP_NAME
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' escape '#'; 
-- # �� CONVENTION. 


/* select EMAIL, EMP_NAME
FROM EMPLOYEE
WHERE EMAIL LIKE '___@_%' ESCAPE '@';
*/

-- NOT LIKE

select emp_name, salary
from employee
where emp_name NOT like '��%';
-- ������ �������� �ʴ� ���.

--EXERCISE

-- 1.  
SELECT EMP_NAME
FROM EMPLOYEE
WHERE emp_name LIKE '%��';

-- 2.
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

--3.

SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '%s%'
and (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') 
and SALARY >= 2700000;


--���ʽ��� ���� �ʴ� ������ �̸�, �޿�, ���ʽ� ��ȸ
select EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL ; --> �Ϲ� �����ڷδ� null �� ���� �� ����.

--�μ��� ���� ������ �̸�, �μ��ڵ�, �޿�
select emp_name, dept_code, salary
from employee
where dept_code is null;

-- in : �ϳ��� column �� ���� ���� ��ġ�ϴ��� Ȯ�� (������ or �� ����� ��)
-- �μ��ڵ尡 D6 �̰ų� D9 �̰ų� D8 �� ������ �̸�, �޿�, �μ��ڵ�
select EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6', 'D9', 'D8');

-- where dept_code = 'D6' or deptcode= 'D9' or dept_code = 'D6' �� ����. 
--> AND ������ �켱���� ���ǹǷ� �������� ������.

select EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D6', 'D9', 'D8');

-- where dept_code != 'D6' AND DEPT_CODE != 'D9' AND DEPT_CODE != 'D6';

-- dual Table : ����Ŭ���� �����ϴ� �׽�Ʈ�� ���̺� (������ ���� X)
--> syntax test �뵵
--> sysdate : ���� �ð��� ����Ŭ�� date Ÿ������ �������� ��ɾ�
select sysdate from dual;

select emp_name, salary, '��', sysdate from employee;

select * from employee;

select sysdate, sysdate +10, sysdate -31, sysdate + 0.25 from dual;


select (sysdate -1) - sysdate
from dual;

select EMP_NAME, HIRE_DATE, SYSDATE, (SYSDATE - HIRE_DATE)
FROM EMPLOYEE;

-- ������ 5000���� �̻��� ������ �̸�, �޿�
select emp_name, salary
from employee
where salary*12  >= 50000000;

-- ����
-- order by
--> select �� ����� ���� ������ �� �� ����.
--> �ۼ� ��ġ�� select �� ���� ������, ���� ������ ���� ������.

select * -- 3
from employee-- 1
/*where 2*/
/*WHERE BONUS IS NOT NULL AND DEPT_CODE IS NOT NULL*/
order by DEPT_CODE ASC, EMP_NAME ASC ; --4
--> �����ϸ� �ڵ����� ASC.
--> ���� ÷�δ� ,(comma)
/*
                ������ ���� ���
                    NUMBER          ����(CHAR,VARCHAR2)   ��¥(DATE)                NULL
    ASC  ->�������� ���� ������ ū ��  ���� ��                ���� �� -> ���� ��    NULL �� ���� �Ʒ�
    DESC ->�������� ū ������ ���� ��  ���� ����              ���� �� -> ���� ��     NULL �� ���� ����
*/
-- NULL �� ���� ũ��, ��� �����ϸ� �ϱ� ����.

-- NULL �� ���� ��� : NULLS FIRST
-- NULL �� ���߿� ��� : NULLS LAST



select emp_name, salary, dept_code
from employee
order by 3 asc; --> ��ȸ�� column ù��° �������� ����. -> select �� ���� ���·� �����ϱ� ����.
--> Column �� ��ġ�� �Է��ص� ��.

select *
from employee
order by 5 asc; --> ��ȸ ��� �������� Column ���� ����.

select emp_name as �̸�,  salary �޿�, dept_code �μ��ڵ�
from employee
order by �޿� asc; --> ��Ī �ᵵ ������. -> select �� �����ϰ� ����Ǳ� ����.

select emp_name as �̸�,  salary �޿�, dept_code �μ��ڵ�
from employee
order by JOB_CODE asc; --> ��ȸ����� ���Ե��� ���� �÷��� ���� �������� ��� ������ (TABLE �� ���� �Ѵٸ�)

--
SELECT *
FROM EMPLOYEE;
--1.

select EMP_NAME �̸�, EMP_NO �ֹι�ȣ,SALARY "�޿�", HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE (SYSDATE-HIRE_DATE)/365 BETWEEN 5 AND 10
ORDER BY EMP_NAME ASC;
-- �ټӳ���� 10�� �̻��� �������� �˻��ؼ� �̸�, �޿�, �ټӳ���� ���, �ټӳ�� ��������, �޿��� 50% �λ��� �޿�

--2.

SELECT EMP_NAME �̸�, SALARY*1.5 "�λ�� �޿�", (SYSDATE-HIRE_DATE)/365 AS �ټӳ��
FROM EMPLOYEE
WHERE (SYSDATE-HIRE_DATE)/365>=10
ORDER BY �ټӳ�� ASC;

-- �Ի��� 99/01/01 -10/01/01 �� ��� �߿��� �޿��� 2000000 ������ ����� �̸�, �ֹι�ȣ, �̸���, ����ȣ, �޿�


--3.

SELECT EMP_NAME �̸�, EMP_NO �޿�, EMAIL �̸���, PHONE ����ó, SALARY �޿�
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '99/01/01' AND '10/01/01'   --DATA TYPE ��ȯ �ʿ�
AND SALARY <= 2000000;

--4.
SELECT EMP_NAME �̸�, EMP_NO �ֹι�ȣ, SALARY �޿�, DEPT_CODE �μ��ڵ�
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 3000000
AND EMP_NO LIKE  '__04%__-2%' --> ������
ORDER BY EMP_NO DESC;

--------------------------------------------------------------------0623

--FUNCTION

-- SINGLE

--���� ó�� �Լ� 
--> LENGTH ; LENGTH(col | STRING) : �־��� COLUMN �Ǵ� ���� ����(���� ����) �� ��ȯ(�� �ٸ� COLUMN)�ϴ� �Լ�
--> LENGTHB(COL | STRING) : �־��� COLUMN �Ǵ� ���� ����(BYTE) �� ��ȯ�ϴ� �Լ�

SELECT
    EMP_NAME, LENGTHB(EMP_NAME), EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
    FROM EMPLOYEE;

--> INSTR(STRING1, STRING2, NUMBER1, NUMBER2) :
    --> Ư�� ����(��)(str1)���� 'ã�� ����(str2)'�� 
    --> '���� ��ġ(num1)'���� '������ Ƚ��(num2)'��ŭ ��Ÿ�� ��ġ�� ��ȯ (��ġ�� ó�� ��ġ ����)
    --> num1 �� ������ �� �� �ִµ�, num1 �� ������ ��� �������� SEARCH ��.
    --> ��ȯ�ϴ� ��ġ�� ó�������� ��ġ.
SELECT instr('hello world hi high','h', -1,1) from dual; --> ��ġ ��ȯ


--> LPAD / RPAD : �־��� �÷� | ���ڿ��� ������ ���ڿ��� 
 --����/�����ʿ� ���ٿ� ���� N�� ���ڿ��� ��ȯ
    -->  LPAD(STRING | COLUMN , N(BYTE), ä�� ����)
    
SELECT EMAIL, LENGTHB(EMAIL), RPAD(EMAIL, 8, '!') 
--> ���� ����(B)�� �̰ɷ� ä�� / ���� ���� ���ѵ� ����.
FROM EMPLOYEE;

--> TRIM : �־��� (COLUMN �̳� ���ڿ�)�� ��/��/���ʿ� �ִ� ������ ���ڸ� ������ �� ������ ��ȯ
select 'zzzzKHzzzz' from dual;
select trim(leading 'z' from 'zzzzKHzzzz') from dual; --> leading �� ����.
select trim(trailing 'z' from 'zzzzKHzzzz') from dual;
select trim(both 'z' from 'zzzzKHzzzz') from dual;
select trim('z' from 'zzzzKHzzzz') from dual; --> �⺻ ��
select trim(' KH '), ' KH ' from dual; --> �������� //TRIM �� �ƹ� ���ڵ� �������� �ʾ��� �� �����̽� ���ڸ� ������.
select trim('KH '), ' KH ' from dual; --> ���� ���� 1ĭ ����
select trim(' KH'), ' KH ' from dual; --> ���� ���� 1ĭ ���� ���� 

--> LTRIM / RTRIM : �־��� COLUMN �̳� ���ڿ��� ���� / �����ʿ��� (������ str �� ���Ե� ��� ����)�� ������ �������� ��ȯ
SELECT LTRIM ('123123KH', '123')  FROM DUAL;
SELECT LTRIM ('11112312323123KH', '123')  FROM DUAL; --> ������ STR �� ���Ե� ����, 1, 2, 3
--> ���Ե��� �ʴ� ���ڿ��� ����.


--> SUBSTR : �־��� COLUMN �̳� ���ڿ����� ������ ��ġ���� (������ ������ ���ڿ�)�� �߶󳻾� �����ϴ� �Լ�
-- SUBSTR(STRING, POSITION, LENGTH) : LENGTH �� ���� ����

SELECT SUBSTR('SHOWMETHEMONEY', 5,2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 10) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
--> POSITION �� ������ �� �� ����. -> ����



SELECT EMP_NAME, SUBSTR(EMP_NAME, 1,1), SUBSTR(EMP_NAME, 2)
FROM EMPLOYEE;

-- LOWER / UPPER / INITCAP -> INITIALIZE CAPITAL (�� �ܾ ù���ڸ� �빮��)

SELECT LOWER('WELCOME To My WORLD') FROM DUAL;
SELECT UPPER('WELCOME To My WORLD') FROM DUAL;
SELECT INITCAP('WELCOME To My WORLD') FROM DUAL;

--  CONCAT : COLUMN �Ǵ� ���ڿ��� 2�� ���޹޾Ƽ� �ϳ��� ��ģ �� ����
SELECT CONCAT (CONCAT('�����ٶ�', 'ABCD'),1234) FROM DUAL;
SELECT '�����ٶ�'||'ABCD' FROM DUAL;

-- REPLACE : COLUMN �Ǵ� ���ڿ��� �ΰ� �޾� ���� �� ���� (STR1�� STR2�� �ٲ���)
SELECT EMAIL, REPLACE(EMAIL, 'kh.or.kr', 'iei.or.kr') FROM EMPLOYEE;



-- ���� ó�� �Լ�
    --> ABS : ���밪 ����
select abs(10) from dual;
select abs(-10) from dual;

--mod : �Է¹��� ���� ���� �������� ���� (�ڹٿ��� %) (���� ������ /)
select mod(10,3) from dual;

--round(�ݿø�) / floor(����) / ceil(�ø�)
    
select round(126.496) from dual;
select round(126.496, 2) from dual; --param2 ���� �ݿø�
select round(126.456, 0) from dual; --default
select round(126.456, -1) from dual; -- �Ҽ��� �ڸ������� �����Ѱ� �ƴ�!
select round(126.456, -2) from dual;

select floor(126.456) from dual;
select ceil(126.456) from dual;



-- ��¥ ó�� �Լ�
--sysdate :  �ý��ۿ� ����Ǿ��ִ� ���� ��¥�� ��ȯ�ϴ� �Լ�
select sysdate, current_date, localtimestamp, current_timestamp from dual; --> �ð����� ���Ե�.

--months_between : ��¥ �ΰ��� ���޹޾�, ���� ���� ���������� �����ϴ� �Լ�

select emp_name, hire_date, floor ( months_between(current_date, hire_date) ) �ٹ����� from employee
order by �ٹ����� desc;

-- add_months : ���ڷ� ���޹��� ��¥�� ���޹��� ����ŭ ���� ���� ���� ��¥�� ����
select emp_name, hire_date, add_months(hire_date,3) as "������ ��ȯ�� ��¥" from employee;

-- next_day : argu �� ���޹��� ��¥�� argu�� '���޹��� ����' �� ���� ����� '���� ����'�� ���
select current_date, next_day(current_date, '������') from dual; --> ��� ������ �ѱ۷� �Ǿ��ֱ� ����.
select current_date, next_day(current_date, 1) from dual; --���ڷ� ���� Ư�� �� 1�� �Ͽ���, 7�� �����

-- last_day : argu �� ���޹��� ��¥�� ���� ���� ������ ��¥�� ����

select current_date, last_day(current_date) from dual;

-- extract -> ��¥ �����Ϳ��� ��, ��, �� ������ ���� --> ���� ��� ����.

select current_date, extract(year from current_date) �� , 
extract(month from current_date) ��,
extract(day from current_date) ��
from dual;


---- ����ȯ CASTING
select * from employee;
desc employee; -- char -> number �ڵ� ����ȯ ����.
select 100+'100' from dual; --> ���굵 ����

-- ����ȯ �Լ� 
    --to_char : ��¥�� �Ǵ� ������ �����͸� ���������� ��ȯ�� �� ����.
select to_char(sysdate, 'RR/MM/DD') from dual;
select to_char(sysdate, 'YY/MONTH/DD/DAY') from dual;
SELECT TO_CHAR(SYSDATE, 'yy/mm/dd') from dual;
select to_char(sysdate, 'yyyy/mm/dd hh:mi:ss') from dual;
select to_char(sysdate, 'yyyy/mm/dd hh24"��"mi"��"ss"��"') from dual;

-- ���� -> ����     
select to_char(1000000, '999,999,999') from dual;
select to_char(1000000, '000,000,000') from dual; --> ���ڿ� ���� ����
select to_char(1000000, '000,000') from dual; -- �ڸ� �� �����ϸ� �ȳ���.
select to_char(1000000, '999,99') from dual;

select emp_name, salary, to_char(salary, '999,999,999'), to_char(salary, 'L999,999,999') --> won
from employee;

-- to_date : ���ڳ� ������ �����͸� ��¥�� �����ͷ� ��ȯ��.
select to_date(9701141644, 'yymmddhh24mi') as "����", 
to_char(sysdate, 'yyyy-mm-dd hh:mi:ss') "����"  from dual;

-- to_number : ������ �����͸� ���ڷ� ��ȯ
select to_number('1,000,000', '9,999,999') from dual;
select to_number('1,000,000', '999,999') from dual; --> ����


-- ��Ÿ �Լ�

-- nvl : null �� �Ǿ��ִ� coulmn �� ���� ������ ���� Ȥ�� ���ڷ� �����Ͽ� ����
select emp_name, salary, nvl(bonus,0), nvl(salary + salary*bonus, salary)
from employee;

select emp_name, nvl(dept_code,0) from employee; --> ���ڿ� 0�� ����ȯ �Ͽ� ��.

select nvl(bonus,'���ʽ�����') 
from employee; --> �ȵ�. -> ���� Ÿ������ ������.

-- decode : �����Լ� -> �������� ��쿡 ������ �� �� �ִ� ����� ���� -> switch �� ������.
-- decode(ǥ����, ����1, ���1, ����2, ���2, ����3, ���3, ...)

select emp_name, emp_no, decode(substr(emp_no, 8, 1), '1', '��', '2', '��',
'3', '��', '4', '��', '����Ʈ') as "����"
from employee;

-- case : �����Լ� -> �������� ��쿡 ������ �� �� �ִ� ����� ���� -> if-else if -> ���� ����

select emp_name, emp_no,
    case
        when substr(emp_no, 8,1) in (1,3) then '����'
        when substr(emp_no, 8,1) in (2,4) then '����'
        else '�ش� ����'
    end
    as ����
from employee;


--  �׷� �Լ�
--> : �ϳ� �̻��� ���� �׷����� ���� �����Ͽ� ����, ��� ���� �ϳ��� Column ���� �����ϴ� �Լ�
--> null �� ���꿡�� ������.
-- sum : �ش� Column �� ������ ������ ���ϴ� �Լ�
SELECT to_char(sum(salary), '999,999,999,999') �ΰǺ� FROM employee;

select to_char (sum(salary), '999,999,999') as "D8 �μ� �ΰǺ�" from employee where dept_code = 'D8';

-- ���� �������� �޿� ����
select sum(salary) from employee where substr(emp_no, 8, 1) = 1;


--avg : �ش� column �� ������ ����� ���ϴ� �Լ�
select avg(salary) from employee where substr(emp_no, 8, 1) = 1;

--count : ��ȸ ����� row�� ���� ��ȯ�ϴ� �Լ� 
select count(*) from employee where dept_code = 'D8';

--min, max : �ش� Column �� �� �� �ּҰ� / �ִ밪�� �����ϴ� �Լ�
select max(salary) from employee;
select min(salary) from employee;

--> �׷� �Լ� ���� ���ǻ���
select avg(salary),sum(salary) from employee; --> �׷� �Լ��� �Ϲ����� ��� �Բ��� �� ����.
--> ��ȸ ����� row ���� �ٸ��� ����.

select * from employee;
select dept_code from employee;
select count(dept_code) from employee; --null : �׷��Լ� ���꿡�� ������.

select round(avg(nvl(bonus, 0)),3) from employee; -- null : �׷� �Լ� ���꿡�� ������.

--1.
select EMP_NAME ������, EMAIL �̸���, LENGTH(EMAIL) �̸��ϱ���
FROM EMPLOYEE;

--2.
SELECT EMP_NAME ������, RTRIM(EMAIL,'@kh.or.kr') --> SUBSTR(EMAIL, 1, INSTR(EMAIL, '@',1, 1))
FROM EMPLOYEE;

--3.
SELECT EMP_NAME ������, SUBSTR(EMP_NO, 1, 2) ���, NVL(ROUND(BONUS, 1),0)
FROM EMPLOYEE
WHERE EMP_NO LIKE '6%';

--4.
SELECT CONCAT(TO_CHAR(COUNT(PHONE)),'��') AS �ο� 
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

--5.
SELECT EMP_NAME ������ , TO_CHAR(HIRE_DATE, 'YYYY"��"FMMM"��"') �Ի�����
FROM EMPLOYEE;

--6.
SELECT EMP_NAME ������, RPAD(SUBSTR(EMP_NO,1,8), 14, '*') �ֹι�ȣ
FROM EMPLOYEE;

--7.
SELECT EMP_NAME ������, JOB_CODE �����ڵ�,
TO_CHAR(nvl(salary + salary*bonus, salary)*12, 'L999,999,999') ����
FROM EMPLOYEE;

--8.
SELECT EMP_ID �����ڵ�, EMP_NAME ������, DEPT_CODE �μ��ڵ�, HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D9') 
AND extract(YEAR from HIRE_DATE) = 2004;

--9.
SELECT EMP_NAME ������, HIRE_DATE �Ի���, 
FLOOR(CURRENT_DATE - HIRE_DATE) �ٹ��ϼ�
FROM EMPLOYEE;

--10.
-- �� ���� + 1
SELECT 
/*CASE
    when substr(emp_no, 8,1) in (1,2) then*/
    
/*
extract(year from sysdate) - (1900+ substr(emp_no,1,2)+1) ����
*/

/* RR�� ��� 50���� ���� ��� 20XX, 50���� ū ��� 19XX
to_char(TO_DATE(SUBSTR(EMP_NO,1,2), 'RR'), 'yyyy-mm-dd hh24:mi:ss')
*/

MAX(EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY'))- EXTRACT(YEAR FROM SYSDATE)) +1
AS "�ִ� ����",
MIN(EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY'))- EXTRACT(YEAR FROM SYSDATE)) +1
AS "�ּ� ����"
--END
FROM EMPLOYEE;

--11.
SELECT EMP_NAME ������, DEPT_CODE �μ�,
case
        when DEPT_CODE IN ('D5', 'D6', 'D9') then '�߱�'
        else '�߱پ���'
    end
FROM EMPLOYEE
ORDER BY DEPT_CODE ASC;

--12.
SELECT EMP_NAME ������, DEPT_CODE �μ��ڵ�,
DECODE (DEPT_CODE, 'D5', '�ѹ���', 'D6', '��ȹ��', 'D9', '������')
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D9')
order by dept_code asc;

--13.

SELECT 
  EMP_NAME AS ������,
  DEPT_CODE AS �μ��ڵ�,
  TO_DATE(SUBSTR(EMP_NO,1,6), 'YY/MM/DD')  AS �������
FROM EMPLOYEE
WHERE EMP_ID NOT IN (200,201,214);



--14.
SELECT
COUNT (CASE WHEN extract(year from HIRE_DATE) = 1998 THEN 1 END) AS "1998�⵵",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 1999 THEN 1 END) AS "1999�⵵",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2000 THEN 1 END) AS "2000�⵵",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2001 THEN 1 END) AS "2001�⵵",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2002 THEN 1 END) AS "2002�⵵",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2003 THEN 1 END) AS "2003�⵵",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2004 THEN 1 END) AS "2004�⵵",
COUNT (*) AS "��ü ���� ��"
FROM EMPLOYEE;


/*
SELECT  --5
FROM    -- 1
[WHERE] --2
[GROUP BY] --> WHERE ���� --3
[HAVING]    --4
[ORDER BY]  --6

*/

SELECT SUM (SALARY), ROUND(AVG(SALARY)), COUNT(*), DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE;


--
SELECT DEPT_CODE, DECODE(SUBSTR(EMP_NO, 8,1), 1, '��', 2, '��') AS ����, COUNT (*) �ο���
FROM EMPLOYEE
GROUP BY DEPT_CODE, DECODE(SUBSTR(EMP_NO, 8,1), 1, '��', 2, '��')
ORDER BY 1;
--
SELECT
    DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) >= 3000000; --> GROUPING �� ������ ����

--

