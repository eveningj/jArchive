/*select searchColumn; 
from tableName;*/
--Line Comment

--employee table 의 모든 Column 조회
select * -- * -> ALL COLUMN
from employee; 
select EMP_NAME, EMAIL, PHONE -- -> COLUMN SEARCH
from employee; --> TABLE

select *
from employee
where emp_name = '정중하'; --> Context 참조  (row)

select * -- 실행 순서 3)
from employee -- 실행 순서 1)
where dept_code = 'D9'; --> 대/소문자 구분, 조건식 --실행 순서 2)


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

--select 결과, Column 에 별칭 지정
select emp_name as "이름", salary as "월급(원)", salary*12  sal --> 별칭 지정됨,특수문자 없으면 따옴표 생략 가능.
from employee;

select emp_name, salary, salary + salary*bonus as "최종 연봉" -- 보너스 비율 -> null data 라 연산 불가능.
from employee;

select emp_name, salary || '원', '원' 
from employee;
--> row 에 붙일 수 있음. (' ' -> char)
--> || 는 연결 연산자. Literal 을 Column 인 것 처럼 기능하게 할 수 있음.

--distinct : 조회된 결과에서 중복된 row 를 삭제. (동시에 다 겹칠 때. 이름, jobcode.)
select distinct emp_name, job_code from employee; 

-- 논리연산자
-- 부서코드가 D6이고 급여가 2,000,000 보다 많이 받는 직원인 이름, 부서코드, 급여 조회

select EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' and SALARY > 2000000;

--between and -> 비교하는 값이 지정한 범위에 포함되면 true 로 return하는 연산자.
-- 급여를 3500000~6000000인 직원의 이름, 급여 조회 -> 비교하는 숫자 포함.

select EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;
/* WHERE SALARY >= 3500000 and SALARY <= 6000000;
between 은 비교하는 숫자 포함 (이상, 이하)
*/

--like : 비교하려는 값이 지정한 패턴과 일치하면 true를 리턴하는 연산자
-- WILDCARD : 아무거나 대체해서 사용할 수 있는 문자 -> like 연산자와 만났을 때 작동함.
--      _ (underscore) (아무거나 한 글자를 대체)
--      % (percent) ( 0글자 이상 대체)
-- 성이 '전'씨인 직원의 이름과 급여 조회

select emp_name, salary
from employee
where emp_name like '전%'; -- or '전__' (세 글자인 경우)

SELECT * FROM EMPLOYEE;

-- email 중 '_' 앞의 문자가 3자리인 직원의 이름, 이메일을 조회


--> escape '\' -> escape \ 로 쓰겠다 (escape 뒤의 문자는 wildcard 가 아닌 문자로 인식함.)

select EMAIL,EMP_NAME
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' escape '#'; 
-- # 은 CONVENTION. 


/* select EMAIL, EMP_NAME
FROM EMPLOYEE
WHERE EMAIL LIKE '___@_%' ESCAPE '@';
*/

-- NOT LIKE

select emp_name, salary
from employee
where emp_name NOT like '전%';
-- 전으로 시작하지 않는 사람.

--EXERCISE

-- 1.  
SELECT EMP_NAME
FROM EMPLOYEE
WHERE emp_name LIKE '%연';

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


--보너스를 받지 않는 직원의 이름, 급여, 보너스 조회
select EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL ; --> 일반 연산자로는 null 을 비교할 수 없음.

--부서가 없는 직원의 이름, 부서코드, 급여
select emp_name, dept_code, salary
from employee
where dept_code is null;

-- in : 하나의 column 을 여러 값과 일치하는지 확인 (연산자 or 로 연결될 때)
-- 부서코드가 D6 이거나 D9 이거나 D8 인 직원의 이름, 급여, 부서코드
select EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6', 'D9', 'D8');

-- where dept_code = 'D6' or deptcode= 'D9' or dept_code = 'D6' 과 같음. 
--> AND 연산자 우선으로 계산되므로 불편함이 존재함.

select EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D6', 'D9', 'D8');

-- where dept_code != 'D6' AND DEPT_CODE != 'D9' AND DEPT_CODE != 'D6';

-- dual Table : 오라클에서 제공하는 테스트용 테이블 (데이터 저장 X)
--> syntax test 용도
--> sysdate : 현재 시간을 오라클의 date 타입으로 가져오는 명령어
select sysdate from dual;

select emp_name, salary, '원', sysdate from employee;

select * from employee;

select sysdate, sysdate +10, sysdate -31, sysdate + 0.25 from dual;


select (sysdate -1) - sysdate
from dual;

select EMP_NAME, HIRE_DATE, SYSDATE, (SYSDATE - HIRE_DATE)
FROM EMPLOYEE;

-- 연봉이 5000만원 이상인 직원의 이름, 급여
select emp_name, salary
from employee
where salary*12  >= 50000000;

-- 정렬
-- order by
--> select 된 결과에 대해 정렬을 할 때 사용됨.
--> 작성 위치는 select 의 가장 마지막, 실행 순서도 가장 마지막.

select * -- 3
from employee-- 1
/*where 2*/
/*WHERE BONUS IS NOT NULL AND DEPT_CODE IS NOT NULL*/
order by DEPT_CODE ASC, EMP_NAME ASC ; --4
--> 생략하면 자동으로 ASC.
--> 조건 첨부는 ,(comma)
/*
                데이터 정렬 방법
                    NUMBER          문자(CHAR,VARCHAR2)   날짜(DATE)                NULL
    ASC  ->오름차순 작은 수에서 큰 수  사전 순                빠른 날 -> 늦은 날    NULL 을 가장 아래
    DESC ->내림차순 큰 수에서 작은 수  사전 역순              늦은 날 -> 빠른 날     NULL 을 가장 위에
*/
-- NULL 이 가장 크다, 라고 생각하면 암기 쉬움.

-- NULL 을 먼저 출력 : NULLS FIRST
-- NULL 을 나중에 출력 : NULLS LAST



select emp_name, salary, dept_code
from employee
order by 3 asc; --> 조회된 column 첫번째 기준으로 정렬. -> select 가 끝난 상태로 동작하기 때문.
--> Column 의 위치를 입력해도 됨.

select *
from employee
order by 5 asc; --> 조회 결과 기준으로 Column 기준 정렬.

select emp_name as 이름,  salary 급여, dept_code 부서코드
from employee
order by 급여 asc; --> 별칭 써도 가능함. -> select 가 동작하고 실행되기 때문.

select emp_name as 이름,  salary 급여, dept_code 부서코드
from employee
order by JOB_CODE asc; --> 조회결과에 포함되지 않은 컬럼도 정렬 기준으로 사용 가능함 (TABLE 에 존재 한다면)

--
SELECT *
FROM EMPLOYEE;
--1.

select EMP_NAME 이름, EMP_NO 주민번호,SALARY "급여", HIRE_DATE 입사일
FROM EMPLOYEE
WHERE (SYSDATE-HIRE_DATE)/365 BETWEEN 5 AND 10
ORDER BY EMP_NAME ASC;
-- 근속년수가 10년 이상인 직원들을 검색해서 이름, 급여, 근속년수를 출력, 근속년수 오름차순, 급여는 50% 인상한 급여

--2.

SELECT EMP_NAME 이름, SALARY*1.5 "인상된 급여", (SYSDATE-HIRE_DATE)/365 AS 근속년수
FROM EMPLOYEE
WHERE (SYSDATE-HIRE_DATE)/365>=10
ORDER BY 근속년수 ASC;

-- 입사일 99/01/01 -10/01/01 인 사람 중에서 급여가 2000000 이하인 사람의 이름, 주민번호, 이메일, 폰번호, 급여


--3.

SELECT EMP_NAME 이름, EMP_NO 급여, EMAIL 이메일, PHONE 연락처, SALARY 급여
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '99/01/01' AND '10/01/01'   --DATA TYPE 변환 필요
AND SALARY <= 2000000;

