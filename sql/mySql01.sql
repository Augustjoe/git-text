-- 查询所有的数据库
show databases ;
-- 切换数据库
use db02;

-- 查询正在使用的数据库
select database();

-- --------------------------------
-- 创建用户信息表
create table user (
    id int comment 'ID 唯一标识',
    userName varchar(50) comment '用户名',
    name varchar(10) comment '姓名',
    age int comment '年龄',
    gemder char(1) comment '性别'
) comment '用户信息表';

create table user (
    id int primary key auto_increment comment 'ID 唯一标识',
    userName varchar(50) not null unique comment '用户名',
    name varchar(10) not null comment '姓名',
    age int comment '年龄',
    gemder char(1) default '男' comment '性别'
) comment '用户信息表';

create table emp (
    id int unsigned primary key auto_increment  comment '主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment  '密码',
    name varchar(20) not null comment '姓名',
    gender tinyint unsigned not null comment '性别，1 男 0 女',
    phone char(11) not null  unique comment '手机号',
    job tinyint unsigned comment '职位',
    salary int unsigned comment '薪资',
    entry_data date comment '入职日期',
    image varchar(255) comment '图像',
    create_time datetime comment '创建时间',
    updata_time datetime comment '修改时间'
) comment '员工表';

# 查看当前数据库的所有表
show tables;

# 查看当前表的数据结构
desc emp;

# z展示表的建表语句
show create table emp;

# 给特殊表添加字段
alter table emp add  qq varchar(13) comment 'qq号码';

# 修改表中字段类型
alter table emp modify qq varchar(15) comment 'QQ号码';
alter table emp modify id int unsigned primary key comment 'ID';
# 修改字段名
alter table  emp change  qq qq_num varchar(15) comment 'QQ号码';

# 删除字段
alter table emp drop  qq_num;

# 表名重命名
alter table emp rename employee;

# 删除表
drop table  emp;

# 为表中的特定字段插入值
insert into emp(username,password,name,gender,phone) values ('Tom','123456789','汤姆',1,'12345678901');

# 为表中所有的字段设置值
insert into emp(id, username, password, name, gender, phone, job, salary, entry_data, image, create_time, updata_time)
       values (null,'linchong2','123456','林冲',1,'12345678903','1',6000,'2026-09-14','1.img',now(),now());

insert into emp values (null,'linchong','123456','林冲',1,'12345678902','1',6000,'2026-09-14','1.img',now(),now());

# 添加多个数据
insert into emp(username,password,name,gender,phone)
       values ('Tom2','123456789','汤姆',1,'12345678911'),('Tom3','123456789','汤姆',1,'12345678931');
# 更新表操作
update emp set username = 'Likui' where username = 'linchong2';

# 删除表操作
delete from emp where id = 1 || id = 2;
delete from emp;