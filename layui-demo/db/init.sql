drop table if exists sys_user;
create table sys_user
(
  id         int auto_increment
    primary key,
  username   varchar(30)                        not null,
  password    varchar(50) default '123456'       not null,
  status     tinyint default '1'                not null,
  createId   int                                null,
  createDate datetime default CURRENT_TIMESTAMP not null,
  constraint username
  unique (username),
  constraint sys_user_ibfk_1
  foreign key (createId) references sys_user (id)
);

create index createId
  on sys_user (create_id);


INSERT INTO layui.sys_user (id, username, password, status, create_id, create_date) VALUES (1, 'admin', '123456', 1, null, '2018-11-11 20:05:50');