--4.
SELECT EMP_NAME 이름, EMP_NO 주민번호, SALARY 급여, DEPT_CODE 부서코드
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 3000000
AND EMP_NO LIKE  '__04%__-2%' --> 여직원
ORDER BY EMP_NO DESC;

--------------------------------------------------------------------0623

--FUNCTION

-- SINGLE

--문자 처리 함수 
--> LENGTH ; LENGTH(col | STRING) : 주어진 COLUMN 또는 값의 길이(문자 개수) 를 반환(또 다른 COLUMN)하는 함수
--> LENGTHB(COL | STRING) : 주어진 COLUMN 또는 값의 길이(BYTE) 를 반환하는 함수

SELECT
    EMP_NAME, LENGTHB(EMP_NAME), EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
    FROM EMPLOYEE;

--> INSTR(STRING1, STRING2, NUMBER1, NUMBER2) :
    --> 특정 문자(열)(str1)에서 '찾는 문자(str2)'가 
    --> '지정 위치(num1)'부터 '지정한 횟수(num2)'만큼 나타난 위치를 반환 (위치는 처음 위치 기준)
    --> num1 은 음수가 될 수 있는데, num1 이 음수인 경우 역순으로 SEARCH 함.
    --> 반환하는 위치는 처음부터의 위치.
SELECT instr('hello world hi high','h', -1,1) from dual; --> 위치 반환


--> LPAD / RPAD : 주어진 컬럼 | 문자열에 임의의 문자열을 
 --왼쪽/오른쪽에 덧붙여 길이 N의 문자열을 반환
    -->  LPAD(STRING | COLUMN , N(BYTE), 채울 문자)
    
SELECT EMAIL, LENGTHB(EMAIL), RPAD(EMAIL, 8, '!') 
--> 남는 공간(B)에 이걸로 채워 / 문자 공간 제한도 가능.
FROM EMPLOYEE;

--> TRIM : 주어진 (COLUMN 이나 문자열)의 앞/뒤/양쪽에 있는 지정한 문자를 제거한 후 나머지 반환
select 'zzzzKHzzzz' from dual;
select trim(leading 'z' from 'zzzzKHzzzz') from dual; --> leading 은 앞쪽.
select trim(trailing 'z' from 'zzzzKHzzzz') from dual;
select trim(both 'z' from 'zzzzKHzzzz') from dual;
select trim('z' from 'zzzzKHzzzz') from dual; --> 기본 값
select trim(' KH '), ' KH ' from dual; --> 공백제거 //TRIM 은 아무 문자도 지정하지 않았을 때 스페이스 문자를 제거함.
select trim('KH '), ' KH ' from dual; --> 앞의 공백 1칸 제거
select trim(' KH'), ' KH ' from dual; --> 뒤의 공백 1칸 공백 제거 

--> LTRIM / RTRIM : 주어진 COLUMN 이나 문자열의 왼쪽 / 오른쪽에서 (지정한 str 에 포함된 모든 문자)를 제거한 나머지를 반환
SELECT LTRIM ('123123KH', '123')  FROM DUAL;
SELECT LTRIM ('11112312323123KH', '123')  FROM DUAL; --> 지정한 STR 에 포함된 문자, 1, 2, 3
--> 포함되지 않는 문자에서 멈춤.


--> SUBSTR : 주어진 COLUMN 이나 문자열에서 지정한 위치부터 (지정한 개수의 문자열)을 잘라내어 리턴하는 함수
-- SUBSTR(STRING, POSITION, LENGTH) : LENGTH 는 생략 가능

SELECT SUBSTR('SHOWMETHEMONEY', 5,2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 10) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
--> POSITION 은 음수가 될 수 있음. -> 역순



SELECT EMP_NAME, SUBSTR(EMP_NAME, 1,1), SUBSTR(EMP_NAME, 2)
FROM EMPLOYEE;

-- LOWER / UPPER / INITCAP -> INITIALIZE CAPITAL (각 단어별 첫글자만 대문자)

