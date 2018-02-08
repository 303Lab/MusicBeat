# MusicBeat

[![license](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/303Lab/MusicBeat/blob/dev/LICENSE)
![npm](https://img.shields.io/badge/npm-v3.10.10-blue.svg)
![spring](https://img.shields.io/badge/spring-v4.3.6-orange.svg)
![maven](https://img.shields.io/badge/maven-v3.3.9-lightgrey.svg)
![mybatis](https://img.shields.io/badge/mybatis-v3.4.2-red.svg)
![spring-session](https://img.shields.io/badge/spring--session-v1.3.0-brightgreen.svg)
![tomcat](https://img.shields.io/badge/tomcat-v8.5.9-blue.svg)
![junit](https://img.shields.io/badge/junit-v4.12-orange.svg)
![mysql](https://img.shields.io/badge/mysql-v5.7.17-yellow.svg)
![redis](https://img.shields.io/badge/redis-v3.2.100-lightgrey.svg)
![aplayer](https://img.shields.io/badge/aplayer-v1.5.9-red.svg)
![dev](https://img.shields.io/badge/-dev-red.svg)

> A SSM Web Project for Engineering Practice Class. As the name "musicbeat", it's a music share web site.

## Install

```
$ run maven dependences
$ cd websrc & npm install & npm install –save-dev
```

## Usage

[1] Import to IDEA or Eclipse  
[2] Configure gulpfile.js  
[3] Complete email.properties.template & move to email.properties & same to jdbc.properties.template  
[4] Configure Spring, web.xml, Artifacts and tomcat server in IDEA. Then Add Jrebel to IDEA and run&debug it.

## Run in development  
For web
```
$ gulp browser
```
For backend
```
$ gulp
```

## Make a release

```
$ gulp release
```

## Thanks

- [APlayer](https://github.com/DIYgod/APlayer)

- [Mybatis-PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)

## LICENSE

[The Star And Thank Author License (SATA)](https://github.com/303Lab/MusicBeat/blob/dev/LICENSE)
