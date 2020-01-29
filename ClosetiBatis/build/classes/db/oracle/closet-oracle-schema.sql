drop table follow;
drop table t_like;
drop table t_dislike;
drop table post;
drop table member;

drop sequence postId;
drop sequence memberid;

create table member (
	  memberid int not null,
    email varchar(80) not null,
    password varchar(80) not null,
    username varchar(30) not null,
    bio varchar(80) null,
    constraint pk_member primary key (memberid),
    constraint uk_member_email unique(email)
);

grant all on member to public;
create sequence memberid start with 1 increment by 1;


create table post (
	  postId int not null,
	  memberid int not null,
	  postDate varchar(80) not null,
    text varchar(255) not null,
    img varchar(80) not null,
    category int not null,
    n_like int null,
    n_dislike int null,
    constraint pk_post primary key (postId),
    constraint fk_member foreign key (memberid) references member (memberid)
);

grant all on post to public;
create sequence postId start with 1 increment by 1;

create table follow (
	  id int not null,
	  f_id int not null,
    constraint pk_follow primary key (id, f_id),
    constraint fk_member_1 foreign key (id) references member (memberid),
    constraint fk_member_2 foreign key (f_id) references member (memberid)
);

grant all on follow to public;

create table t_like (
	  p_id int not null,
	  u_id int not null,
    constraint pk_like primary key (p_id, u_id),
    constraint fk_post_1 foreign key (p_id) references post (postId),
    constraint fk_user_1 foreign key (u_id) references member (memberid)
);

grant all on t_like to public;

create table t_dislike (
	  p_id int not null,
	  u_id int not null,
    constraint pk_dislike primary key (p_id, u_id),
    constraint fk_post_2 foreign key (p_id) references post (postId),
    constraint fk_user_2 foreign key (u_id) references member (memberid)
);

grant all on t_dislike to public;
