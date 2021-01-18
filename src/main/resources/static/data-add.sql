insert into employee(name,address,age,dob,email,gender,phone,position,salary) values('Nguyễn Thái Luyện','pleiku',29,DATE '1999-12-17'
,'thailuyen@gmail.com','nam','0913223456','Giám đốc',33000000);
insert into employee(name,address,age,dob,email,gender,phone,position,salary) values('Hoàng Thùy Linh','Kon Tum',22,DATE '2000-12-17'
,'linh@gmail.com','nữ','0913223456','Trưởng phòng',22000000);
insert into employee(name,address,age,dob,email,gender,phone,position,salary) values('Trương văn đa','Thánh Bình',58,DATE '1961-12-17'
,'đa@gmail.com','nam','09222222','Trưởng phòng',24000000);
insert into employee(name,address,age,dob,email,gender,phone,position,salary) values('Hoàng văn dũng','Sóc Trăng',33,DATE '1988-12-17'
,'dũng@gmail.com','nam','092797979','Nhân viên',24000000);

insert into depart(name,employee_id) values('Phòng 1',2);
insert into depart(name,employee_id) values('Phòng 2',3);


insert into team(name,depart_id) values('team 1',1);
insert into team(name,depart_id) values('team 2',1);
insert into team(name,depart_id) values('team 3',1);
insert into team(name,depart_id) values('team 4',2);
insert into team(name,depart_id) values('team 5',2);

INSERT INTO team_employee(team_id,employee_id) VALUES (1,2);
INSERT INTO team_employee(team_id,employee_id) VALUES (1,4);
INSERT INTO team_employee(team_id,employee_id) VALUES (4,4);
INSERT INTO team_employee(team_id,employee_id) VALUES (5,4);
INSERT INTO team_employee(team_id,employee_id) VALUES (4,3);