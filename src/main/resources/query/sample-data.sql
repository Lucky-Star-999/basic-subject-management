-- Create subject
insert into
	subject(title, description)
values
	('Introduction to Computing', 'The starter course for each IT student');

insert into
	subject(title, description)
values
	('Object-oriented programming', 'A programming paradigm based on the concept of objects');

insert into
	subject(title, description)
values
	('Data structures and algorithms', 'An important aspect of any programming language');


-- Create students
insert into
	student(email, full_name, phone, major)
values
	('theboost1305@gmail.com', 'Nguyễn Hoàng Linh', '0933348791', 'Computer Science');

insert into
	student(email, full_name, phone, major)
values
	('alice@gmail.com', 'Alice', '0123456879', 'Computer Science');

insert into
	student(email, full_name, phone, major)
values
	('bob@gmail.com', 'Bob', '0123456879', 'Computer Science');


-- Create teachers
insert into
	teacher(email, full_name, phone, department, subject_id)
values
	('lucky@gmail.com', 'Lucky', '0933348791', 'Information Technology', 1);
	
insert into
	teacher(email, full_name, phone, department, subject_id)
values
	('bright@gmail.com', 'Bright', '0123456789', 'Information Technology', 2);

insert into
	teacher(email, full_name, phone, department, subject_id)
values
	('sun@gmail.com', 'Sun', '0123456789', 'Information Technology', 3);


-- Create relation between students and subjects
insert into student_subject_relation(student_id, subject_id) values (1, 1);
insert into student_subject_relation(student_id, subject_id) values (1, 2);
insert into student_subject_relation(student_id, subject_id) values (1, 3);
insert into student_subject_relation(student_id, subject_id) values (2, 1);
insert into student_subject_relation(student_id, subject_id) values (2, 2);
insert into student_subject_relation(student_id, subject_id) values (2, 3);
insert into student_subject_relation(student_id, subject_id) values (3, 1);
insert into student_subject_relation(student_id, subject_id) values (3, 2);
insert into student_subject_relation(student_id, subject_id) values (3, 3);




