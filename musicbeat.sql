/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/12/30 15:26:25                          */
/*==============================================================*/


drop table if exists CD;

drop table if exists CD_Talks;

drop table if exists MUSIC;

drop table if exists Music_CD_Relationship;

drop table if exists Music_Talks;

drop table if exists SINGER;

drop table if exists Singer_CD_Relationship;

drop table if exists Singer_Music_Relationship;

drop table if exists Singer_Singer_Relationship;

drop table if exists USER;

drop table if exists User_Music_Relationship;

/*==============================================================*/
/* Table: CD                                                    */
/*==============================================================*/
create table CD
(
   CD_id                int not null,
   CD_name              varchar(100),
   CD_abstract          text,
   publish_time         date,
   CD_picture           longblob,
   primary key (CD_id)
);

/*==============================================================*/
/* Table: CD_Talks                                              */
/*==============================================================*/
create table CD_Talks
(
   user_id              int,
   CD_id                int,
   CD_comments          text
);

/*==============================================================*/
/* Table: MUSIC                                                 */
/*==============================================================*/
create table MUSIC
(
   music_id             int not null,
   music_name           varchar(100),
   lyrics               varchar(50),
   music_file           varchar(50),
   school               varchar(100),
   numberof_play        bigint,
   numberof_download    bigint,
   timeof_music         time,
   primary key (music_id)
);

/*==============================================================*/
/* Table: Music_CD_Relationship                                 */
/*==============================================================*/
create table Music_CD_Relationship
(
   music_id             int not null,
   CD_id                int not null,
   primary key (music_id, CD_id)
);

/*==============================================================*/
/* Table: Music_Talks                                           */
/*==============================================================*/
create table Music_Talks
(
   user_id              int,
   music_id             int,
   music_comments       text
);

/*==============================================================*/
/* Table: SINGER                                                */
/*==============================================================*/
create table SINGER
(
   singer_id            int not null,
   singer_name          varchar(100),
   singer_class         varchar(50),
   groupof              varchar(100),
   singer_picture       longblob,
   singer_abstract      text,
   primary key (singer_id)
);

/*==============================================================*/
/* Table: Singer_CD_Relationship                                */
/*==============================================================*/
create table Singer_CD_Relationship
(
   singer_id            int not null,
   CD_id                int not null,
   primary key (singer_id, CD_id)
);

/*==============================================================*/
/* Table: Singer_Music_Relationship                             */
/*==============================================================*/
create table Singer_Music_Relationship
(
   singer_id            int not null,
   music_id             int not null,
   primary key (singer_id, music_id)
);

/*==============================================================*/
/* Table: Singer_Singer_Relationship                            */
/*==============================================================*/
create table Singer_Singer_Relationship
(
   singer_id            int not null,
   SIN_singer_id        int not null,
   primary key (singer_id, SIN_singer_id)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   user_id              int not null,
   username             varchar(20),
   password             varchar(32),
   realname             varchar(10),
   country              varchar(10),
   province             varchar(10),
   city                 varchar(10),
   phone                varchar(11),
   email                varchar(20),
   privilege            varchar(10),
   publicrealinfo       bool,
   primary key (user_id)
);

/*==============================================================*/
/* Table: User_Music_Relationship                               */
/*==============================================================*/
create table User_Music_Relationship
(
   music_id             int not null,
   user_id              int not null,
   primary key (music_id, user_id)
);

alter table CD_Talks add constraint FK_CD_CDTalks_Relationship foreign key (CD_id)
      references CD (CD_id) on delete restrict on update restrict;

alter table CD_Talks add constraint FK_User_CDTalks_Relationship foreign key (user_id)
      references USER (user_id) on delete restrict on update restrict;

alter table Music_CD_Relationship add constraint FK_Music_CD_Relationship foreign key (music_id)
      references MUSIC (music_id) on delete restrict on update restrict;

alter table Music_CD_Relationship add constraint FK_Music_CD_Relationship2 foreign key (CD_id)
      references CD (CD_id) on delete restrict on update restrict;

alter table Music_Talks add constraint FK_Music_MusicTalks_Relationship foreign key (music_id)
      references MUSIC (music_id) on delete restrict on update restrict;

alter table Music_Talks add constraint FK_User_MusicTalks_Relationship foreign key (user_id)
      references USER (user_id) on delete restrict on update restrict;

alter table Singer_CD_Relationship add constraint FK_Singer_CD_Relationship foreign key (singer_id)
      references SINGER (singer_id) on delete restrict on update restrict;

alter table Singer_CD_Relationship add constraint FK_Singer_CD_Relationship2 foreign key (CD_id)
      references CD (CD_id) on delete restrict on update restrict;

alter table Singer_Music_Relationship add constraint FK_Singer_Music_Relationship foreign key (singer_id)
      references SINGER (singer_id) on delete restrict on update restrict;

alter table Singer_Music_Relationship add constraint FK_Singer_Music_Relationship2 foreign key (music_id)
      references MUSIC (music_id) on delete restrict on update restrict;

alter table Singer_Singer_Relationship add constraint FK_Singer_Singer_Relationship foreign key (singer_id)
      references SINGER (singer_id) on delete restrict on update restrict;

alter table Singer_Singer_Relationship add constraint FK_Singer_Singer_Relationship2 foreign key (SIN_singer_id)
      references SINGER (singer_id) on delete restrict on update restrict;

alter table User_Music_Relationship add constraint FK_User_Music_Relationship foreign key (music_id)
      references MUSIC (music_id) on delete restrict on update restrict;

alter table User_Music_Relationship add constraint FK_User_Music_Relationship2 foreign key (user_id)
      references USER (user_id) on delete restrict on update restrict;

