CREATE SEQUENCE REGSEQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

CREATE TABLE userregister (id NUMBER(7) NOT NULL,
                            username varchar2(100), 
                            pswd varchar2(50), 
                            email varchar(100), 
                            loginType varchar2(10),
                            loginStatus varchar(2),
                            PRIMARY KEY(id)); 

drop table userregister
drop sequence REGSEQ

CREATE SEQUENCE CREGSEQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
CREATE TABLE compregister (cid NUMBER(7) NOT NULL PRIMARY KEY,
                            cemail varchar2(100), 
                            cpswd varchar2(50), 
                            companyName varchar2(100), 
                            industryType varchar2(100),
                            companyType varchar2(100),
                            contactPerson varchar2(100),
                            designation varchar2(100),
                            address varchar2(100),
                            country varchar2(100),
                            state varchar2(100),
                            city varchar2(100),
                            pincode varchar2(100),
                            cmnumber varchar2(100),
                            loginStatus varchar(2)); 
                     
DROP TABLE COMPREGISTER


CREATE SEQUENCE JOBSEQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
CREATE TABLE userjobs (jobid NUMBER(7) NOT NULL PRIMARY KEY,
                    jobTitle varchar2(50), 
                    description varchar2(300), 
                    salary varchar2(50), 
                    jobType varchar2(50), 
                    skills varchar2(100), 
                    companyName varchar2(100),
                    compDesc varchar2(100),
                    city varchar2(50),
                    creationDate varchar2(50),
                    endDate varchar2(50),
                    jexperience varchar2(50),
                    jobLocation varchar2(50),
                    jRole varchar2(50),
                    jIndustryType varchar2(50),
                    jFuncArea varchar2(50),
                    jEducation varchar2(50),
                    jContactPerson varchar2(50));

CREATE SEQUENCE RESUMESEQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
create table usercv (cvid NUMBER(7) NOT NULL PRIMARY KEY,
                        cv_userid varchar2(2),
                        name varchar2(100),
                        emailid varchar2(100),
                        mobilenumber varchar2(100),
                        total_workexp_year varchar2(100),
                        total_workexp_month varchar2(100),
                        currentDesi varchar2(100),
                        currentCompany varchar2(100),
                        annualsalary_lakhs varchar2(100),
                        annualsalary_tho varchar2(100),
                        workingfrom_year varchar2(100),
                        workingfrom_month varchar2(100),
                        workingto_year varchar2(100),
                        workingto_month varchar2(100),
                        currentlocaton varchar2(100),
                        noticeperiod varchar2(100),
                        skills varchar2(100),
                        industry varchar2(100),
                        functionalArea varchar2(100),
                        role varchar2(100),
                        highestEdu varchar2(100),
                        course varchar2(100),
                        specialization varchar2(100),
                        university varchar2(100),
                        coursetype varchar2(100),
                        passingyear varchar2(100),
                        skills2 varchar2(100),
                        skills3 varchar2(100),
                        skills4 varchar2(100),
                        p_company varchar2(100),
                        p_desc varchar2(100),
                        p_fromyear varchar2(100),
                        p_frommonth varchar2(100),
                        p_toyear varchar2(100),
                        p_tomonth varchar2(100),
                        p_degree varchar2(100),
                        p_university varchar2(100),
                        p_degreeYear varchar2(100),
                        lang1 varchar2(100),
                        lang2 varchar2(100),
                        lang3 varchar2(100));
                    

drop sequence RESUMESEQ  
drop table usercv
                        
SELECT USERNAME from userregister

select USERNAME  
from userregister ur join usercv ucv
on (ur.id = ucv.cv_userid)
where name like '%p%' or skills like '%p%' or skills2 like '%p%' or skills3 like '%p%' skills4 like '%p%';

