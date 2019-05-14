/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/14 10:06:58                           */
/*==============================================================*/


drop table if exists tbl_article;

drop table if exists tbl_articlereview;

/*==============================================================*/
/* Table: tbl_article                                           */
/*==============================================================*/
create table tbl_article
(
   aId                  int not null auto_increment,
   id                   int,
   title                varchar(500),
   content              text,
   sendtime             datetime,
   likecount            int,
   primary key (aId)
);

alter table tbl_article comment 'ндуб╠М';

/*==============================================================*/
/* Table: tbl_articlereview                                     */
/*==============================================================*/
create table tbl_articlereview
(
   arid                 int not null auto_increment,
   id                   int,
   aid                  int,
   rcontent             varchar(500),
   rtime                datetime,
   primary key (arid)
);