SELECT LOWER('WELCOME To My WORLD') FROM DUAL;
SELECT UPPER('WELCOME To My WORLD') FROM DUAL;
SELECT INITCAP('WELCOME To My WORLD') FROM DUAL;

--  CONCAT : COLUMN 또는 문자열을 2개 전달받아서 하나로 합친 후 리턴
SELECT CONCAT (CONCAT('가나다라', 'ABCD'),1234) FROM DUAL;
SELECT '가나다라'||'ABCD' FROM DUAL;

-- REPLACE : COLUMN 또는 문자열을 두개 받아 변경 후 리턴 (STR1을 STR2로 바꿔줘)
SELECT EMAIL, REPLACE(EMAIL, 'kh.or.kr', 'iei.or.kr') FROM EMPLOYEE;



-- 숫자 처리 함수
    --> ABS : 절대값 리턴
select abs(10) from dual;
select abs(-10) from dual;

--mod : 입력받은 수를 나눈 나머지를 리턴 (자바에서 %) (몫은 연산자 /)
select mod(10,3) from dual;

--round(반올림) / floor(버림) / ceil(올림)
    
select round(126.496) from dual;
select round(126.496, 2) from dual; --param2 에서 반올림
select round(126.456, 0) from dual; --default
select round(126.456, -1) from dual; -- 소수점 자리에서만 가능한게 아님!
select round(126.456, -2) from dual;

select floor(126.456) from dual;
select ceil(126.456) from dual;



-- 날짜 처리 함수
--sysdate :  시스템에 저장되어있는 현재 날짜를 반환하는 함수
select sysdate, current_date, localtimestamp, current_timestamp from dual; --> 시간까지 포함됨.

--months_between : 날짜 두개를 전달받아, 개월 수를 숫자형으로 리턴하는 함수

select emp_name, hire_date, floor ( months_between(current_date, hire_date) ) 근무개월 from employee
order by 근무개월 desc;

-- add_months : 인자로 전달받은 날짜에 전달받은 수만큼 개월 수를 더해 날짜를 리턴
select emp_name, hire_date, add_months(hire_date,3) as "정규직 전환한 날짜" from employee;

-- next_day : argu 로 전달받은 날짜에 argu로 '전달받은 요일' 중 가장 가까운 '다음 요일'을 출력
select current_date, next_day(current_date, '월요일') from dual; --> 언어 세팅이 한글로 되어있기 때문.
select current_date, next_day(current_date, 1) from dual; --숫자로 요일 특정 시 1이 일요일, 7이 토요일

-- last_day : argu 로 전달받은 날짜가 속한 달의 마지막 날짜를 리턴

select current_date, last_day(current_date) from dual;

-- extract -> 날짜 데이터에서 년, 월, 일 정보만 추출 --> 숫자 계산 가능.

select current_date, extract(year from current_date) 년 , 
extract(month from current_date) 월,
extract(day from current_date) 일
from dual;


---- 형변환 CASTING
select * from employee;
desc employee; -- char -> number 자동 형변환 가능.
select 100+'100' from dual; --> 연산도 가능

-- 형변환 함수 
    --to_char : 날짜형 또는 숫자형 데이터를 문자형으로 변환할 때 사용됨.
select to_char(sysdate, 'RR/MM/DD') from dual;
select to_char(sysdate, 'YY/MONTH/DD/DAY') from dual;
SELECT TO_CHAR(SYSDATE, 'yy/mm/dd') from dual;
select to_char(sysdate, 'yyyy/mm/dd hh:mi:ss') from dual;
select to_char(sysdate, 'yyyy/mm/dd hh24"시"mi"분"ss"초"') from dual;

-- 숫자 -> 문자     
select to_char(1000000, '999,999,999') from dual;
select to_char(1000000, '000,000,000') from dual; --> 문자열 길이 조정
select to_char(1000000, '000,000') from dual; -- 자리 수 부족하면 안나옴.
select to_char(1000000, '999,99') from dual;

