/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/1/13 ÐÇÆÚÎå 10:57:28                       */
/*==============================================================*/


drop table if exists Album;

drop table if exists Album_Comment;

drop table if exists Billboard;

drop table if exists Flow;

drop table if exists Label;

drop table if exists Label_Group;

drop table if exists Music;

drop table if exists Music_Album;

drop table if exists Music_Comment;

drop table if exists PlayList;

drop table if exists Singer;

drop table if exists Singer_Album;

drop table if exists Singer_Band;

drop table if exists Traffic;

drop table if exists User;

/*==============================================================*/
/* Table: Album                                                 */
/*==============================================================*/
create table Album
(
   id                   int not null auto_increment,
   name                 varchar(100) not null,
   introduction         text,
   release_time         date,
   picture              varchar(255),
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
   comment              text not null,
   primary key (id, uid, aid)
);

/*==============================================================*/
/* Table: Billboard                                             */
/*==============================================================*/
create table Billboard
(
   time                 date not null,
   mid                  int,
   download_amount      bigint,
   play_amount          bigint,
   primary key (time)
);

/*==============================================================*/
/* Table: Flow                                                  */
/*==============================================================*/
create table Flow
(
   time                 date not null,
   amount               float,
   primary key (time)
);

/*==============================================================*/
/* Table: Label                                               */
/*==============================================================*/
create table Label
(
   id                   int not null auto_increment,
   lid                  int not null,
   mid                  int not null,
   name                 varchar(32) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: Label_Group                                           */
/*==============================================================*/
create table Label_Group
(
   id                   int not null auto_increment,
   name                 varchar(32) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: Music                                                 */
/*==============================================================*/
create table Music
(
   id                   int not null auto_increment,
   name                 varchar(100) not null,
   lyrics               varchar(255),
   link                 varchar(255) not null,
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
   comment              text not null,
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
   lang                 varchar(50),
   picture              varchar(255),
   introduction         text,
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
/* Table: Traffic                                               */
/*==============================================================*/
create table Traffic
(
   id                   varchar(32) not null,
   url                  varchar(255) not null,
   seed                 varchar(20),
   step                 int not null,
   time                 datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   password             char(32) not null,
   gender               bool,
   realname             varchar(50),
   country              varchar(50),
   province             varchar(50),
   city                 varchar(50),
   address              text,
   qq                   varchar(12),
   phone                varchar(20),
   email                varchar(50) not null,
   picture              varchar(255),
   privilege            varchar(5) not null,
   is_real_public       bool,
   primary key (id)
);

alter table Album_Comment add constraint FK_Album_AlbumComment foreign key (aid)
      references Album (id) on delete cascade on update cascade;

alter table Album_Comment add constraint FK_User_AlbumComment foreign key (uid)
      references User (id) on delete cascade on update cascade;

alter table Billboard add constraint FK_Music_Billboard foreign key (mid)
      references Music (id) on delete cascade on update cascade;

alter table Label add constraint FK_Label_LabelGroup foreign key (lid)
      references Label_Group (id) on delete cascade on update cascade;

alter table Label add constraint FK_Music_Label foreign key (mid)
      references Music (id) on delete cascade on update cascade;

alter table Music_Album add constraint FK_Album_Music foreign key (aid)
      references Album (id) on delete cascade on update cascade;

alter table Music_Album add constraint FK_Music_Album foreign key (mid)
      references Music (id) on delete cascade on update cascade;

alter table Music_Comment add constraint FK_Music_MusicComment foreign key (mid)
      references Music (id) on delete cascade on update cascade;

alter table Music_Comment add constraint FK_User_MusicComment foreign key (uid)
      references User (id) on delete cascade on update cascade;

alter table PlayList add constraint FK_PlayList_Music foreign key (mid)
      references Music (id) on delete restrict on update cascade;

alter table PlayList add constraint FK_PlayList_User foreign key (uid)
      references User (id) on delete cascade on update cascade;

alter table Singer_Album add constraint FK_Album_Singer foreign key (aid)
      references Album (id) on delete cascade on update cascade;

alter table Singer_Album add constraint FK_Singer_Album foreign key (sid)
      references Singer (id) on delete cascade on update cascade;

alter table Singer_Band add constraint FK_Band_Singer foreign key (bid)
      references Singer (id) on delete cascade on update cascade;

alter table Singer_Band add constraint FK_Singer_Band foreign key (sid)
      references Singer (id) on delete cascade on update cascade;

