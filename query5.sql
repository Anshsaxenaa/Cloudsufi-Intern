use startersql;
 create view high_salary_employes as 
  select id, name, salary 
  from users
 where salary > 60000;
update users set salary = 50000 where id=6;
update users set salary = 70000 where id = 4;
-- drop view high_salary_employes;
select * from high_salary_employes;
select* from users;