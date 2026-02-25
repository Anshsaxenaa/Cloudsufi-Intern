use startersql;
set sql_safe_updates =0;
-- Update users set salary = salary+'10000' where salary<'60000';
-- delete from users where id=5;
-- select * from users;
-- select * from addresses;
SELECT id,email,name,gender, salary, 'user' as role FROM users
UNION
SELECT id,email,name, gender, salary, 'admin' as role FROM  admin_users
order by salary desc;

