create table books_aud
(
	event_id int auto_increment
		primary key,
	event_date datetime not null,
	event_type varchar(10) null,
	book_id int not null,
	old_title varchar(255) null,
	new_title varchar(255) null,
	old_pubyear int null,
	new_pubyear int null,
	old_bestseller tinyint(1) null,
	new_bestseller tinyint(1) null
);

