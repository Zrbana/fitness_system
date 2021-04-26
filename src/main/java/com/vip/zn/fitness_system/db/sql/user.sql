# 会员信息表：
CREATE TABLE user(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    name VARCHAR(20) NOT NULL COMMENT '姓名',
    gender TINYINT(4) NOT NULL COMMENT '性别 女1  男2',
    begin_time DATE NOT NULL COMMENT '开始使用时间',
    end_time DATE NOT NULL COMMENT '结束使用时间',
    card_type TINYINT(4) NOT NULL COMMENT '卡类型 0年卡 1季卡 2月卡',
    phone_number VARCHAR(12) NOT NULL COMMENT '手机号码',
    card_num varchar(12) NOT NULL COMMENT '卡号',
    is_expired TINYINT(4) NOT NULL COMMENT '是否过期 0未过期 1已过期'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 账号信息表
CREATE TABLE account
(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    username VARCHAR(20) NOT NULL COMMENT '用户名',
    password VARCHAR(20) NOT NULL COMMENT '密码'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 场地信息表
CREATE TABLE place(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    placeName VARCHAR(20) NOT NULL COMMENT '场地信息',
    status TINYINT(4) NOT NULL COMMENT '占用情况 0未占用 1已占用'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 私教信息表
CREATE TABLE teacher(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    teacherId VARCHAR(20) NOT NULL COMMENT '私教id',
    teacherName VARCHAR(20) NOT NULL COMMENT '私教姓名',
    phone_number VARCHAR(20) NOT NULL COMMENT '私教电话',
    status TINYINT(4) NOT NULL COMMENT '在职情况 0离职 1正常'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 课程信息表
CREATE TABLE course(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    courseName VARCHAR(20) NOT NULL COMMENT '课程名',
    courseBeginTime DATETIME NOT NULL COMMENT '课程开始时间',
    courseEndTime DATETIME(20) NOT NULL COMMENT '课程结束时间',
    teacherId varchar(20) NOT NULL COMMENT '私教id'
)ENGINE=INNODB DEFAULT CHARSET=utf8;




insert into user value ('南孙',0,'2020-01-01','2021-01-01',1,'110');
insert into user value ('索索',0,'2020-01-01','2021-01-01',1,'110');
insert into user value ('锁锁',0,'2020-01-01','2021-01-01',1,'110');
insert into user value ('代兮兮',0,'2020-01-01','2021-01-01',1,'110');
insert into user value ('段序',0,'2020-01-01','2021-01-01',1,'110');
insert into user value ('小紫',0,'2020-01-01','2021-01-01',1,'110');
insert into user value ('大红',0,'2020-01-01','2021-01-01',1,'110');