# 会员信息表：
DROP TABLE IF EXISTS user;
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
DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    username VARCHAR(20) NOT NULL COMMENT '用户名',
    password VARCHAR(20) NOT NULL COMMENT '密码'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 场地信息表
DROP TABLE IF EXISTS site;
CREATE TABLE site(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    site_name VARCHAR(20) NOT NULL COMMENT '场地信息',
    status TINYINT(4) NOT NULL COMMENT '占用情况 0未占用 1已占用'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 私教信息表
DROP TABLE IF EXISTS coach;
CREATE TABLE coach(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    coach_id VARCHAR(20) NOT NULL COMMENT '私教id',
    coach_name VARCHAR(20) NOT NULL COMMENT '私教姓名',
    phone_number VARCHAR(20) NOT NULL COMMENT '私教电话',
    status TINYINT(4) NOT NULL COMMENT '在职情况 0离职 1正常'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

# 课程信息表
DROP TABLE IF EXISTS course;
CREATE TABLE course(
    id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '主键id',
    course_name VARCHAR(20) NOT NULL COMMENT '课程名',
    course_begin_time DATETIME NOT NULL COMMENT '课程开始时间',
    course_end_time DATETIME NOT NULL COMMENT '课程结束时间',
    teacher_id varchar(20) NOT NULL COMMENT '私教id',
    teacher_name varchar(20) NOT NULL COMMENT '私教姓名'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
