/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/4 16:01:58                           */
/*==============================================================*/


drop table if exists tbl_classrelation;

drop table if exists tbl_course;

drop table if exists tbl_grade;

drop table if exists tbl_homework;

drop table if exists tbl_msg;

drop table if exists tbl_myjob;

drop table if exists tbl_myjobcourse;

drop table if exists tbl_myjobgrade;

drop table if exists tbl_myjobtime;

drop table if exists tbl_review;

drop table if exists tbl_teach;

drop table if exists tbl_teachplan;

drop table if exists tbl_time;

drop table if exists tbl_user;

/*==============================================================*/
/* Table: tbl_classrelation                                     */
/*==============================================================*/
create table tbl_classrelation
(
   crid                 int not null auto_increment,
   sid                  int,
   trid                 int,
   primary key (crid)
);

/*==============================================================*/
/* Table: tbl_course                                            */
/*==============================================================*/
create table tbl_course
(
   cid                  int not null auto_increment,
   cname                varchar(100),
   primary key (cid)
);

/*==============================================================*/
/* Table: tbl_grade                                             */
/*==============================================================*/
create table tbl_grade
(
   gid                  int not null auto_increment,
   gname                varchar(50),
   primary key (gid)
);

/*==============================================================*/
/* Table: tbl_homework                                          */
/*==============================================================*/
create table tbl_homework
(
   hid                  int not null auto_increment,
   tcontent             varchar(1024),
   scontent             varchar(1024),
   tstarttime           datetime,
   sfinishtime          datetime,
   score                decimal,
   sstatus              varchar(20),
   tstatus              varchar(20),
   crid                 int,
   trid                 int,
   primary key (hid)
);

/*==============================================================*/
/* Table: tbl_msg                                               */
/*==============================================================*/
create table tbl_msg
(
   mid                  int not null auto_increment,
   sendid               int,
   receiveid            int,
   content              varchar(1024),
   sendtime             datetime,
   status               int,
   primary key (mid)
);

/*==============================================================*/
/* Table: tbl_myjob                                             */
/*==============================================================*/
create table tbl_myjob
(
   jid                  int not null auto_increment,
   tid                  int,
   address              varchar(255),
   price                int,
   teacherage           varchar(10),
   primary key (jid)
);

/*==============================================================*/
/* Table: tbl_myjobcourse                                       */
/*==============================================================*/
create table tbl_myjobcourse
(
   id                   int not null auto_increment,
   cid                  int,
   jid                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_myjobgrade                                        */
/*==============================================================*/
create table tbl_myjobgrade
(
   id                   int not null auto_increment,
   gid                  int,
   jid                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_myjobtime                                         */
/*==============================================================*/
create table tbl_myjobtime
(
   id                   int not null auto_increment,
   timeid               int,
   jid                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_review                                            */
/*==============================================================*/
create table tbl_review
(
   id                   int not null auto_increment,
   reviewtime           datetime,
   reviewcontent        varchar(500),
   reviewstart          int,
   crid                 int,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_teach                                             */
/*==============================================================*/
create table tbl_teach
(
   trid                 int not null auto_increment,
   tid                  int,
   cid                  int,
   classtime            int,
   primary key (trid)
);

/*==============================================================*/
/* Table: tbl_teachplan                                         */
/*==============================================================*/
create table tbl_teachplan
(
   id                   int not null auto_increment,
   content              text,
   time                 datetime,
   trid                 int,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_time                                              */
/*==============================================================*/
create table tbl_time
(
   timeid               int not null auto_increment,
   time                 varchar(50),
   primary key (timeid)
);

/*==============================================================*/
/* Table: tbl_user                                              */
/*==============================================================*/
create table tbl_user
(
   id                   int not null auto_increment,
   username             varchar(255),
   userpwd              varchar(255),
   email                varchar(255),
   role                 char(30),
   regdate              datetime,
   realname             varchar(30),
   idnumber             char(50),
   sex                  char(10),
   stuimg               char(50),
   userimg              char(50),
   school               varchar(50),
   grade                char(20),
   phonenumber          char(30),
   address              varchar(255),
   introduce            varchar(255),
   major                varchar(50),
   status               int,
   publickey            varchar(255),
   privatekey           varchar(255),
   primary key (id)
);

