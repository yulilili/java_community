create table question
(
	id int auto_increment,
	title varchar(50),
	description text,
	gmt_create bigint,
	gmt_modified bigint,
	like_account int default 0,
	comment_account int default 0,
	view_account int default 0,
	creator int,
	tag varchar(256),
	constraint question_pk
		primary key (id)
);