/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/1/5 ������ 21:49:40                        */
/*==============================================================*/


drop table if exists Album;

drop table if exists Album_Comment;

drop table if exists `Label`;

drop table if exists Label_Group;

drop table if exists Music;

drop table if exists Music_Album;

drop table if exists Music_Comment;

drop table if exists PlayList;

drop table if exists Singer;

drop table if exists Singer_Album;

drop table if exists Singer_Band;

drop table if exists User;

/*==============================================================*/
/* Table: Album                                                 */
/*==============================================================*/
create table Album
(
   id                   int not null auto_increment,
   name                 varchar(20) not null,
   introduction         varchar(100),
   release_time         date,
   picture              varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: Album_Comment                                         */
/*==============================================================*/
create table Album_Comment
(
   id                   int not null auto_increment,
   uid                  int not null,
   aid                  int not null,
   comment              varchar(255) not null,
   primary key (id, uid, aid)
);

/*==============================================================*/
/* Table: `Label`                                               */
/*==============================================================*/
create table `Label`
(
   id                   int not null auto_increment,
   lid                  int not null,
   mid                  int not null,
   name                 varchar(10) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: Label_Group                                           */
/*==============================================================*/
create table Label_Group
(
   id                   int not null auto_increment,
   name                 varchar(4) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: Music                                                 */
/*==============================================================*/
create table Music
(
   id                   int not null auto_increment,
   name                 varchar(100) not null,
   lyrics               varchar(50),
   link                 varchar(50) not null,
   play_amount          bigint,
   download_amount      bigint,
   duration             time,
   primary key (id)
);

/*==============================================================*/
/* Table: Music_Album                                           */
/*==============================================================*/
create table Music_Album
(
   mid                  int not null,
   aid                  int not null,
   primary key (mid, aid)
);

/*==============================================================*/
/* Table: Music_Comment                                         */
/*==============================================================*/
create table Music_Comment
(
   id                   int not null auto_increment,
   uid                  int not null,
   mid                  int not null,
   comment              varchar(255) not null,
   primary key (id, uid, mid)
);

/*==============================================================*/
/* Table: PlayList                                              */
/*==============================================================*/
create table PlayList
(
   mid                  int not null,
   uid                  int not null,
   primary key (mid, uid)
);

/*==============================================================*/
/* Table: Singer                                                */
/*==============================================================*/
create table Singer
(
   id                   int not null auto_increment,
   name                 varchar(100) not null,
   gender               bool,
   lang                 varchar(8),
   picture              varchar(50),
   introduction         varchar(100),
   is_band              bool,
   primary key (id)
);

/*==============================================================*/
/* Table: Singer_Album                                          */
/*==============================================================*/
create table Singer_Album
(
   sid                  int not null,
   aid                  int not null,
   primary key (sid, aid)
);

/*==============================================================*/
/* Table: Singer_Band                                           */
/*==============================================================*/
create table Singer_Band
(
   sid                  int not null,
   bid                  int not null,
   primary key (sid, bid)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   password             varchar(32) not null,
   gender               bool,
   realname             varchar(10),
   country              varchar(10),
   province             varchar(10),
   city                 varchar(10),
   address              varchar(255),
   qq                   varchar(10),
   phone                varchar(11),
   email                varchar(20) not null,
   picture              varchar(50),
   privilege            varchar(10) not null,
   is_real_public       bool,
   primary key (id)
);

alter table Album_Comment add constraint FK_Album_AlbumComment foreign key (aid)
      references Album (id) on delete restrict on update restrict;

alter table Album_Comment add constraint FK_User_AlbumComment foreign key (uid)
      references User (id) on delete restrict on update restrict;

alter table `Label` add constraint FK_Label_LabelGroup foreign key (lid)
      references Label_Group (id) on delete restrict on update restrict;

alter table `Label` add constraint FK_Music_Label foreign key (mid)
      references Music (id) on delete restrict on update restrict;

alter table Music_Album add constraint FK_Music_Album foreign key (mid)
      references Music (id) on delete restrict on update restrict;

alter table Music_Album add constraint FK_Music_Album2 foreign key (aid)
      references Album (id) on delete restrict on update restrict;

alter table Music_Comment add constraint FK_Music_MusicComment foreign key (mid)
      references Music (id) on delete restrict on update restrict;

alter table Music_Comment add constraint FK_User_MusicComment foreign key (uid)
      references User (id) on delete restrict on update restrict;

alter table PlayList add constraint FK_PlayList foreign key (mid)
      references Music (id) on delete restrict on update restrict;

alter table PlayList add constraint FK_PlayList2 foreign key (uid)
      references User (id) on delete restrict on update restrict;

alter table Singer_Album add constraint FK_Singer_Album foreign key (sid)
      references Singer (id) on delete restrict on update restrict;

alter table Singer_Album add constraint FK_Singer_Album2 foreign key (aid)
      references Album (id) on delete restrict on update restrict;

alter table Singer_Band add constraint FK_Singer_Band foreign key (sid)
      references Singer (id) on delete restrict on update restrict;

alter table Singer_Band add constraint FK_Singer_Band2 foreign key (bid)
      references Singer (id) on delete restrict on update restrict;