select emp_name, salary, to_char(salary, '999,999,999'), to_char(salary, 'L999,999,999') --> won
from employee;

-- to_date : 숫자나 문자형 데이터를 날짜형 데이터로 변환함.
select to_date(9701141644, 'yymmddhh24mi') as "생년", 
to_char(sysdate, 'yyyy-mm-dd hh:mi:ss') "지금"  from dual;

-- to_number : 문자형 데이터를 숫자로 반환
select to_number('1,000,000', '9,999,999') from dual;
select to_number('1,000,000', '999,999') from dual; --> 오류


-- 기타 함수

-- nvl : null 로 되어있는 coulmn 의 값을 지정한 숫자 혹은 문자로 변경하여 리턴
select emp_name, salary, nvl(bonus,0), nvl(salary + salary*bonus, salary)
from employee;

select emp_name, nvl(dept_code,0) from employee; --> 문자열 0로 형변환 하여 들어감.

select nvl(bonus,'보너스없음') 
from employee; --> 안됨. -> 숫자 타입으로 들어가야함.

-- decode : 선택함수 -> 여러가지 경우에 선택을 할 수 있는 기능을 제공 -> switch 랑 유사함.
-- decode(표현식, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3, ...)

select emp_name, emp_no, decode(substr(emp_no, 8, 1), '1', '남', '2', '여',
'3', '남', '4', '여', '디폴트') as "성별"
from employee;

-- case : 선택함수 -> 여러가지 경우에 선택을 할 수 있는 기능을 제공 -> if-else if -> 범위 가능

select emp_name, emp_no,
    case
        when substr(emp_no, 8,1) in (1,3) then '남자'
        when substr(emp_no, 8,1) in (2,4) then '여자'
        else '해당 없음'
    end
    as 성별
from employee;


--  그룹 함수
--> : 하나 이상의 행을 그룹으로 묶어 연산하여 총합, 평균 등을 하나의 Column 으로 리턴하는 함수
--> null 은 연산에서 제외함.
-- sum : 해당 Column 의 값들의 총합을 구하는 함수
SELECT to_char(sum(salary), '999,999,999,999') 인건비 FROM employee;

select to_char (sum(salary), '999,999,999') as "D8 부서 인건비" from employee where dept_code = 'D8';

-- 남자 직원들의 급여 총합
select sum(salary) from employee where substr(emp_no, 8, 1) = 1;


--avg : 해당 column 의 값들의 평균을 구하는 함수
select avg(salary) from employee where substr(emp_no, 8, 1) = 1;

--count : 조회 결과의 row의 수를 반환하는 함수 
select count(*) from employee where dept_code = 'D8';

--min, max : 해당 Column 의 값 중 최소값 / 최대값을 리턴하는 함수
select max(salary) from employee;
select min(salary) from employee;

--> 그룹 함수 사용시 주의사항
select avg(salary),sum(salary) from employee; --> 그룹 함수는 일반적인 행과 함께할 수 없다.
--> 조회 결과의 row 수가 다르기 때문.

select * from employee;
select dept_code from employee;
select count(dept_code) from employee; --null : 그룹함수 연산에서 제외함.

select round(avg(nvl(bonus, 0)),3) from employee; -- null : 그룹 함수 연산에서 제외함.

--1.
select EMP_NAME 직원명, EMAIL 이메일, LENGTH(EMAIL) 이메일길이
FROM EMPLOYEE;

--2.
SELECT EMP_NAME 직원명, RTRIM(EMAIL,'@kh.or.kr') --> SUBSTR(EMAIL, 1, INSTR(EMAIL, '@',1, 1))
FROM EMPLOYEE;

--3.
SELECT EMP_NAME 직원명, SUBSTR(EMP_NO, 1, 2) 년생, NVL(ROUND(BONUS, 1),0)
FROM EMPLOYEE
WHERE EMP_NO LIKE '6%';

--4.
SELECT CONCAT(TO_CHAR(COUNT(PHONE)),'명') AS 인원 
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

