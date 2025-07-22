-- DML(DATA MANIPULATION LANGUAGE)
    --> INSERT, UPDATE, DELETE
    
    --> INSERT
     --> 테이블에 새로운 행을 추가하는 구문
     
     create user test_user identified by 1234;
     grant connect to test_user;
     
     revoke connect from test_user;
     