--5.
SELECT EMP_NAME 직원명 , TO_CHAR(HIRE_DATE, 'YYYY"년"FMMM"월"') 입사년월일
FROM EMPLOYEE;

--6.
SELECT EMP_NAME 직원명, RPAD(SUBSTR(EMP_NO,1,8), 14, '*') 주민번호
FROM EMPLOYEE;

--7.
SELECT EMP_NAME 직원명, JOB_CODE 직급코드,
TO_CHAR(nvl(salary + salary*bonus, salary)*12, 'L999,999,999') 연봉
FROM EMPLOYEE;

--8.
SELECT EMP_ID 직원코드, EMP_NAME 직원명, DEPT_CODE 부서코드, HIRE_DATE 입사일
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D9') 
AND extract(YEAR from HIRE_DATE) = 2004;

--9.
SELECT EMP_NAME 직원명, HIRE_DATE 입사일, 
FLOOR(CURRENT_DATE - HIRE_DATE) 근무일수
FROM EMPLOYEE;

--10.
-- 만 나이 + 1
SELECT 
/*CASE
    when substr(emp_no, 8,1) in (1,2) then*/
    
/*
extract(year from sysdate) - (1900+ substr(emp_no,1,2)+1) 나이
*/

/* RR의 경우 50보다 작은 경우 20XX, 50보다 큰 경우 19XX
to_char(TO_DATE(SUBSTR(EMP_NO,1,2), 'RR'), 'yyyy-mm-dd hh24:mi:ss')
*/

MAX(EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY'))- EXTRACT(YEAR FROM SYSDATE)) +1
AS "최대 나이",
MIN(EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY'))- EXTRACT(YEAR FROM SYSDATE)) +1
AS "최소 나이"
--END
FROM EMPLOYEE;

--11.
SELECT EMP_NAME 직원명, DEPT_CODE 부서,
case
        when DEPT_CODE IN ('D5', 'D6', 'D9') then '야근'
        else '야근없음'
    end
FROM EMPLOYEE
ORDER BY DEPT_CODE ASC;

--12.
SELECT EMP_NAME 직원명, DEPT_CODE 부서코드,
DECODE (DEPT_CODE, 'D5', '총무부', 'D6', '기획부', 'D9', '영업부')
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D9')
order by dept_code asc;

--13.

SELECT 
  EMP_NAME AS 직원명,
  DEPT_CODE AS 부서코드,
  TO_DATE(SUBSTR(EMP_NO,1,6), 'YY/MM/DD')  AS 생년월일
FROM EMPLOYEE
WHERE EMP_ID NOT IN (200,201,214);



--14.
SELECT
COUNT (CASE WHEN extract(year from HIRE_DATE) = 1998 THEN 1 END) AS "1998년도",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 1999 THEN 1 END) AS "1999년도",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2000 THEN 1 END) AS "2000년도",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2001 THEN 1 END) AS "2001년도",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2002 THEN 1 END) AS "2002년도",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2003 THEN 1 END) AS "2003년도",
COUNT (CASE WHEN extract(year from HIRE_DATE) = 2004 THEN 1 END) AS "2004년도",
COUNT (*) AS "전체 직원 수"
FROM EMPLOYEE;


/*
SELECT  --5
FROM    -- 1
[WHERE] --2
[GROUP BY] --> WHERE 다음 --3
[HAVING]    --4
[ORDER BY]  --6

*/

SELECT SUM (SALARY), ROUND(AVG(SALARY)), COUNT(*), DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE;


--
SELECT DEPT_CODE, DECODE(SUBSTR(EMP_NO, 8,1), 1, '남', 2, '여') AS 성별, COUNT (*) 인원수
FROM EMPLOYEE
GROUP BY DEPT_CODE, DECODE(SUBSTR(EMP_NO, 8,1), 1, '남', 2, '여')
ORDER BY 1;
--
SELECT
    DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) >= 3000000; --> GROUPING 된 이후의 조건

--

