/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : musicbeat

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-27 00:10:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `introduction` text,
  `release_time` date DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', '意外', '旅行，意外的风景，意外的人。2013/10 人生本就是一场意外，纵横交错的际遇遍布着生活的每个角落。每天都在遇见不同的人，经历不同的风景，行走不同的轨迹。面对未知的生活，我们一直都在寻寻觅觅中快步疾行，很多人擦身而过，很多事过眼云烟。抓不住，放不下，在患得患失中我们不停地迷失、遗忘、错过。', '2013-10-08', 'music/23/1/1.jpg');
INSERT INTO `album` VALUES ('2', '初学者', '薛之谦《初学者》，重拾初心，勇往直前。在梦想丛林保持初生之勇，做变幻世界最后的初学者。在人生的道路上自愿当永远的初学者，2016年薛之谦首支硬派摇滚之作《初学者》。“我们的爱情到这刚刚好，剩不多也不少，还能忘掉”，卸下段子手的华丽戏服。薛之谦诚恳唱出分手恋人的勇敢与不舍，2016年薛之谦《初学者》 专辑伤情推荐第一抒情主打《刚刚好》。“人们把难言的爱都埋入土壤里，袖手旁观着别人尽力撇清自己”，耽溺与让人浮想联翩的情感暗涌，薛之谦展现成熟男人的内心风景，2016年薛之谦《初学者》 专辑隐情推荐第二抒情主打《我好像在哪见过你》', '2016-07-18', 'music/23/2/2.jpg');
INSERT INTO `album` VALUES ('3', '西界', 'JJ林俊杰西界第5张全新创作专辑，东方古典+南欧浪漫+美西灵魂+北非热情，06/29全亚洲盛大跨界发行。每个人心中都有西界，通往那个未知的自己在爱与恨之间，在黑与白之间，在善与恶之间。名曲曹操作词大师林秋离神来之笔创西界之说。罗比威廉斯&MR.Children&Glay都崇拜的日本艺术大师信藤先生“双J与鸟”概念之作让这张专辑视觉充满想象力。', '2007-06-29', 'music/24/3/3.jpg');
INSERT INTO `album` VALUES ('4', '她说 概念自选辑', '情歌似曾相识，能不能唱到她说的地久天长；新歌耳熟能详，有没有听出她说的语重心长。你，有多久没听她说？深情倾听，感动千万回响不断，金曲无冕王；温柔诉说，谱出天后至夯主打，情歌唱作王。金曲/情歌双冠王，JJ林俊杰，挑战蜕变，概念自选辑她说感动收录1王1后词曲连手动人新歌“她说”+10首自选经典女歌男唱，全新演绎；唯一收藏2010世界巡演震撼单曲“I Am\"+电玩磅礴主题曲“完美新世界”。', '2010-12-08', 'music/24/4/4.jpg');
INSERT INTO `album` VALUES ('5', '敷衍', '王菲第十张粤语大碟敷衍，10首王菲的感情迷津，10篇林夕的文火引渡。我几度梦过荒城里那日落秋山，梦醒叫了外卖西红柿炒饭。我走在每天必经的路，却发觉这只不过是条走惯了的迷途。我没能开心欢畅，也无法痛快感伤，于是生活变成敷衍，敷衍。日本摄影大师藤代冥砂首都跨国掌镜，据说最暗处也有光明，照不穿我也映得出你。', '2015-11-13', 'music/25/5/5.jpg');
INSERT INTO `album` VALUES ('6', '浮躁', '以《十万个为什么》-《胡思乱想》-《DI-DAR》缔造华语乐坛另类潮流的王菲在96年的国语专辑《浮躁》中彻底完成了根源摇滚与英式摇滚的结合与蜕变。专辑对于中文流行歌曲既定模式的颠覆，对专辑整体概念的坚持使之界碑意义明显，甫一推出，即受业界肯定，好评如潮。大碟以《无常》拉开序幕，没有前奏的编排，一开始便听到王菲的声线，唱着各样的自然场景。一个悠闲的画面，王菲却看到这一切美丽和洽之后那世事的无常。一切安好的九月天，只是缺少了烦恼，却令王菲心浮气躁，胡乱想象，情绪分列而不安，整个人冷静不下来，整张唱片的十首作品，歌者都是处于这种不安的情绪状态里，而且越后部分的作品，所展现的情绪越不稳定。', '1996-08-01', 'music/25/6/6.jpg');
INSERT INTO `album` VALUES ('7', '欧若拉', '港版加收韩剧大长今片头曲“娃娃”中文版单曲。欧若拉，国语，2004年12月1号，福茂唱片。听见声音的光，全亚洲最受瞩目的新人张韶涵。创造出童话式、游戏化声音语言的张韶涵，她的“寓言”成功，果然在全亚洲得到无数专业奖项及销量的肯定，俨然已成为歌坛最受瞩目的新人。成为全亚洲最受瞩目的新声音，张韶涵在第二张国语专辑，不仅是全亚洲同步发行，在尚未发货前海外地区就已预购50万张的销量，可见大家对张韶涵的声音深具信心，期待她的新生隐能为亚洲歌坛带来新刺激。新专辑结合了陈伟、林隆璇、陈俊廷、郭建良、马玉芬、陈韦伶四王二后制作人，融合了soul、funk、world music、band-sound、抒情等多种曲风，全力打造张韶涵声音的表演。', '2004-12-01', 'music/26/7/7.jpg');
INSERT INTO `album` VALUES ('8', '第5季', '暌违一年8个月的全新音乐，休息不是空白也无人可以取代。10首全新主打歌曲+3首全新MV bonus DVD，张韶涵2009年女神复活，全新个人大碟震撼登场。2007年12月在中以《Ang 5.0》专辑跟乐迷见面后，张韶涵选择在音乐路上休息了1年8个月，沉淀之后找回自己，现在她养精蓄锐重返歌坛，从《白白的》开始，唱出了自己在一个不存在的《第5季》寻回的那一个亮点，无论是以前没尝试过的音乐曲风，或者是改变她最擅长的穿透高音，这次唱腔也带给大家耳目一新，属于中低音域的《真诚》。而百变造型仍然是大家喜爱张韶涵其中一个面向，这一次《第5季》无论是专辑封面或是MV拍摄，张韶涵成功挑战自己的造型极限，将带领大家走入一个白色谜样的神秘季节氛围。', '2009-09-25', 'music/26/8/8.jpg');
INSERT INTO `album` VALUES ('9', '你不能爱我', '2011年，以一首《明天你好》感动中国的他们，这一次决定舍弃驾轻就熟的成长主题，很认真的要写一写自己或身边人曾经经历的感情生活。牛奶咖啡全新伤感催泪原创《你不能爱我》，带你直面爱情的遗憾与无奈。关怀。即使描写伤痛，奶咖的音乐依然是温暖的。人生的旅途中，总要走一些陌生的路，看一些陌生的风景，经历一些陌生的人。一路上有快乐、有妥协、有伤痛、也有失去，或许还有一些东西说不清道不明。这些或风平浪静，或痛彻心扉的片段，在若干年后都将沉淀于心底。不管曾为谁流泪，为谁欢笑，为谁落寞，那些人和事都将成为生命中最美好的追忆。勇敢的旅客，告别旧时光，请带着回忆继续倔强前行，放开过去，是为了成为更好的人，这一切其实并不感伤。', '2012-11-20', 'music/27/9/9.jpg');
INSERT INTO `album` VALUES ('10', '越长大越孤单', '时隔3年，牛奶咖啡发表第二张创作专辑《越长大越孤单》，褪去首张专辑的青涩外衣，牛奶咖啡以真挚感性的一面重新面对听众，将成长过程中内心世界的细腻感受完整呈现在新专辑的全部10首曲目中，与逝去的懵懂青春挥手作别。这是一张关于成长过程中的思考、友情、迷失、沉默、遗忘以及失去的唱片，也许其中依旧伴有成长过程中无法避免的言不由衷，但是关于成长的归宿，你我又能寻找到怎样完美的答案呢？ 转身望去，慢慢长大的自己，身边已不再像以往那样容易找到结伴而行的朋友，“越长大越孤单”是来自内心最无奈的感叹，如今牛奶咖啡将它变作美好的音符，只愿与拥有同样心情的你产生如呼吸般的细微共鸣，在漫长的成长旅途中，让我们一起欣赏那些无法逃避的孤独的风景吧。', '2008-03-18', 'music/27/10/10.jpg');
INSERT INTO `album` VALUES ('11', '朋友难当', '这张众望所归的歌坛年度大片有着非同一般的期待值。羽泉组合惊人的宣布将展开一场成军八年来公开的“决战”，同时推出2首代表各自风格的主打歌曲《翅膀》和《朋友难当》。在挑选这张最新大碟的主打曲时，两位成员选择了风格完全迥异的作品，但是当大家坐下来讨论的时候，却不约而同地发现这些作品的感觉让人不由自主地回到了两人最初合作的状态，那时两人尚未磨合，硬朗与柔情，不同的音乐风格缔造了《最美》的流行神话。之后的几张唱片羽泉很显然在极尽所能的融合，但是8年后他们重新回到了最简单的时刻。在音乐的世界里，简单到复杂，经历过一切的繁复，再回归简单是一个永远的定理。“决战”并非炒作，而是两种极致音乐的比较。', '2006-12-01', 'music/28/11/11.jpg');
INSERT INTO `album` VALUES ('12', '每个人心中都有一个羽泉', '11年，从大男孩到大男人的趣味人生体验11年，从现实生活到音乐生活的流金岁月11年，从首席组合到国民组合的乐坛恒星，作为中国流行乐坛公认的首席组合，今天的羽泉经过11年的音乐努力，已经成为现时流行音乐的标志性符号。经过三年的精心准备，羽泉第七张原创大碟《每个人心中都有一个羽泉》在盛夏流火的季节登陆乐坛，这张从企划到制作、从MV平面照到唱片设计 两人全程大包大揽的最新大碟中，羽泉以充满孩子气的音乐企图心开始了自己出道11年的新旅程。作为一只红透乐坛的创作劲旅，全新唱片将以“很羽泉”的方式展现10年之后的羽泉如何看待自身、并以第三方的眼光诠释出世人心目中或想象中的羽泉，在本体和他体的交融对流的方程式里，每个人心中都有一个羽泉的无限可能性得以拓展与延伸。', '2009-07-20', 'music/28/12/12.jpg');
INSERT INTO `album` VALUES ('13', 'Believe Acoustic', 'Believe Acoustic是人气小天王JustinBieber2012录音室专辑Believe后发行的不插电新专辑，这张专辑是比伯自《My World Acoustic》后的第2张不插电专辑。新专辑将收录比伯为前女友赛琳娜·戈麦斯（Selena Gomez）创作的作品。此专辑原声作品中不光包括Believe中Boyfriend,As Long As You Love Me，Beauty and a Beat等大热作品，还加入了3首全新的作品Yellow Raincoat，I Would，Nothing Like Us。', '2013-01-29', 'music/29/13/13.jpg');
INSERT INTO `album` VALUES ('14', 'My World', '2009 debut from the young multi-talented singer, musician and Usher\'s teen prot‚g‚. An old soul is the last thing you would expect to find inside Justin Bieber. But all it takes is one listen to the 15-year-old Soul-singing phenomenon to realize that he is light-years ahead of his manufactured Pop peers. The album features production from The-Dream and Tricky Stewart. The first single, \'One Time,\' produced by Tricky, is about one of Justin\'s favorite topics, puppy love. Usher joins Justin on \'First Dance,\' where the two share verses on a song that Bieber describes as \'\'a slow groovy song that people can dance to.\'\' On the Midi-Mafia-produced \'Down To Earth,\' Justin digs deep to talk about growing up. \'Bigger\' finds the teenage singer maturing at a steady rate while motivating his listeners to strive for their goals.', '2010-01-18', 'music/29/14/14.jpg');
INSERT INTO `album` VALUES ('15', 'Trespassing', 'Adam Lambert 出道以来的第二张专辑，Adam 追求完美，首首参与创作，经过一年多的精心打造以及和诸多Ryan Tedder, Claude Kelly , Bonnie McKeee, Benny Blanco, Nile Rodgers, Greg Wells, Pharrell Williams，Dr.Luke等当红大牌音乐人的合作，新专辑将于2012年5月15日发行。', '2012-07-09', 'music/30/15/15.jpg');
INSERT INTO `album` VALUES ('16', 'Glam Nation Live', '本专辑收录了Adam Lambert于2010年进行的Glam Nation Live Tour中演唱会视频与音频，演唱曲目大多来自于他的首张个人专辑For Your Enterainment。原本并没有此次巡演DVD的发行计划，却在粉丝的一再要求下决定出版！因而演唱会的后期剪辑并非最佳。但Adam的优异的现场演唱功力使得没有图像的CD版本也成为绝不可错过的Live专辑。3月22日美国发行，3月18号澳大利亚提前发行！', '2011-03-21', 'music/30/16/16.jpg');
INSERT INTO `album` VALUES ('17', 'Shakira', '拉丁天后夏奇拉Shakira暌违5年，终于再推出全新英语同名专辑《Shakira》！去年才刚生下爱子Milan的夏奇拉产后神速恢复火辣身材，首支单曲力邀蕾哈娜合作演唱《Can\'t Remember to Forget You》，并首度合体拍摄MV，与蕾哈娜火力全开互尬性感，除了大秀曼妙舞姿，也同时挑战吉他狂飙和打鼓等才艺。夏奇拉说这次的专辑有一点点摇滚、一点点的民谣、一点点的雷鬼还有招牌的舞曲，算一张很不一样的融合和尝试。', '2014-03-21', 'music/31/17/17.jpg');
INSERT INTO `album` VALUES ('18', 'Oral Fixation Vol.2', '四年来的首张英文专辑Oral Fixation 2与相隔5个月之前所发行的“Fijacion Oral Vol.1\"如同异卵双胞胎作品般，虽然是同一时期的创作，却又个别独立、以不同的外貌个性来展现其创造者-夏奇拉的优异创作才华、宽广的音乐触角，并传达她个人对爱情、社会、政治甚而信仰等方面的体验见解与思维。专辑中所收录的精湛作品包括了攻击性十足、令人难以抵抗的首支单曲【Don\'t Bother】，邀来拉丁吉他之神Carlos Santana跨刀助阵演出、转折多变的吉他旋律更添一份感伤的[illegal]，极具深度自省而动人的[Dreams For Plans]以及邀来另一位拉丁音乐界当红的摇滚男歌手Gestauo Cerati力挺献声、韵味十足的[The Day And The Time]，以强烈的拉丁鼓声揭开序幕、节奏鲜明令人振奋不已的[Animal City]等完美展现夏奇拉时而强势宣泄、时而压抑内敛、时而温柔甜美、时而高亢飞扬，收放自如的多变嗓音。', '2006-06-19', 'music/31/18/18.jpg');
INSERT INTO `album` VALUES ('19', 'Never Gone', 'Backstreet Boys继出Black&Blue之后的五年，专辑Never Gone终于问世。等了好久，终于还是等到他们回来。虽然风格与以往有些不同，但依旧是很成功的一张专辑。从Quit Playing Games开始，BSB就一直陪伴在我们身边。AJ，Brain,Howie-D,Nick,Kevin，他们无懈可击的和声，他们天衣无缝的配合，他们的团队精神，他们的一切都是歌迷疯狂的理由。', '2005-11-15', 'music/32/19/19.jpg');
INSERT INTO `album` VALUES ('20', 'Black & Blue', '这张《Black & Blue》的制作人阵容十分有看头，除了老搭档Max Martin (也曾制作´N Sync的新专辑)外，还邀来金牌制作人Babyface以及知名R&B制作人Rodney Jerkins联手打造，因此呈现出多元化的曲风，包括流行、快节奏舞曲、慢板抒情、节奏蓝调风...等等。开场曲“The Call”从一串电话铃声以及强拍的拉丁旋律开始，BSB唱出了男人使坏的心态，和曲目三“Get Another Boyfriend”一样都是属于节奏强烈的Max Martin式作品；接着来到首打单曲“Shape Of My Heart”，副歌部分朗朗上口，不做单曲发售光靠着电台播歌率就让这首歌站上Billboard Hot 100的Top 10；而洋溢Babyface风格的节奏蓝调抒情曲“Time”、Timmy Allan制作的“I Promise You”以及“Yes I Will”则是深情款款的情歌佳作。', '2015-11-13', 'music/32/20/20.jpg');
INSERT INTO `album` VALUES ('21', 'As Time Goes By', '这张《As Time Goes By》就是由Richard重新混音，将10多首The Carpenters在电视或录音室中录好而从未以唱片形式推出的歌曲收入其中。除了重唱The Beatles的“Nowhere Man”，Mamas And Pauas的“Califonia Dreaming”,大多是The Carpenters在电视上演唱的金曲片段联唱。熟悉的声音和熟悉的旋律，以不同的方式一遍遍地在耳边回响。因为它是The Carpenters，才让我们平添一份亲切和适意。', '2003-02-03', 'music/33/21/21.jpg');
INSERT INTO `album` VALUES ('22', 'Lovelines', '环球集团从2010年初开始将卡朋特兄妹乐团的一系列专辑重新翻刻再版，而且以超值的价格应市，受到乐迷普遍的关注。这款《Lovelines》原本是卡朋特兄妹乐团于1989年由A&M唱片公司根据保留的母带制作出版的专辑作品，收录《当我坠入爱河》、《就像昨晚那样亲吻我》等12首金曲，是该乐团的代表作之一。', '2009-07-14', 'music/33/22/22.jpg');
INSERT INTO `album` VALUES ('23', 'Ways', '岸部真明个人第8张创作专辑。作为日本指弹的佼佼者，这张专辑可听性极高。与此同时，这张专辑的吉他音色被调试的非常好。专辑由岸部真明自己的厂牌M.K MUSIC发行。', '2013-05-09', 'music/49/23/23.jpg');
INSERT INTO `album` VALUES ('24', '群像の星', '歌は星である。空に輝き続ける。\r\nそしてまた歌は石ころのように街に転がり、人の心の中にも小さな花のように咲き続ける。\r\n玉置浩二がいま、彼の心に宿る数々の群像の星たちを歌い綴る。\r\n同じ時代を共有してきたアーティストの名曲を歌うことによって、孤高の位置に存在し続ける玉置浩二は歌に対する敬意と愛情を表明したのである。\r\n選んだ歌に対する想いをいずれ彼は静かに語るだろう。すべての曲に彼の想いがある。それらはアルバムの中に書き綴られるだろう。', '2014-11-19', 'music/50/24/24.jpg');
INSERT INTO `album` VALUES ('25', 'ワインレッドの心', '1999年2月にBMGファンハウスより発表されたセルフ･カヴァー･アルバム｡｢ワインレッドの心｣｢夏の終わりのハーモニー｣｢ゆびきり｣｢あの頃へ｣他､全13曲を収録｡', '1999-02-24', 'music/50/25/25.jpg');
INSERT INTO `album` VALUES ('26', 'LIVE CORE LIMITED VERSION YUTAKA OZAKI IN TOKYO DOME', '1988年9月12日に東京ドームで行われた尾崎豊のライブの完全版!! 幻の東京ドームライブ映像が奇跡の復活! 尾崎豊、最初で最後の東京ドームライブがノーカット完全版として、今甦る!! 「LIVE CORE」には収録されなかった音源含め当日ライブを行った全26曲を完全収録。映像もすべて佐藤輝監督により再編集し、しかもマルチレコーディングされていた音源を須藤晃氏のもとで今回', '2013-11-27', 'music/51/26/26.jpg');
INSERT INTO `album` VALUES ('27', 'I LOVE YOU', '《I love you》是尾崎豊作词作曲并演唱的歌曲。', '2001-09-12', 'music/51/27/27.jpg');
INSERT INTO `album` VALUES ('28', 'あの日 あの時', '小田和正初の3枚組ALL TIME BEST ALBUM 日本人に長き渡り親しまれ、J-POPシーンのトップとしてそれぞれの時代を駆け抜け数々の記録を打ち立ててきた小田和正。1969年オフコースを結成し、翌70年プロとして音楽活動を開始、「さよなら」「言葉にできない」などのヒット曲を発表、今作にはオフコース時代のセルフカバー作品に手を加え多数収録。89年2月オフコースを解散後、ソロアーティスト活動を再開。', '2016-04-20', 'music/52/28/28.jpg');
INSERT INTO `album` VALUES ('29', '自己ベスト', '许多人不知道身兼歌手、制作人、导演等多重身分的知性艺人小田和正，其实是日本早稻田大学理工学部建筑科的硕士。许多哈日族的启蒙日剧《东京爱情故事》的主题曲，主唱人正是小田和正。他最近以精选辑《超越自我最精选》，再度登上公信榜冠军宝座，并且打破井上阳水最年长冠军纪录，小田和正以54岁又8个月的年龄，缔造了公信榜榜首最年长歌手的纪录。', '2002-04-24', 'music/52/29/29.jpg');
INSERT INTO `album` VALUES ('30', 'COUP D\'ETAT [+ ONE OF A KIND & HEARTBREAKER]', '2013年最新作『COUP D’ETAT (クーデター)』をはじめ、2012年ミニアルバム『ONE OF A KIND (ワン オブ ア カインド)』、そして2009年ソロデビューアルバム『HEARTBREAKER (ハートブレイカー)』というこれまでのソロ作品全てを網羅した、', '2013-11-27', 'music/37/30/30.jpg');
INSERT INTO `album` VALUES ('31', 'Hangover', '《HANGOVER》是与《江南STYLE》及《GENTLEMAN》风格有所不同的嘻哈风音乐，将给众多歌迷展现鸟叔新的一面。并且，有世界著名嘻哈歌手Snoop Dogg的助力，鸟叔(PSY)向HIP-HOP界下的挑战书更有力。鸟叔(PSY)计划首先公开新曲，并于今年夏天发表主打曲。', '2014-06-09', 'music/36/31/31.jpg');
INSERT INTO `album` VALUES ('32', 'Gentleman', 'YG公司原本计划在12日举行的PSY个人演唱会上公布《gentleman》，并于13日通过itunes向全球发布《gentleman》。不过因为各国粉丝都非常关注《gentleman》，YG公司最终决定在12日0点通过各大音乐网站以及itunes同时在韩国和世界119个国家公布《gentleman》。', '2013-04-12', 'music/36/32/32.jpg');
INSERT INTO `album` VALUES ('33', '克拉恋人 电视原声带', 'Rain用他如磁石般吸引人的歌声，诠释出电视剧《克拉恋人》的精髓——爱情能被钻石比喻，但不能被钻石丈量。不爱的时候，多少克拉都得不到爱情，但当爱上的那一刻起，一克拉就已经足够。', '2015-07-13', 'music/35/33/33.jpg');
INSERT INTO `album` VALUES ('34', 'Rain Effect', 'Rain正规六辑《Rain Effect》Repackage版本。该版本专辑以新歌《我爱你》作为主打歌，在雄壮的管弦乐背景下，加上Rain赋有情感的演唱，表达了对心爱之人的告白。', '2014-02-07', 'music/35/34/34.jpg');
INSERT INTO `album` VALUES ('35', '陪我一起做梦', '有一种声音，柔情似水直抵你内心最深的悸动，有一种声音，高亢缠绵搅动你情感的涟漪，有一种声音，沧桑缱绻湿润你眼角最远的思念，有一种声音，没有开始也不曾结束，有的只是起伏和悸动，在你的心间百转千回，这样炽烈的歌声，唯属一人，他的名字叫黄致列。', '2016-08-03', 'music/34/35/35.jpg');
INSERT INTO `album` VALUES ('36', '没有你不能活(Without You)', '与2016年温暖和煦的春天一同到来的还有蕴含黄致列真心的特别单曲《 너 없이 못살아 (Without You) 》向亲爱的粉丝传达温暖的问候。', '2016-04-26', 'music/34/36/36.jpg');
INSERT INTO `album` VALUES ('37', 'We are the QUEENS', '滨崎步代言手游《女王的纷争 Clash of Queens》宣传视频已于9月17日开播，而作为BGM的新曲《We are the QUEENS》于9月30日开始配信。', '2016-09-30', 'music/53/37/37.jpg');
INSERT INTO `album` VALUES ('38', 'm(a)de in Japan', '『A ONE』『sixxxxxx』と2作のアルバム、全国アリーナツアー、12年ぶりとなるファンクラブツアーの開催、『A BEST』15周年記念盤のリリースとアクティヴに攻めまくった浜崎あゆみ、早くもニューアルバムのリリースが決定! 今作収録曲は、5/14から開催され全国で12万人を動員するアリーナツアーで、リリースに先駆け、数々の新曲が披露される予定。                             今作は、シングル楽曲を一切含まず、新たに書き下ろされた新曲の数々で構成され、ayuの深層を抉るような剥き出しの感情が支配するダークでヘヴィーな新曲が多数収録。リスナーと1対1で向き合うような重厚な世界観をもったアルバムとなっている。', '2016-06-29', 'music/53/38/38.jpg');
INSERT INTO `album` VALUES ('39', 'A COMPLETE ~ALL SINGLES~', '滨崎步纪念出道10周年，推出超豪华单曲精选辑！从出道单曲「poker face」，到最新单曲「Mirrorcle World」，完整收录横跨J-POP历史10年间的43首人气单曲之超级单曲精选辑。', '2008-09-10', 'music/53/39/39.jpg');
INSERT INTO `album` VALUES ('40', 'SAWAGE☆LIFE', '7月30日（土）からのアニメ「名探偵コナン」エンディングテーマに新曲「SAWAGE☆LIFE」が起用され、同日より配信スタートされることが決定したのだ。倉木麻衣の「名探偵コナン」エンディング曲担当は、2014年秋からオンエアとなった「無敵なハート」以来約1年半振りで、テーマソングの起用はこれで全19曲目となり、番組最多コラボレーション記録を更新することになる。', '2016-07-30', 'music/54/40/40.jpg');
INSERT INTO `album` VALUES ('41', 'MAI KURAKI BEST 151A -LOVE & HOPE-', '仓木麻衣 15周年YEAR BEST ALBUM发表决定!! MAI KURAKI BEST 151A(イチゴイチエ)-LOVE & HOPE- 精选被冠以这样的题目,不仅有着「想要珍惜一期一会」的意义,同时也注入了「15周年来对每一个人的感谢」的心情。封面更以「delicious way」的封面,以如今的形象再现。', '2014-11-12', 'music/54/41/41.jpg');
INSERT INTO `album` VALUES ('42', 'First Love', '《First Love》是日本女歌手宇多田光出道专辑,于1999年3月10日发行。该专辑是日本史上销量最高专辑。据Oricon公信榜统计,当年在日本国内销量突破765万张,并停留在榜上达85星期之久。RIAJ对其之正式认证为八百万专辑(相当于32白金)。本作于台湾卖出超过50万张,是台湾史上销量最高东洋专辑,也是香港史上销量最高东洋专辑。《First Love》同时也是全亚洲销量最高的专辑,全球销量总计超过一千万。', '2014-03-10', 'music/55/42/42.jpg');
INSERT INTO `album` VALUES ('43', 'Evangelion: 1.01 You are (not)alone[Movie OST]', '福音战士新剧场版中的各项歌曲', '2008-05-21', 'music/55/43/43.jpg');
INSERT INTO `album` VALUES ('44', 'Christmas Wish', '安室奈美恵が出演するセブン-イレブンのクリスマスキャンペーン「Magical Christmas」のCMが、明日11月10日（木）より放送される。', '2016-12-21', 'music/56/44/44.jpg');
INSERT INTO `album` VALUES ('45', 'DearDiary/Fighter', '安室奈美惠推出全新双A面单曲《Dear Diary / Fighter》！新曲《Dear Diary》、《Fighter》分别为电影《死亡笔记本:决战新世界》之主题曲&剧中曲。电影主题曲《Dear Diary》率直地描写了爱与信念的力量，能让世界充满光明，是一首壮阔的抒情歌。剧中曲《Fighter》则是一首节奏强烈的舞曲，描写如同“战士”一般，对于所爱之人的执念，永不会被击倒 。', '2016-10-26', 'music/56/45/45.jpg');
INSERT INTO `album` VALUES ('46', 'Hero', '2016年“NHKリオデジャネイロオリンピック・パラリンピック放送テーマソング”「Hero」を収録したシングル!誰にでもいる“自分だけのヒーロー”、いつかは自分も“誰かのヒーロー”になれるようにと、明日への希望や勇気を与えてくれる一曲。', '2016-07-27', 'music/56/46/46.jpg');
INSERT INTO `album` VALUES ('47', '角度', '蔡妍全新华语单曲角度，2016年夏天给你不同角度。 第二波：全心主打、全意推荐--角度view of point\r\n请别站在你的角度看我,因為那不并是全部的我,只是你眼中看见一小部分的我,真正整的我 ,必须你全心全意/用心才能看得到。', '2016-08-01', 'music/38/47/47.jpg');
INSERT INTO `album` VALUES ('48', '事过境迁', '蔡妍 CHAE YEON 韩国性感舞曲女王化身?成为现代都会感性女伶  今年夏天最心酸动人华语单曲事过境迁 给你全新感动的 蔡妍  第一波  首发主打   深情推荐 事过境迁Overtaken by events 看见音乐（北京）有限公司发行', '2016-07-22', 'music/38/48/48.jpg');
INSERT INTO `album` VALUES ('49', '안봐도 비디오（看透）', '时隔五年，性感女皇蔡妍回归歌坛。首波主打歌《看透》节奏紧张又不乏欢快感，编曲中加入风格强烈的铜管乐器，复古气质十足，赋予了蔡妍全新的音乐色彩，而蔡妍魅力十足的声音，也让粉丝们大饱耳福。《看透》以“不靠谱渣男”、“出轨”等接地气的热点话题为中心，将一个面对出轨男友而心情矛盾的女生心事演绎得淋漓尽致。', '2015-06-26', 'music/38/49/49.jpg');
INSERT INTO `album` VALUES ('50', '로맨스가 필요해3 OST Part.1', '李孝利为tvN月火新剧《需要浪漫3》献唱OST《Don\'t Cry》。李孝利词曲创作，李尚顺编曲并吉他伴奏，夫妇两人结婚后的首个作品，MV以济州岛两人的新家为背景拍摄。歌曲作为女主人公申珠妍(金素妍 饰)的主题曲，描述痛苦心境的同时予以温暖的慰藉。', '2014-01-14', 'music/39/50/50.jpg');
INSERT INTO `album` VALUES ('51', 'Monochrome', '有“国民妖精”之称的韩国女歌手李孝利暌违三年发行的最新专辑《Monochrome》,封面大玩华丽的复古形象,收入16首歌曲,先行释出的「Miss Korea」已横扫各大流行榜冠军,复古的旋律配上她亲自谱写的歌词,为时下女性打气。这次专辑一共收录了16首歌,还请来了饶舌歌手 Beenzino 、 Honey G 的朴智勇以及搞笑女艺人安英美一同助阵。最特别的是在第一首歌《Holly Jolly Bus》中,李孝利的爱犬顺心也有帮忙。', '2013-05-21', 'music/39/51/51.jpg');
INSERT INTO `album` VALUES ('52', 'MY COLOR', '泫雅为丰田卡罗拉演唱汽车广告曲《My Color》。', '2013-03-11', 'music/40/52/52.jpg');
INSERT INTO `album` VALUES ('53', '过的好吗', '音源女王尹美莱与新人女歌手Punch合作推出新曲《잘 지내고 있니(过得还好吧)》，音源于1月13日0时(韩国时间)正式公开。尹美莱此次为应援后辈与其进行合作，Punch虽未正式出道，但是曾通过演唱《没关系是爱情啊》的OST《잠 못드는 밤 (不眠之夜)》和《Who Are You-学校2015》OST《바람에 날려(随风飞扬)》受到大众的关注。', '2016-01-13', 'music/41/53/53.jpg');
INSERT INTO `album` VALUES ('54', '후아유 - 학교 2015 OST Part 3', '尹美莱为KBS《Who Are You-学校2015》演唱的OST Part.3《의 얘길 들어줄게(聆听你的话)》于今日公开！歌曲以钢琴和管弦乐器相结合，R&B的节奏以及尹未来的独特感性嗓音，安慰那些被孤立和被忽视而陷入辛苦状况内心孤独的人们。', '2015-05-11', 'music/41/54/54.jpg');
INSERT INTO `album` VALUES ('55', '괜찮아 사랑이야 OST Part.6', '‘大韩民国最棒的女性歌手’尹美莱‘, 没关系是爱情啊OST 闪电合流’。soul以饱满的声音和殷切的感情而很突出的‘大韩民国最棒的女性歌手’尹美莱以’我爱你’这首歌为电视剧’没关系是爱情啊 OST’而献唱。', '2014-08-27', 'music/41/55/55.jpg');
INSERT INTO `album` VALUES ('56', '暁の君に', '日曜ドラマ 「キャリア～掟破りの警察署長～」(玉木宏主演)主題歌に決定。 前作「beautiful days」に続くドラマ主題歌となります！ 先日発売した7thアルバム「縁」も好調、まだまだ10周年イヤーの勢いは止まりません！', '2016-11-16', 'music/46/56/56.jpg');
INSERT INTO `album` VALUES ('57', 'まるわかり!? メガミックス3 〜5ReeeeN〜', 'ヒットチューンとアルバム先聴きの二部構成で圧倒するミックスアルバム！', '2016-08-24', 'music/46/57/57.jpg');
INSERT INTO `album` VALUES ('58', 'Mighty Long Fall/Decision', 'OOR双A面单曲『Mighty Long Fall / Decision』收录电影《浪客剑心 京都大火篇》主题曲『Mighty Long Fall』与纪录片《FOOL COOL ROCK! ONE OK ROCK DOCUMENTARY FILM》的主题曲『Decision』外加新曲『Pieces of Me』共计3首。', '2014-07-30', 'music/47/58/58.jpg');
INSERT INTO `album` VALUES ('59', 'Deeper Deeper / Nothing Helps', '来自ONE OK ROCK的单曲Deeper Deeper/Nothing Helps 其中第二首Nothing Helps作为Devil May Cry最新作的主题曲 相信一定能打动你的心', '2013-01-09', 'music/47/59/59.jpg');
INSERT INTO `album` VALUES ('60', 'treasure of the heart~キミとボクの奇迹~', 'ZONE将于6月6日发行她们睽违七年之久的新单曲《treasure of the heart ～キミとボクの奇跡～》，虽然现在只剩下两名成员，但她们会继续活动下去。', '2012-06-06', 'music/48/60/60.jpg');
INSERT INTO `album` VALUES ('61', 'glory colors 〜风のトビラ〜', 'glory colors 〜風のトビラ〜（グローリー・カラーズ・かぜのとびら）は、2004年にリリースされたZONEの14枚目のシングル。初回仕様ではステッカー（3種類ランダム）が封入されている。 この曲がテーマ曲となった第86回全国高等学校野球選手権大会ではZONEの地元の北海道の駒大苫小牧高校が優勝し、深紅の大優勝旗が初めて津軽海峡を越えた。', '2004-08-04', 'music/48/61/61.jpg');
INSERT INTO `album` VALUES ('62', 'RUNWAY', 'カリスマ性溢れる“セクシー”で魅了し続けるAOA。2016年の活躍がまさに集約された待望の日本セカンド・アルバムが遂に完成!!小室哲哉氏自らがAOAのためにプロデュース、リメイクした「WOW WAR TONIGHT~時には起こせよムーヴメント」のカヴァーを収録!更に、日本オリジナルの楽曲も!', '2016-11-30', 'music/45/62/62.jpg');
INSERT INTO `album` VALUES ('63', 'Ace of Angels', '今作は日本のみでのリリースとなっており、日本オリジナル・ナンバー3曲も新たに収録。今作のリード曲となる「Oh BOY」は、洗練されたビートにメンバーの色気溢れる歌声を乗せた、これまでのトラックとは一線を画すAOAサウンドに仕上がっている。', '2015-10-14', 'music/45/63/63.jpg');
INSERT INTO `album` VALUES ('64', 'Remember', '“歌谣界的变色龙”T-ara于11月9日发行第12张迷你专辑《REMEMBER》，时隔1年3个月感性回归。 主打曲《TIAMO》由韩国知名作曲团队二段横踢制作，与T-ara代表性的舞曲风格不同，是具有柔和清凉感的中板节奏抒情曲，充满爱意的旋律与歌词，最大化表现出“TIAMO(我爱你)”的意义。', '2016-11-19', 'music/42/64/64.jpg');
INSERT INTO `album` VALUES ('65', 'So Good', '“歌谣界的变色龙”T-ara时隔一年以完整体出击，携第11张迷你专辑《So Good》强势回归。', '2015-08-04', 'music/42/65/65.jpg');
INSERT INTO `album` VALUES ('66', '2016 BIGBANG WORLD TOUR [MADE] FINAL IN SEOUL LIVE', '从2015年4月,以首尔场为起点的BIGBANG WORLD TOUR [MADE]\r\n历经13个国家,32个城市后,终于再次回归同为起点的首尔作为终结点。', '2016-06-01', 'music/43/66/66.jpg');
INSERT INTO `album` VALUES ('67', 'MADE SERIES', 'BIGBANG全新日本专辑《MADE SERIES》于2月3日正式发行！', '2016-02-03', 'music/43/67/67.jpg');
INSERT INTO `album` VALUES ('68', 'Coming Over', 'EXO、待望の日本第2弾シングルがリリース。今作は\"完全日本オリジナル楽曲\"を3曲収録した超豪華シングル!アップリフティングでFUNKサウンドが全開なタイトル・ソング\"Coming Over\"ほか、今作に収録される全3曲はいずれも中毒性のあるEXOらしさ満点のアッパー・トラック揃い!', '2016-12-07', 'music/44/68/68.jpg');
INSERT INTO `album` VALUES ('69', 'Love Me Right ～romantic universe～', '2012年のデビュー以来、韓国・中国のみならずアジア全域にて熱狂を巻き起こし、2013年には韓国のあらゆる音楽大賞を総ナメにするなど、今アジアで最も注目されているボーイズ・グループ “EXO”が日本デビュー・シングルをリリース!日本デビュー曲「Love Me Right ~romantic universe~」は、大好きな人とのトキメキを表現したPOPで壮快なダンス・チューン!デビューよりたくさんの声援を贈り続けてくれるファンへ感謝の気持ちを伝えるために制作された1曲!', '2015-11-04', 'music/44/69/69.jpg');
INSERT INTO `album` VALUES ('70', 'Everybody Dance Now', 'Everybody Dance Now is the third album from Crazy Frog, and has been released on 19th August 2009. \"Daddy DJ\" will be the first single released from the album.', '2009-10-15', 'music/57/70/70.jpg');
INSERT INTO `album` VALUES ('71', 'More Crazy Hits: Ultimate Edition', 'no', '2008-06-17', 'music/57/71/71.jpg');

-- ----------------------------
-- Table structure for album_comment
-- ----------------------------
DROP TABLE IF EXISTS `album_comment`;
CREATE TABLE `album_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`id`,`uid`,`aid`),
  KEY `FK_Album_AlbumComment` (`aid`),
  KEY `FK_User_AlbumComment` (`uid`),
  CONSTRAINT `FK_Album_AlbumComment` FOREIGN KEY (`aid`) REFERENCES `album` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_User_AlbumComment` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album_comment
-- ----------------------------

-- ----------------------------
-- Table structure for billboard
-- ----------------------------
DROP TABLE IF EXISTS `billboard`;
CREATE TABLE `billboard` (
  `time` date NOT NULL,
  `mid` int(11) NOT NULL,
  `download_amount` bigint(20) DEFAULT NULL,
  `play_amount` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`time`,`mid`),
  KEY `FK_Music_Billboard` (`mid`),
  CONSTRAINT `FK_Music_Billboard` FOREIGN KEY (`mid`) REFERENCES `music` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of billboard
-- ----------------------------
INSERT INTO `billboard` VALUES ('2017-02-16', '4', '3000000', '13890000');
INSERT INTO `billboard` VALUES ('2017-02-16', '16', '260000', '3260000');
INSERT INTO `billboard` VALUES ('2017-02-16', '26', '1680000', '14560000');
INSERT INTO `billboard` VALUES ('2017-02-16', '42', '7380000', '27730000');
INSERT INTO `billboard` VALUES ('2017-02-16', '46', '190000', '400000');
INSERT INTO `billboard` VALUES ('2017-02-16', '58', '100000', '500000');
INSERT INTO `billboard` VALUES ('2017-02-16', '60', '170000', '423000');
INSERT INTO `billboard` VALUES ('2017-02-16', '72', '260000', '770000');
INSERT INTO `billboard` VALUES ('2017-02-16', '79', '1410000', '282300008');
INSERT INTO `billboard` VALUES ('2017-02-16', '83', '240000', '790000');
INSERT INTO `billboard` VALUES ('2017-02-16', '97', '5770000', '43220000');
INSERT INTO `billboard` VALUES ('2017-02-16', '105', '98963', '200000');
INSERT INTO `billboard` VALUES ('2017-02-16', '111', '40967', '140000');
INSERT INTO `billboard` VALUES ('2017-02-16', '135', '1810000', '2060000');
INSERT INTO `billboard` VALUES ('2017-02-16', '167', '1520000', '13950000');
INSERT INTO `billboard` VALUES ('2017-02-16', '171', '53498', '110000');
INSERT INTO `billboard` VALUES ('2017-02-16', '180', '124000', '530000');
INSERT INTO `billboard` VALUES ('2017-02-16', '189', '540000', '1230000');
INSERT INTO `billboard` VALUES ('2017-02-16', '195', '340000', '1350000');
INSERT INTO `billboard` VALUES ('2017-02-16', '200', '894000', '1020000');
INSERT INTO `billboard` VALUES ('2017-02-16', '207', '230000', '560000');
INSERT INTO `billboard` VALUES ('2017-02-16', '211', '780000', '1130000');
INSERT INTO `billboard` VALUES ('2017-02-16', '219', '110000', '530000');

-- ----------------------------
-- Table structure for flow
-- ----------------------------
DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow` (
  `time` date NOT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow
-- ----------------------------

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Label_LabelGroup` (`gid`),
  CONSTRAINT `FK_Label_LabelGroup` FOREIGN KEY (`gid`) REFERENCES `label_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', '1', '华语');
INSERT INTO `label` VALUES ('2', '1', '欧美');
INSERT INTO `label` VALUES ('3', '1', '日韩');
INSERT INTO `label` VALUES ('4', '1', '其他');
INSERT INTO `label` VALUES ('5', '2', '流行');
INSERT INTO `label` VALUES ('6', '2', '摇滚');
INSERT INTO `label` VALUES ('7', '2', '民谣');
INSERT INTO `label` VALUES ('8', '2', '电子');
INSERT INTO `label` VALUES ('9', '3', '安静');
INSERT INTO `label` VALUES ('10', '3', '运动');
INSERT INTO `label` VALUES ('11', '3', '旅行');
INSERT INTO `label` VALUES ('12', '3', '下午茶');
INSERT INTO `label` VALUES ('13', '4', '影视原声');
INSERT INTO `label` VALUES ('14', '4', '校园歌曲');
INSERT INTO `label` VALUES ('15', '4', 'KTV');
INSERT INTO `label` VALUES ('16', '4', '网络歌曲');
INSERT INTO `label` VALUES ('17', '2', 'R&B');
INSERT INTO `label` VALUES ('18', '2', '嘻哈');
INSERT INTO `label` VALUES ('19', '2', '乡村');
INSERT INTO `label` VALUES ('20', '2', '爵士');
INSERT INTO `label` VALUES ('21', '2', '古典');

-- ----------------------------
-- Table structure for label_group
-- ----------------------------
DROP TABLE IF EXISTS `label_group`;
CREATE TABLE `label_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label_group
-- ----------------------------
INSERT INTO `label_group` VALUES ('1', '语种');
INSERT INTO `label_group` VALUES ('2', '风格');
INSERT INTO `label_group` VALUES ('3', '场景');
INSERT INTO `label_group` VALUES ('4', '主题');

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `lyrics` varchar(255) DEFAULT NULL,
  `link` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=220 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', 'I Am', 'music/24/4/1.lrc', 'music/24/4/1.mp3');
INSERT INTO `music` VALUES ('2', '爱笑的眼睛', 'music/24/4/2.lrc', 'music/24/4/2.mp3');
INSERT INTO `music` VALUES ('3', '一生的爱', 'music/24/4/3.lrc', 'music/24/4/3.mp3');
INSERT INTO `music` VALUES ('4', '她说', 'music/24/4/4.lrc', 'music/24/4/4.mp3');
INSERT INTO `music` VALUES ('5', '记得', 'music/24/4/5.lrc', 'music/24/4/5.mp3');
INSERT INTO `music` VALUES ('6', '只对你有感觉', 'music/24/4/6.lrc', 'music/24/4/6.mp3');
INSERT INTO `music` VALUES ('7', '当你', 'music/24/4/7.lrc', 'music/24/4/7.mp3');
INSERT INTO `music` VALUES ('8', '一眼万年', 'music/24/4/8.lrc', 'music/24/4/8.mp3');
INSERT INTO `music` VALUES ('9', '保护色', 'music/24/4/9.lrc', 'music/24/4/9.mp3');
INSERT INTO `music` VALUES ('10', '握不住的他', 'music/24/4/10.lrc', 'music/24/4/10.mp3');
INSERT INTO `music` VALUES ('11', '心墙', 'music/24/4/11.lrc', 'music/24/4/11.mp3');
INSERT INTO `music` VALUES ('12', '我很想爱他', 'music/24/4/12.lrc', 'music/24/4/12.mp3');
INSERT INTO `music` VALUES ('13', '完美新世界', 'music/24/4/13.lrc', 'music/24/4/13.mp3');
INSERT INTO `music` VALUES ('14', '真材实料的我', 'music/24/4/14.lrc', 'music/24/4/14.mp3');
INSERT INTO `music` VALUES ('15', '杀手', 'music/24/3/15.lrc', 'music/24/3/15.mp3');
INSERT INTO `music` VALUES ('16', '西界', 'music/24/3/16.lrc', 'music/24/3/16.mp3');
INSERT INTO `music` VALUES ('17', '无聊', 'music/24/3/17.lrc', 'music/24/3/17.mp3');
INSERT INTO `music` VALUES ('18', 'K-O', 'music/24/3/18.lrc', 'music/24/3/18.mp3');
INSERT INTO `music` VALUES ('19', '发现爱', 'music/24/3/19.lrc', 'music/24/3/19.mp3');
INSERT INTO `music` VALUES ('20', '不流泪的机场', 'music/24/3/20.lrc', 'music/24/3/20.mp3');
INSERT INTO `music` VALUES ('21', '自由不变', 'music/24/3/21.lrc', 'music/24/3/21.mp3');
INSERT INTO `music` VALUES ('22', 'Baby Baby', 'music/24/3/22.lrc', 'music/24/3/22.mp3');
INSERT INTO `music` VALUES ('23', 'L-O-V-E', 'music/24/3/23.lrc', 'music/24/3/23.mp3');
INSERT INTO `music` VALUES ('24', 'Stay Here', 'music/23/2/24.lrc', 'music/23/2/24.mp3');
INSERT INTO `music` VALUES ('25', '初学者', 'music/23/2/25.lrc', 'music/23/2/25.mp3');
INSERT INTO `music` VALUES ('26', '演员', 'music/23/2/26.lrc', 'music/23/2/26.mp3');
INSERT INTO `music` VALUES ('27', '一半', 'music/23/2/27.lrc', 'music/23/2/27.mp3');
INSERT INTO `music` VALUES ('28', '小孩', 'music/23/2/28.lrc', 'music/23/2/28.mp3');
INSERT INTO `music` VALUES ('29', '花儿和少年', 'music/23/2/29.lrc', 'music/23/2/29.lmp3');
INSERT INTO `music` VALUES ('30', '下雨了', 'music/23/2/30.lrc', 'music/23/2/30.mp3');
INSERT INTO `music` VALUES ('31', '刚刚好', 'music/23/2/31.lrc', 'music/23/2/31.mp3');
INSERT INTO `music` VALUES ('32', '绅士', 'music/23/2/32.lrc', 'music/23/2/32.mp3');
INSERT INTO `music` VALUES ('33', '我好像在哪见过你', 'music/23/2/33.lrc', 'music/23/2/33.mp3');
INSERT INTO `music` VALUES ('34', '丑八怪', 'music/23/1/34.lrc', 'music/23/1/34.mp32');
INSERT INTO `music` VALUES ('35', '意外', 'music/23/1/35.lrc', 'music/23/1/35.mp3');
INSERT INTO `music` VALUES ('36', '你还要我怎样', 'music/23/1/36.lrc', 'music/23/1/36.mp3');
INSERT INTO `music` VALUES ('37', '有没有', 'music/23/1/37.lrc', 'music/23/1/37.mp3');
INSERT INTO `music` VALUES ('38', '潮流季', 'music/23/1/38.lrc', 'music/23/1/38.mp3');
INSERT INTO `music` VALUES ('39', '等我回家', 'music/23/1/39.lrc', 'music/23/1/39.mp3');
INSERT INTO `music` VALUES ('40', '我想起你了', 'music/23/1/40.lrc', 'music/23/1/40.mp3');
INSERT INTO `music` VALUES ('41', '其实', 'music/23/1/41.lrc', 'music/23/1/41.mp3');
INSERT INTO `music` VALUES ('42', '方圆几里', 'music/23/1/42.lrc', 'music/23/1/42.mp3');
INSERT INTO `music` VALUES ('43', '方圆几里（吉他版）', 'music/23/1/43.lrc', 'music/23/1/43.mp3');
INSERT INTO `music` VALUES ('44', '暗涌', 'music/25/5/44.lrc', 'music/25/5/44.mp3');
INSERT INTO `music` VALUES ('45', '约定', 'music/25/5/45.lrc', 'music/25/5/45.mp3');
INSERT INTO `music` VALUES ('46', '敷衍', 'music/25/5/46.lrc', 'music/25/5/46.mp3');
INSERT INTO `music` VALUES ('47', '玩具', 'music/25/5/47.lrc', 'music/25/5/47.mp3');
INSERT INTO `music` VALUES ('48', '我信', 'music/25/5/48.lrc', 'music/25/5/48.mp3');
INSERT INTO `music` VALUES ('49', '守时', 'music/25/5/49.lrc', 'music/25/5/49.mp3');
INSERT INTO `music` VALUES ('50', '守护天使', 'music/25/5/50.lrc', 'music/25/5/50.mp3');
INSERT INTO `music` VALUES ('51', '自便', 'music/25/5/51.lrc', 'music/25/5/51.mp3');
INSERT INTO `music` VALUES ('52', '不得了', 'music/25/5/52.lrc', 'music/25/5/52.mp3');
INSERT INTO `music` VALUES ('53', '心惊胆战', 'music/25/5/53.lrc', 'music/25/5/53.mp3');
INSERT INTO `music` VALUES ('54', '不安', 'music/25/6/54.lrc', 'music/25/6/54.mp3');
INSERT INTO `music` VALUES ('55', '哪儿', 'music/25/6/55.lrc', 'music/25/6/55.mp3');
INSERT INTO `music` VALUES ('56', '堕落', 'music/25/6/56.lrc', 'music/25/6/56.mp3');
INSERT INTO `music` VALUES ('57', '扫兴', 'music/25/6/57.lrc', 'music/25/6/57.mp3');
INSERT INTO `music` VALUES ('58', '末日', 'music/25/6/58.lrc', 'music/25/6/58.mp3');
INSERT INTO `music` VALUES ('59', '野三坡', 'music/25/6/59.lrc', 'music/25/6/59.mp3');
INSERT INTO `music` VALUES ('60', 'Aftermath', 'music/30/16/60.lrc', 'music/30/16/60.mp3');
INSERT INTO `music` VALUES ('61', 'Fever', 'music/30/16/61.lrc', 'music/30/16/61.mp3');
INSERT INTO `music` VALUES ('62', 'Ring Of Fire', 'music/30/16/62.lrc', 'music/30/16/62.mp3');
INSERT INTO `music` VALUES ('63', 'Sleepwalker', 'music/30/16/63.lrc', 'music/30/16/63.mp3');
INSERT INTO `music` VALUES ('64', 'Soaked', 'music/30/16/64.lrc', 'music/30/16/64.mp3');
INSERT INTO `music` VALUES ('65', 'Sure Fire Winners', 'music/30/16/65.lrc', 'music/30/16/65.mp3');
INSERT INTO `music` VALUES ('66', 'Voodoo', 'music/30/16/66.lrc', 'music/30/16/66.mp3');
INSERT INTO `music` VALUES ('67', 'Whataya Want From Me', 'music/30/16/67.lrc', 'music/30/16/67.mp3');
INSERT INTO `music` VALUES ('68', 'Better Than I Know Myself', 'music/30/15/68.lrc', 'music/30/15/68.mp3');
INSERT INTO `music` VALUES ('69', 'Cuckoo', 'music/30/15/69.lrc', 'music/30/15/69.mp3');
INSERT INTO `music` VALUES ('70', 'Naked Love', 'music/30/15/70.lrc', 'music/30/15/70.mp3');
INSERT INTO `music` VALUES ('71', 'Never Close Our Eyes', 'music/30/15/71.lrc', 'music/30/15/71.mp3');
INSERT INTO `music` VALUES ('72', 'Shady', 'music/30/15/72.lrc', 'music/30/15/72.mp3');
INSERT INTO `music` VALUES ('73', 'Trespassing', 'music/30/15/73.lrc', 'music/30/15/73.mp3');
INSERT INTO `music` VALUES ('74', 'I Promise You (With Everything I Am)', 'music/32/20/74.lrc', 'music/32/20/74.mp3');
INSERT INTO `music` VALUES ('75', 'The Answer To Our Life', 'music/32/20/75.lrc', 'music/32/20/75.mp3');
INSERT INTO `music` VALUES ('76', 'What Makes You Different', 'music/32/20/76.lrc', 'music/32/20/76.mp3');
INSERT INTO `music` VALUES ('77', 'It\'s True', 'music/32/20/77.lrc', 'music/32/20/77.mp3');
INSERT INTO `music` VALUES ('78', 'More Than That', 'music/32/20/78.lrc', 'music/32/20/78.mp3');
INSERT INTO `music` VALUES ('79', 'Shape of My Heart', 'music/32/20/79.lrc', 'music/32/20/79.mp3');
INSERT INTO `music` VALUES ('80', 'Last Night You Saved My Life', 'music/32/19/80.lrc', 'music/32/19/80.mp3');
INSERT INTO `music` VALUES ('81', 'Movin\' On', 'music/32/19/81.lrc', 'music/32/19/81.mp3');
INSERT INTO `music` VALUES ('82', 'I Still...', 'music/32/19/82.lrc', 'music/32/19/82.mp3');
INSERT INTO `music` VALUES ('83', 'Never Gone', 'music/32/19/83.lrc', 'music/32/19/83.mp3');
INSERT INTO `music` VALUES ('84', 'Song For The Unloved', 'music/32/19/84.lrc', 'music/32/19/84.mp3');
INSERT INTO `music` VALUES ('85', 'Incomplete', 'music/32/19/85.lrc', 'music/32/19/85.mp3');
INSERT INTO `music` VALUES ('86', 'Lose It All', 'music/32/19/86.lrc', 'music/32/19/86.mp3');
INSERT INTO `music` VALUES ('87', 'Dancing In The Street', 'music/33/21/87.lrc', 'music/33/21/87.mp3');
INSERT INTO `music` VALUES ('88', 'Nowhere Man', 'music/33/21/88.lrc', 'music/33/21/88.mp3');
INSERT INTO `music` VALUES ('89', 'Without A Song', 'music/33/21/89.lrc', 'music/33/21/89.mp3');
INSERT INTO `music` VALUES ('90', 'You\'re Just In Love', 'music/33/21/90.lrc', 'music/33/21/90.mp3');
INSERT INTO `music` VALUES ('91', 'If I Had You', 'music/33/22/91.lrc', 'music/33/22/91.mp3');
INSERT INTO `music` VALUES ('92', 'If We Try', 'music/33/22/92.lrc', 'music/33/22/92.mp3');
INSERT INTO `music` VALUES ('93', 'Slow Dance', 'music/33/22/93.lrc', 'music/33/22/93.mp3');
INSERT INTO `music` VALUES ('94', 'The Uninvited Guest', 'music/33/22/94.lrc', 'music/33/22/94.mp3');
INSERT INTO `music` VALUES ('95', 'When I Fall In Love', 'music/33/22/95.lrc', 'music/33/22/95.mp3');
INSERT INTO `music` VALUES ('96', 'Where Do I Go From Here', 'music/33/22/96.lrc', 'music/33/22/96.mp3');
INSERT INTO `music` VALUES ('97', 'As Long As You Love Me', 'music/29/13/97.lrc', 'music/29/13/97.mp3');
INSERT INTO `music` VALUES ('98', 'Be Alright', 'music/29/13/98.lrc', 'music/29/13/98.mp3');
INSERT INTO `music` VALUES ('99', 'Beauty And A Beat', 'music/29/13/99.lrc', 'music/29/13/99.mp3');
INSERT INTO `music` VALUES ('100', 'Boyfriend', 'music/29/13/100.lrc', 'music/29/13/100.mp3');
INSERT INTO `music` VALUES ('101', 'Fall', 'music/29/13/101.lrc', 'music/29/13/101.mp3');
INSERT INTO `music` VALUES ('102', 'I Would', 'music/29/13/102.lrc', 'music/29/13/102.mp3');
INSERT INTO `music` VALUES ('103', 'Nothing Like Us', 'music/29/13/103.lrc', 'music/29/13/103.mp3');
INSERT INTO `music` VALUES ('104', 'Take You', 'music/29/13/104.lrc', 'music/29/13/104.mp3');
INSERT INTO `music` VALUES ('105', 'Yellow Raincoat', 'music/ 29/13/105.lrc', 'music/29/13/105.mp3');
INSERT INTO `music` VALUES ('106', 'Bigger', 'music/29/14/106.lrc', 'music/29/14/106.mp3');
INSERT INTO `music` VALUES ('107', 'One Time', 'music/29/14/107.lrc', 'music/29/14/107.mp3');
INSERT INTO `music` VALUES ('108', 'Common Denominator', 'music/29/14/108.lrc', 'music/29/14/108.mp3');
INSERT INTO `music` VALUES ('109', 'Down To Earth', 'music/29/14/109.lrc', 'music/29/14/109.mp3');
INSERT INTO `music` VALUES ('110', 'Favorite Girl', 'music/29/14/110.lrc', 'music/29/14/110.mp3');
INSERT INTO `music` VALUES ('111', 'First Dance', 'music/29/14/111.lrc', 'music/29/14/111.mp3');
INSERT INTO `music` VALUES ('112', 'Love Me', 'music/29/14/112.lrc', 'music/29/14/112.mp3');
INSERT INTO `music` VALUES ('113', 'One Less Lonely Girl', 'music/29/14/113.lrc', 'music/29/14/113.mp3');
INSERT INTO `music` VALUES ('114', 'Dreams For Plans', 'music/31/18/114.lrc', 'music/31/18/114.mp3');
INSERT INTO `music` VALUES ('115', 'Hey You', 'music/31/18/115.lrc', 'music/31/18/115.mp3');
INSERT INTO `music` VALUES ('116', 'Your Embrace', 'music/31/18/116.lrc', 'music/31/18/116.mp3');
INSERT INTO `music` VALUES ('117', 'Something', 'music/31/18/117.lrc', 'music/31/18/117.mp3');
INSERT INTO `music` VALUES ('118', 'Timor', 'music/31/18/118.lrc', 'music/31/18/118.mp3');
INSERT INTO `music` VALUES ('119', 'Empire', 'music/31/17/119.lrc', 'music/31/17/119.mp3');
INSERT INTO `music` VALUES ('120', 'Can\'t Remember to Forget You', 'music/31/17/120.lrc', 'music/31/17/120.mp3');
INSERT INTO `music` VALUES ('121', 'Chasing Shadows', 'music/31/17/121.lrc', 'music/31/17/121.mp3');
INSERT INTO `music` VALUES ('122', 'Dare (La La La)', 'music/31/17/122.lrc', 'music/31/17/122.mp3');
INSERT INTO `music` VALUES ('123', 'La La La', 'music/31/17/123.lrc', 'music/31/17/123.mp3');
INSERT INTO `music` VALUES ('124', 'That Way', 'music/31/17/124.lrc', 'music/31/17/124.mp3');
INSERT INTO `music` VALUES ('125', '夜', 'music/27/10/125.lrc', 'music/27/10/125.mp3');
INSERT INTO `music` VALUES ('126', '如果明天', 'music/27/10/126.lrc', 'music/27/10/126.mp3');
INSERT INTO `music` VALUES ('127', '越长大越孤单', 'music/27/10/127.lrc', 'music/27/10/127.mp3');
INSERT INTO `music` VALUES ('128', '蝶恋花', 'music/27/10/128.lrc', 'music/27/10/128.mp3');
INSERT INTO `music` VALUES ('129', '穿越珊瑚海', 'music/27/10/129.lrc', 'music/27/10/129.mp3');
INSERT INTO `music` VALUES ('130', '\r\n你不能爱我', 'music/27/9/130.lrc', 'music/27/9/130.mp3');
INSERT INTO `music` VALUES ('131', '\r\n旅客', 'music/27/9/131.lrc', 'music/27/9/131.mp3');
INSERT INTO `music` VALUES ('132', '\r\n女朋友', 'music/27/9/132.lrc', 'music/27/9/132.mp3');
INSERT INTO `music` VALUES ('133', '城市的天空', 'music/27/9/133.lrc', 'music/27/9/133.mp3');
INSERT INTO `music` VALUES ('134', '\r\n魔力比啵', 'music/27/9/134.lrc', 'music/27/9/134.mp3');
INSERT INTO `music` VALUES ('135', 'Black', 'music/37/30/135.lrc', 'music/37/30/135.mp3');
INSERT INTO `music` VALUES ('136', 'COUP D\'ETAT(Feat. DIPLO、BAAUER）', 'music/37/30/136.lrc', 'music/37/30/136.mp3');
INSERT INTO `music` VALUES ('137', 'R.O.D', 'music/37/30/137.lrc', 'music/37/30/137.mp3');
INSERT INTO `music` VALUES ('138', 'Who You', 'music/37/30/138.lrc', 'music/37/30/138.mp3');
INSERT INTO `music` VALUES ('139', 'Gentlemen', 'music/36/32/139.lrc', 'music/36/32/139.mp3');
INSERT INTO `music` VALUES ('140', 'Hangover', 'music/36/31/140.lrc', 'music/36/31/140.mp3');
INSERT INTO `music` VALUES ('141', '30 Sexy', 'music/35/34/141.lrc', 'music/35/34/141.mp3');
INSERT INTO `music` VALUES ('142', 'La Song', 'music/35/34/142.lrc', 'music/35/34/142.mp3');
INSERT INTO `music` VALUES ('143', '去哪儿，哥哥', 'music/35/34/143.lrc', 'music/35/34/143.mp3');
INSERT INTO `music` VALUES ('144', '假装', 'music/35/33/144.lrc', 'music/35/33/144.mp3');
INSERT INTO `music` VALUES ('145', '克拉恋人', 'music/35/33/145.lrc', 'music/35/33/145.mp3');
INSERT INTO `music` VALUES ('146', '陪我一起做梦', 'music/34/35/146.lrc', 'music/34/35/146.mp3');
INSERT INTO `music` VALUES ('147', '没有你不能活(Without You)', 'music/34/36/147.lrc', 'music/34/36/147.mp3');
INSERT INTO `music` VALUES ('148', '角度', 'music/38/47/148.lrc', 'music/38/47/148.mp3');
INSERT INTO `music` VALUES ('149', '事过境迁', 'music/38/48/149.lrc', 'music/38/48/149.mp3');
INSERT INTO `music` VALUES ('150', 'Bad Girls', 'music/39/51/150.lrc', 'music/39/51/150.mp3');
INSERT INTO `music` VALUES ('151', 'Holly Jolly Bus', 'music/39/51/151.lrc', 'music/39/51/151.mp3');
INSERT INTO `music` VALUES ('152', 'Love Radar', 'music/39/51/152.lrc', 'music/39/51/152.mp3');
INSERT INTO `music` VALUES ('153', '韩国小姐', 'music/39/51/153.lrc', 'music/39/51/153.mp3');
INSERT INTO `music` VALUES ('154', 'Don\'t Cry', 'music/39/50/154.lrc', 'music/39/50/154.mp3');
INSERT INTO `music` VALUES ('155', 'MY COLOR', 'music/40/52/155.lrc', 'music/40/52/155.mp3');
INSERT INTO `music` VALUES ('156', '爱你', 'music/41/55/156.lrc', 'music/41/55/156.mp3');
INSERT INTO `music` VALUES ('157', '过得好吗', 'music/41/53/157.lrc', 'music/41/53/157.mp3');
INSERT INTO `music` VALUES ('158', '聆听你的话', 'music/41/54/158.lrc', 'music/41/54/158.mp3');
INSERT INTO `music` VALUES ('159', 'Oh BOY', 'music/45/63/159.lrc', 'music/45/63/159.mp3');
INSERT INTO `music` VALUES ('160', 'Stay with me', 'music/45/63/160.lrc', 'music/45/63/160.mp3');
INSERT INTO `music` VALUES ('161', 'OK!', 'music/45/62/161.lrc', 'music/45/62/161.mp3');
INSERT INTO `music` VALUES ('162', 'RUNWAY', 'music/45/62/162.lrc', 'music/45/62/162.mp3');
INSERT INTO `music` VALUES ('163', 'WOW WAR TONIGHT~時には起こせよムーヴメント(girls ver.)', 'music/45/62/163.lrc', 'music/45/62/163.mp3');
INSERT INTO `music` VALUES ('164', 'BANG BANG BANG(Live)', 'music/43/66/164.lrc', 'music/43/66/164.mp3');
INSERT INTO `music` VALUES ('165', 'Stupid Liar(Live)', 'music/43/66/165.lrc', 'music/43/66/165.mp3');
INSERT INTO `music` VALUES ('166', 'Tonight(Live)', 'music/43/66/166.lrc', 'music/43/66/166.mp3');
INSERT INTO `music` VALUES ('167', 'IF YOU', 'music/43/67/167.lrc', 'music/43/67/167.mp3');
INSERT INTO `music` VALUES ('168', 'LOSER', 'music/43/67/168.lrc', 'music/43/67/168.mp3');
INSERT INTO `music` VALUES ('169', 'Coming Over', 'music/44/68/169.lrc', 'music/44/68/169.mp3');
INSERT INTO `music` VALUES ('170', 'Run This', 'music/44/68/170.lrc', 'music/44/68/170.mp3');
INSERT INTO `music` VALUES ('171', 'TacTix', 'music/44/68/171.lrc', 'music/44/68/171.mp3');
INSERT INTO `music` VALUES ('172', 'Drop That', 'music/44/69/172.lrc', 'music/44/69/172.mp3');
INSERT INTO `music` VALUES ('173', 'Love Me Right ~romantic universe~', 'music/44/69/173.lrc', 'music/44/69/173.mp3');
INSERT INTO `music` VALUES ('174', 'T-ara - TIAMO', 'music/42/64/174.lrc', 'music/42/64/174.mp3');
INSERT INTO `music` VALUES ('175', 'T-ara - 离别电影', 'music/42/64/175.lrc', 'music/42/64/175.mp3');
INSERT INTO `music` VALUES ('176', 'T-ara - 只痛到今天为止', 'music/42/64/176.lrc', 'music/42/64/176.mp3');
INSERT INTO `music` VALUES ('177', 'T-ara - For You', 'music/42/65/177.lrc', 'music/42/65/177.mp3');
INSERT INTO `music` VALUES ('178', 'T-ara - 我们分手的理由', 'music/42/65/178.lrc', 'music/42/65/178.mp3');
INSERT INTO `music` VALUES ('179', 'I LOVE YOU(ORIGINAL VERSION)', 'music/51/27/179.lrc', 'music/51/27/179.mp3');
INSERT INTO `music` VALUES ('180', 'Freeze Moon (Live)', 'music/51/26/180.lrc', 'music/51/26/180.mp3');
INSERT INTO `music` VALUES ('181', 'Scrambling Rock’n’Roll (Live)', 'music/51/26/181.lrc', 'music/51/26/181.mp3');
INSERT INTO `music` VALUES ('182', 'Scrap Alley (Live)', 'music/51/26/182.lrc', 'music/51/26/182.mp3');
INSERT INTO `music` VALUES ('183', '愛の消えた街 (Live)', 'music/51/26/183.lrc', 'music/51/26/183.mp3');
INSERT INTO `music` VALUES ('184', 'キラキラ', 'music/52/29/184.lrc', 'music/52/29/184.mp3');
INSERT INTO `music` VALUES ('185', 'ラブ・ストーリーは突然に', 'music/52/29/185.lrc', 'music/52/29/185.mp3');
INSERT INTO `music` VALUES ('186', '小田和正 - Yes-No', 'music/52/28/186.lrc', 'music/52/28/186.mp3');
INSERT INTO `music` VALUES ('187', '小田和正 - さよなら', 'music/52/28/187.lrc', 'music/52/28/187.mp3');
INSERT INTO `music` VALUES ('188', 'Friend', 'music/50/25/188.lrc', 'music/50/25/188.mp3');
INSERT INTO `music` VALUES ('189', '梦のつづき', 'music/50/25/189.lrc', 'music/50/25/189.mp3');
INSERT INTO `music` VALUES ('190', 'あの素晴しい愛をもう一度', 'music/50/24/190.lrc', 'music/50/24/190.mp3');
INSERT INTO `music` VALUES ('191', 'みんな夢の中', 'music/50/24/191.lrc', 'music/50/24/191.mp3');
INSERT INTO `music` VALUES ('192', 'Christmas Wish', 'music/56/44/192.lrc', 'music/56/44/192.mp3');
INSERT INTO `music` VALUES ('193', 'Dear Diary', 'music/56/45/193.lrc', 'music/56/45/193.mp3');
INSERT INTO `music` VALUES ('194', 'Fighter', 'music/56/45/194.lrc', 'music/56/45/194.mp3');
INSERT INTO `music` VALUES ('195', 'Hero', 'music/56/46/195.lrc', 'music/56/46/195.mp3');
INSERT INTO `music` VALUES ('196', 'Show Me What You\'ve Got', 'music/56/46/196.lrc', 'music/56/46/196.mp3');
INSERT INTO `music` VALUES ('197', 'glitter', 'music/53/39/197.lrc', 'music/53/39/197.mp3');
INSERT INTO `music` VALUES ('198', 'Breakdown', 'music/53/38/198.lrc', 'music/53/38/198.mp3');
INSERT INTO `music` VALUES ('199', 'Many Classic Moments', 'music/53/38/199.lrc', 'music/53/38/199.mp3');
INSERT INTO `music` VALUES ('200', 'We are the QUEENS', 'music/53/37/200.lrc', 'music/53/37/200.mp3');
INSERT INTO `music` VALUES ('201', 'Time after time ~花舞う街で~', 'music/54/41/201.lrc', 'music/54/41/201.mp3');
INSERT INTO `music` VALUES ('202', 'Beautiful World (Live)', 'music/55/43/202.lrc', 'music/55/43/202.mp3');
INSERT INTO `music` VALUES ('203', 'First Love', 'music/55/42/203.lrc', 'music/55/42/203.mp3');
INSERT INTO `music` VALUES ('204', 'Green boys', 'music/46/57/204.lrc', 'music/46/57/204.mp3');
INSERT INTO `music` VALUES ('205', '暁の君に', 'music/46/56/205.lrc', 'music/46/56/205.mp3');
INSERT INTO `music` VALUES ('206', 'Deeper Deeper', 'music/47/59/206.lrc', 'music/47/59/206.mp3');
INSERT INTO `music` VALUES ('207', 'Nothing Helps', 'music/47/59/207.lrc', 'music/47/59/207.mp3');
INSERT INTO `music` VALUES ('208', 'カサブタ (疮痂)', 'music/47/59/208.lrc', 'music/47/59/208.mp3');
INSERT INTO `music` VALUES ('209', 'Decision - 映画「FOOL COOL ROCK! ONE OK ROCK DOCUMENTARY FILM」主題歌', 'music/47/58/209.lrc', 'music/47/58/209.mp3');
INSERT INTO `music` VALUES ('210', 'Mighty Long Fall - 电影《浪客剑心 京都大火篇》主题曲  映画「るろうに剣心 京都大火編」主題歌', 'music/47/58/210.lrc', 'music/47/58/210.mp3');
INSERT INTO `music` VALUES ('211', 'Pieces of Me', 'music/47/58/211.lrc', 'music/47/58/211.mp3');
INSERT INTO `music` VALUES ('212', 'glory colors 〜風のトビラ〜', 'music/48/61/212.lrc', 'music/48/61/212.mp3');
INSERT INTO `music` VALUES ('213', 'treasure of the heart ~キミとボクの奇跡~', 'music/48/60/213.lrc', 'music/48/60/213.mp3');
INSERT INTO `music` VALUES ('214', 'Arigato', 'music/48/60/214.lrc', 'music/48/60/214.mp3');
INSERT INTO `music` VALUES ('215', 'Cotton Eye Joe', 'music/57/71/215.lrc', 'music/57/71/215.mp3');
INSERT INTO `music` VALUES ('216', 'Cha Cha Slide', 'music/57/70/216.lrc', 'music/57/70/216.mp3');
INSERT INTO `music` VALUES ('217', 'Daddy DJ', 'music/57/70/217.lrc', 'music/57/70/217.mp3');
INSERT INTO `music` VALUES ('218', '看透', 'music/38/49/218.lrc', 'music/38/49/218.mp3');
INSERT INTO `music` VALUES ('219', 'Runway', 'music/38/49/219.lrc', 'music/38/49/219.mp3');

-- ----------------------------
-- Table structure for music_album
-- ----------------------------
DROP TABLE IF EXISTS `music_album`;
CREATE TABLE `music_album` (
  `mid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`mid`,`aid`),
  KEY `FK_Album_Music` (`aid`),
  CONSTRAINT `FK_Album_Music` FOREIGN KEY (`aid`) REFERENCES `album` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Music_Album` FOREIGN KEY (`mid`) REFERENCES `music` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music_album
-- ----------------------------
INSERT INTO `music_album` VALUES ('34', '1');
INSERT INTO `music_album` VALUES ('35', '1');
INSERT INTO `music_album` VALUES ('36', '1');
INSERT INTO `music_album` VALUES ('37', '1');
INSERT INTO `music_album` VALUES ('38', '1');
INSERT INTO `music_album` VALUES ('39', '1');
INSERT INTO `music_album` VALUES ('40', '1');
INSERT INTO `music_album` VALUES ('41', '1');
INSERT INTO `music_album` VALUES ('42', '1');
INSERT INTO `music_album` VALUES ('43', '1');
INSERT INTO `music_album` VALUES ('24', '2');
INSERT INTO `music_album` VALUES ('25', '2');
INSERT INTO `music_album` VALUES ('26', '2');
INSERT INTO `music_album` VALUES ('27', '2');
INSERT INTO `music_album` VALUES ('28', '2');
INSERT INTO `music_album` VALUES ('29', '2');
INSERT INTO `music_album` VALUES ('30', '2');
INSERT INTO `music_album` VALUES ('31', '2');
INSERT INTO `music_album` VALUES ('32', '2');
INSERT INTO `music_album` VALUES ('33', '2');
INSERT INTO `music_album` VALUES ('15', '3');
INSERT INTO `music_album` VALUES ('16', '3');
INSERT INTO `music_album` VALUES ('17', '3');
INSERT INTO `music_album` VALUES ('18', '3');
INSERT INTO `music_album` VALUES ('19', '3');
INSERT INTO `music_album` VALUES ('20', '3');
INSERT INTO `music_album` VALUES ('21', '3');
INSERT INTO `music_album` VALUES ('22', '3');
INSERT INTO `music_album` VALUES ('23', '3');
INSERT INTO `music_album` VALUES ('1', '4');
INSERT INTO `music_album` VALUES ('2', '4');
INSERT INTO `music_album` VALUES ('3', '4');
INSERT INTO `music_album` VALUES ('4', '4');
INSERT INTO `music_album` VALUES ('5', '4');
INSERT INTO `music_album` VALUES ('6', '4');
INSERT INTO `music_album` VALUES ('7', '4');
INSERT INTO `music_album` VALUES ('8', '4');
INSERT INTO `music_album` VALUES ('9', '4');
INSERT INTO `music_album` VALUES ('10', '4');
INSERT INTO `music_album` VALUES ('11', '4');
INSERT INTO `music_album` VALUES ('12', '4');
INSERT INTO `music_album` VALUES ('13', '4');
INSERT INTO `music_album` VALUES ('14', '4');
INSERT INTO `music_album` VALUES ('44', '5');
INSERT INTO `music_album` VALUES ('45', '5');
INSERT INTO `music_album` VALUES ('46', '5');
INSERT INTO `music_album` VALUES ('47', '5');
INSERT INTO `music_album` VALUES ('48', '5');
INSERT INTO `music_album` VALUES ('49', '5');
INSERT INTO `music_album` VALUES ('50', '5');
INSERT INTO `music_album` VALUES ('51', '5');
INSERT INTO `music_album` VALUES ('52', '5');
INSERT INTO `music_album` VALUES ('53', '5');
INSERT INTO `music_album` VALUES ('54', '6');
INSERT INTO `music_album` VALUES ('55', '6');
INSERT INTO `music_album` VALUES ('57', '6');
INSERT INTO `music_album` VALUES ('58', '6');
INSERT INTO `music_album` VALUES ('59', '6');
INSERT INTO `music_album` VALUES ('130', '9');
INSERT INTO `music_album` VALUES ('131', '9');
INSERT INTO `music_album` VALUES ('132', '9');
INSERT INTO `music_album` VALUES ('133', '9');
INSERT INTO `music_album` VALUES ('134', '9');
INSERT INTO `music_album` VALUES ('125', '10');
INSERT INTO `music_album` VALUES ('126', '10');
INSERT INTO `music_album` VALUES ('127', '10');
INSERT INTO `music_album` VALUES ('128', '10');
INSERT INTO `music_album` VALUES ('129', '10');
INSERT INTO `music_album` VALUES ('97', '13');
INSERT INTO `music_album` VALUES ('98', '13');
INSERT INTO `music_album` VALUES ('99', '13');
INSERT INTO `music_album` VALUES ('100', '13');
INSERT INTO `music_album` VALUES ('101', '13');
INSERT INTO `music_album` VALUES ('102', '13');
INSERT INTO `music_album` VALUES ('103', '13');
INSERT INTO `music_album` VALUES ('104', '13');
INSERT INTO `music_album` VALUES ('105', '13');
INSERT INTO `music_album` VALUES ('106', '14');
INSERT INTO `music_album` VALUES ('107', '14');
INSERT INTO `music_album` VALUES ('108', '14');
INSERT INTO `music_album` VALUES ('109', '14');
INSERT INTO `music_album` VALUES ('110', '14');
INSERT INTO `music_album` VALUES ('111', '14');
INSERT INTO `music_album` VALUES ('112', '14');
INSERT INTO `music_album` VALUES ('113', '14');
INSERT INTO `music_album` VALUES ('68', '15');
INSERT INTO `music_album` VALUES ('69', '15');
INSERT INTO `music_album` VALUES ('70', '15');
INSERT INTO `music_album` VALUES ('71', '15');
INSERT INTO `music_album` VALUES ('72', '15');
INSERT INTO `music_album` VALUES ('73', '15');
INSERT INTO `music_album` VALUES ('60', '16');
INSERT INTO `music_album` VALUES ('61', '16');
INSERT INTO `music_album` VALUES ('62', '16');
INSERT INTO `music_album` VALUES ('63', '16');
INSERT INTO `music_album` VALUES ('64', '16');
INSERT INTO `music_album` VALUES ('65', '16');
INSERT INTO `music_album` VALUES ('66', '16');
INSERT INTO `music_album` VALUES ('67', '16');
INSERT INTO `music_album` VALUES ('119', '17');
INSERT INTO `music_album` VALUES ('120', '17');
INSERT INTO `music_album` VALUES ('121', '17');
INSERT INTO `music_album` VALUES ('122', '17');
INSERT INTO `music_album` VALUES ('123', '17');
INSERT INTO `music_album` VALUES ('124', '17');
INSERT INTO `music_album` VALUES ('114', '18');
INSERT INTO `music_album` VALUES ('115', '18');
INSERT INTO `music_album` VALUES ('116', '18');
INSERT INTO `music_album` VALUES ('117', '18');
INSERT INTO `music_album` VALUES ('118', '18');
INSERT INTO `music_album` VALUES ('80', '19');
INSERT INTO `music_album` VALUES ('81', '19');
INSERT INTO `music_album` VALUES ('82', '19');
INSERT INTO `music_album` VALUES ('83', '19');
INSERT INTO `music_album` VALUES ('84', '19');
INSERT INTO `music_album` VALUES ('85', '19');
INSERT INTO `music_album` VALUES ('86', '19');
INSERT INTO `music_album` VALUES ('74', '20');
INSERT INTO `music_album` VALUES ('75', '20');
INSERT INTO `music_album` VALUES ('76', '20');
INSERT INTO `music_album` VALUES ('77', '20');
INSERT INTO `music_album` VALUES ('78', '20');
INSERT INTO `music_album` VALUES ('79', '20');
INSERT INTO `music_album` VALUES ('87', '21');
INSERT INTO `music_album` VALUES ('88', '21');
INSERT INTO `music_album` VALUES ('89', '21');
INSERT INTO `music_album` VALUES ('90', '21');
INSERT INTO `music_album` VALUES ('91', '22');
INSERT INTO `music_album` VALUES ('92', '22');
INSERT INTO `music_album` VALUES ('93', '22');
INSERT INTO `music_album` VALUES ('94', '22');
INSERT INTO `music_album` VALUES ('95', '22');
INSERT INTO `music_album` VALUES ('96', '22');
INSERT INTO `music_album` VALUES ('190', '24');
INSERT INTO `music_album` VALUES ('191', '24');
INSERT INTO `music_album` VALUES ('188', '25');
INSERT INTO `music_album` VALUES ('189', '25');
INSERT INTO `music_album` VALUES ('180', '26');
INSERT INTO `music_album` VALUES ('181', '26');
INSERT INTO `music_album` VALUES ('182', '26');
INSERT INTO `music_album` VALUES ('183', '26');
INSERT INTO `music_album` VALUES ('179', '27');
INSERT INTO `music_album` VALUES ('186', '28');
INSERT INTO `music_album` VALUES ('187', '28');
INSERT INTO `music_album` VALUES ('184', '29');
INSERT INTO `music_album` VALUES ('185', '29');
INSERT INTO `music_album` VALUES ('135', '30');
INSERT INTO `music_album` VALUES ('136', '30');
INSERT INTO `music_album` VALUES ('137', '30');
INSERT INTO `music_album` VALUES ('138', '30');
INSERT INTO `music_album` VALUES ('140', '31');
INSERT INTO `music_album` VALUES ('139', '32');
INSERT INTO `music_album` VALUES ('144', '33');
INSERT INTO `music_album` VALUES ('145', '33');
INSERT INTO `music_album` VALUES ('141', '34');
INSERT INTO `music_album` VALUES ('142', '34');
INSERT INTO `music_album` VALUES ('143', '34');
INSERT INTO `music_album` VALUES ('146', '35');
INSERT INTO `music_album` VALUES ('147', '36');
INSERT INTO `music_album` VALUES ('200', '37');
INSERT INTO `music_album` VALUES ('198', '38');
INSERT INTO `music_album` VALUES ('199', '38');
INSERT INTO `music_album` VALUES ('197', '39');
INSERT INTO `music_album` VALUES ('201', '41');
INSERT INTO `music_album` VALUES ('203', '42');
INSERT INTO `music_album` VALUES ('202', '43');
INSERT INTO `music_album` VALUES ('192', '44');
INSERT INTO `music_album` VALUES ('193', '45');
INSERT INTO `music_album` VALUES ('194', '45');
INSERT INTO `music_album` VALUES ('195', '46');
INSERT INTO `music_album` VALUES ('196', '46');
INSERT INTO `music_album` VALUES ('148', '47');
INSERT INTO `music_album` VALUES ('149', '48');
INSERT INTO `music_album` VALUES ('218', '49');
INSERT INTO `music_album` VALUES ('219', '49');
INSERT INTO `music_album` VALUES ('154', '50');
INSERT INTO `music_album` VALUES ('150', '51');
INSERT INTO `music_album` VALUES ('151', '51');
INSERT INTO `music_album` VALUES ('152', '51');
INSERT INTO `music_album` VALUES ('153', '51');
INSERT INTO `music_album` VALUES ('155', '52');
INSERT INTO `music_album` VALUES ('157', '53');
INSERT INTO `music_album` VALUES ('158', '54');
INSERT INTO `music_album` VALUES ('156', '55');
INSERT INTO `music_album` VALUES ('205', '56');
INSERT INTO `music_album` VALUES ('204', '57');
INSERT INTO `music_album` VALUES ('209', '58');
INSERT INTO `music_album` VALUES ('210', '58');
INSERT INTO `music_album` VALUES ('211', '58');
INSERT INTO `music_album` VALUES ('206', '59');
INSERT INTO `music_album` VALUES ('207', '59');
INSERT INTO `music_album` VALUES ('208', '59');
INSERT INTO `music_album` VALUES ('213', '60');
INSERT INTO `music_album` VALUES ('214', '60');
INSERT INTO `music_album` VALUES ('212', '61');
INSERT INTO `music_album` VALUES ('161', '62');
INSERT INTO `music_album` VALUES ('162', '62');
INSERT INTO `music_album` VALUES ('163', '62');
INSERT INTO `music_album` VALUES ('159', '63');
INSERT INTO `music_album` VALUES ('160', '63');
INSERT INTO `music_album` VALUES ('174', '64');
INSERT INTO `music_album` VALUES ('175', '64');
INSERT INTO `music_album` VALUES ('176', '64');
INSERT INTO `music_album` VALUES ('177', '65');
INSERT INTO `music_album` VALUES ('178', '65');
INSERT INTO `music_album` VALUES ('164', '66');
INSERT INTO `music_album` VALUES ('165', '66');
INSERT INTO `music_album` VALUES ('166', '66');
INSERT INTO `music_album` VALUES ('167', '67');
INSERT INTO `music_album` VALUES ('168', '67');
INSERT INTO `music_album` VALUES ('169', '68');
INSERT INTO `music_album` VALUES ('170', '68');
INSERT INTO `music_album` VALUES ('171', '68');
INSERT INTO `music_album` VALUES ('172', '69');
INSERT INTO `music_album` VALUES ('173', '69');
INSERT INTO `music_album` VALUES ('216', '70');
INSERT INTO `music_album` VALUES ('217', '70');
INSERT INTO `music_album` VALUES ('215', '71');

-- ----------------------------
-- Table structure for music_comment
-- ----------------------------
DROP TABLE IF EXISTS `music_comment`;
CREATE TABLE `music_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`id`,`uid`,`mid`),
  KEY `FK_Music_MusicComment` (`mid`),
  KEY `FK_User_MusicComment` (`uid`),
  CONSTRAINT `FK_Music_MusicComment` FOREIGN KEY (`mid`) REFERENCES `music` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_User_MusicComment` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music_comment
-- ----------------------------

-- ----------------------------
-- Table structure for music_label
-- ----------------------------
DROP TABLE IF EXISTS `music_label`;
CREATE TABLE `music_label` (
  `mid` int(11) NOT NULL,
  `lid` int(11) NOT NULL,
  PRIMARY KEY (`mid`,`lid`),
  KEY `FK_Label_Music` (`lid`),
  CONSTRAINT `FK_Label_Music` FOREIGN KEY (`lid`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Music_Label` FOREIGN KEY (`mid`) REFERENCES `music` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music_label
-- ----------------------------
INSERT INTO `music_label` VALUES ('1', '1');
INSERT INTO `music_label` VALUES ('2', '1');
INSERT INTO `music_label` VALUES ('9', '1');
INSERT INTO `music_label` VALUES ('10', '1');
INSERT INTO `music_label` VALUES ('11', '1');
INSERT INTO `music_label` VALUES ('21', '1');
INSERT INTO `music_label` VALUES ('22', '1');
INSERT INTO `music_label` VALUES ('24', '1');
INSERT INTO `music_label` VALUES ('37', '1');
INSERT INTO `music_label` VALUES ('38', '1');
INSERT INTO `music_label` VALUES ('41', '1');
INSERT INTO `music_label` VALUES ('46', '1');
INSERT INTO `music_label` VALUES ('50', '1');
INSERT INTO `music_label` VALUES ('54', '1');
INSERT INTO `music_label` VALUES ('58', '1');
INSERT INTO `music_label` VALUES ('59', '1');
INSERT INTO `music_label` VALUES ('125', '1');
INSERT INTO `music_label` VALUES ('129', '1');
INSERT INTO `music_label` VALUES ('130', '1');
INSERT INTO `music_label` VALUES ('134', '1');
INSERT INTO `music_label` VALUES ('61', '2');
INSERT INTO `music_label` VALUES ('69', '2');
INSERT INTO `music_label` VALUES ('72', '2');
INSERT INTO `music_label` VALUES ('74', '2');
INSERT INTO `music_label` VALUES ('76', '2');
INSERT INTO `music_label` VALUES ('77', '2');
INSERT INTO `music_label` VALUES ('78', '2');
INSERT INTO `music_label` VALUES ('79', '2');
INSERT INTO `music_label` VALUES ('81', '2');
INSERT INTO `music_label` VALUES ('88', '2');
INSERT INTO `music_label` VALUES ('93', '2');
INSERT INTO `music_label` VALUES ('94', '2');
INSERT INTO `music_label` VALUES ('95', '2');
INSERT INTO `music_label` VALUES ('98', '2');
INSERT INTO `music_label` VALUES ('99', '2');
INSERT INTO `music_label` VALUES ('100', '2');
INSERT INTO `music_label` VALUES ('102', '2');
INSERT INTO `music_label` VALUES ('103', '2');
INSERT INTO `music_label` VALUES ('105', '2');
INSERT INTO `music_label` VALUES ('115', '2');
INSERT INTO `music_label` VALUES ('120', '2');
INSERT INTO `music_label` VALUES ('122', '2');
INSERT INTO `music_label` VALUES ('123', '2');
INSERT INTO `music_label` VALUES ('148', '3');
INSERT INTO `music_label` VALUES ('149', '3');
INSERT INTO `music_label` VALUES ('150', '3');
INSERT INTO `music_label` VALUES ('154', '3');
INSERT INTO `music_label` VALUES ('155', '3');
INSERT INTO `music_label` VALUES ('159', '3');
INSERT INTO `music_label` VALUES ('160', '3');
INSERT INTO `music_label` VALUES ('165', '3');
INSERT INTO `music_label` VALUES ('166', '3');
INSERT INTO `music_label` VALUES ('169', '3');
INSERT INTO `music_label` VALUES ('171', '3');
INSERT INTO `music_label` VALUES ('173', '3');
INSERT INTO `music_label` VALUES ('179', '3');
INSERT INTO `music_label` VALUES ('184', '3');
INSERT INTO `music_label` VALUES ('192', '3');
INSERT INTO `music_label` VALUES ('195', '3');
INSERT INTO `music_label` VALUES ('196', '3');
INSERT INTO `music_label` VALUES ('197', '3');
INSERT INTO `music_label` VALUES ('198', '3');
INSERT INTO `music_label` VALUES ('199', '3');
INSERT INTO `music_label` VALUES ('200', '3');
INSERT INTO `music_label` VALUES ('203', '3');
INSERT INTO `music_label` VALUES ('218', '3');
INSERT INTO `music_label` VALUES ('219', '3');
INSERT INTO `music_label` VALUES ('215', '4');
INSERT INTO `music_label` VALUES ('3', '5');
INSERT INTO `music_label` VALUES ('4', '5');
INSERT INTO `music_label` VALUES ('6', '5');
INSERT INTO `music_label` VALUES ('7', '5');
INSERT INTO `music_label` VALUES ('13', '5');
INSERT INTO `music_label` VALUES ('14', '5');
INSERT INTO `music_label` VALUES ('16', '5');
INSERT INTO `music_label` VALUES ('17', '5');
INSERT INTO `music_label` VALUES ('19', '5');
INSERT INTO `music_label` VALUES ('31', '5');
INSERT INTO `music_label` VALUES ('34', '5');
INSERT INTO `music_label` VALUES ('40', '5');
INSERT INTO `music_label` VALUES ('43', '5');
INSERT INTO `music_label` VALUES ('45', '5');
INSERT INTO `music_label` VALUES ('49', '5');
INSERT INTO `music_label` VALUES ('55', '5');
INSERT INTO `music_label` VALUES ('56', '5');
INSERT INTO `music_label` VALUES ('57', '5');
INSERT INTO `music_label` VALUES ('62', '5');
INSERT INTO `music_label` VALUES ('63', '5');
INSERT INTO `music_label` VALUES ('91', '5');
INSERT INTO `music_label` VALUES ('92', '5');
INSERT INTO `music_label` VALUES ('96', '5');
INSERT INTO `music_label` VALUES ('104', '5');
INSERT INTO `music_label` VALUES ('112', '5');
INSERT INTO `music_label` VALUES ('116', '5');
INSERT INTO `music_label` VALUES ('117', '5');
INSERT INTO `music_label` VALUES ('177', '5');
INSERT INTO `music_label` VALUES ('65', '6');
INSERT INTO `music_label` VALUES ('66', '6');
INSERT INTO `music_label` VALUES ('68', '6');
INSERT INTO `music_label` VALUES ('70', '6');
INSERT INTO `music_label` VALUES ('106', '6');
INSERT INTO `music_label` VALUES ('108', '6');
INSERT INTO `music_label` VALUES ('111', '6');
INSERT INTO `music_label` VALUES ('118', '6');
INSERT INTO `music_label` VALUES ('119', '6');
INSERT INTO `music_label` VALUES ('136', '6');
INSERT INTO `music_label` VALUES ('163', '6');
INSERT INTO `music_label` VALUES ('25', '8');
INSERT INTO `music_label` VALUES ('67', '8');
INSERT INTO `music_label` VALUES ('73', '8');
INSERT INTO `music_label` VALUES ('87', '8');
INSERT INTO `music_label` VALUES ('89', '8');
INSERT INTO `music_label` VALUES ('97', '8');
INSERT INTO `music_label` VALUES ('107', '8');
INSERT INTO `music_label` VALUES ('121', '8');
INSERT INTO `music_label` VALUES ('141', '8');
INSERT INTO `music_label` VALUES ('151', '8');
INSERT INTO `music_label` VALUES ('152', '8');
INSERT INTO `music_label` VALUES ('153', '8');
INSERT INTO `music_label` VALUES ('161', '8');
INSERT INTO `music_label` VALUES ('164', '8');
INSERT INTO `music_label` VALUES ('8', '9');
INSERT INTO `music_label` VALUES ('12', '9');
INSERT INTO `music_label` VALUES ('15', '9');
INSERT INTO `music_label` VALUES ('20', '9');
INSERT INTO `music_label` VALUES ('44', '9');
INSERT INTO `music_label` VALUES ('47', '9');
INSERT INTO `music_label` VALUES ('48', '9');
INSERT INTO `music_label` VALUES ('51', '9');
INSERT INTO `music_label` VALUES ('52', '9');
INSERT INTO `music_label` VALUES ('53', '9');
INSERT INTO `music_label` VALUES ('71', '9');
INSERT INTO `music_label` VALUES ('127', '9');
INSERT INTO `music_label` VALUES ('142', '9');
INSERT INTO `music_label` VALUES ('144', '9');
INSERT INTO `music_label` VALUES ('145', '9');
INSERT INTO `music_label` VALUES ('146', '9');
INSERT INTO `music_label` VALUES ('172', '9');
INSERT INTO `music_label` VALUES ('174', '9');
INSERT INTO `music_label` VALUES ('175', '9');
INSERT INTO `music_label` VALUES ('176', '9');
INSERT INTO `music_label` VALUES ('185', '9');
INSERT INTO `music_label` VALUES ('187', '9');
INSERT INTO `music_label` VALUES ('190', '9');
INSERT INTO `music_label` VALUES ('201', '9');
INSERT INTO `music_label` VALUES ('206', '9');
INSERT INTO `music_label` VALUES ('207', '9');
INSERT INTO `music_label` VALUES ('208', '9');
INSERT INTO `music_label` VALUES ('212', '9');
INSERT INTO `music_label` VALUES ('213', '9');
INSERT INTO `music_label` VALUES ('214', '9');
INSERT INTO `music_label` VALUES ('18', '10');
INSERT INTO `music_label` VALUES ('101', '10');
INSERT INTO `music_label` VALUES ('137', '10');
INSERT INTO `music_label` VALUES ('139', '10');
INSERT INTO `music_label` VALUES ('140', '10');
INSERT INTO `music_label` VALUES ('162', '10');
INSERT INTO `music_label` VALUES ('168', '10');
INSERT INTO `music_label` VALUES ('170', '10');
INSERT INTO `music_label` VALUES ('181', '10');
INSERT INTO `music_label` VALUES ('182', '10');
INSERT INTO `music_label` VALUES ('188', '10');
INSERT INTO `music_label` VALUES ('211', '10');
INSERT INTO `music_label` VALUES ('216', '10');
INSERT INTO `music_label` VALUES ('217', '10');
INSERT INTO `music_label` VALUES ('131', '11');
INSERT INTO `music_label` VALUES ('133', '11');
INSERT INTO `music_label` VALUES ('135', '11');
INSERT INTO `music_label` VALUES ('178', '11');
INSERT INTO `music_label` VALUES ('186', '11');
INSERT INTO `music_label` VALUES ('189', '11');
INSERT INTO `music_label` VALUES ('5', '12');
INSERT INTO `music_label` VALUES ('30', '12');
INSERT INTO `music_label` VALUES ('60', '12');
INSERT INTO `music_label` VALUES ('124', '12');
INSERT INTO `music_label` VALUES ('126', '12');
INSERT INTO `music_label` VALUES ('132', '12');
INSERT INTO `music_label` VALUES ('138', '12');
INSERT INTO `music_label` VALUES ('147', '12');
INSERT INTO `music_label` VALUES ('167', '12');
INSERT INTO `music_label` VALUES ('180', '12');
INSERT INTO `music_label` VALUES ('209', '12');
INSERT INTO `music_label` VALUES ('28', '13');
INSERT INTO `music_label` VALUES ('29', '13');
INSERT INTO `music_label` VALUES ('33', '13');
INSERT INTO `music_label` VALUES ('36', '13');
INSERT INTO `music_label` VALUES ('39', '13');
INSERT INTO `music_label` VALUES ('156', '13');
INSERT INTO `music_label` VALUES ('157', '13');
INSERT INTO `music_label` VALUES ('158', '13');
INSERT INTO `music_label` VALUES ('193', '13');
INSERT INTO `music_label` VALUES ('194', '13');
INSERT INTO `music_label` VALUES ('202', '13');
INSERT INTO `music_label` VALUES ('210', '13');
INSERT INTO `music_label` VALUES ('82', '14');
INSERT INTO `music_label` VALUES ('85', '14');
INSERT INTO `music_label` VALUES ('86', '14');
INSERT INTO `music_label` VALUES ('90', '14');
INSERT INTO `music_label` VALUES ('128', '14');
INSERT INTO `music_label` VALUES ('23', '15');
INSERT INTO `music_label` VALUES ('26', '15');
INSERT INTO `music_label` VALUES ('27', '15');
INSERT INTO `music_label` VALUES ('32', '15');
INSERT INTO `music_label` VALUES ('35', '15');
INSERT INTO `music_label` VALUES ('42', '15');
INSERT INTO `music_label` VALUES ('183', '15');
INSERT INTO `music_label` VALUES ('75', '17');
INSERT INTO `music_label` VALUES ('109', '17');
INSERT INTO `music_label` VALUES ('110', '17');
INSERT INTO `music_label` VALUES ('113', '18');
INSERT INTO `music_label` VALUES ('143', '18');
INSERT INTO `music_label` VALUES ('83', '19');
INSERT INTO `music_label` VALUES ('84', '19');
INSERT INTO `music_label` VALUES ('114', '19');
INSERT INTO `music_label` VALUES ('191', '19');
INSERT INTO `music_label` VALUES ('205', '20');
INSERT INTO `music_label` VALUES ('64', '21');
INSERT INTO `music_label` VALUES ('80', '21');
INSERT INTO `music_label` VALUES ('204', '21');

-- ----------------------------
-- Table structure for playlist
-- ----------------------------
DROP TABLE IF EXISTS `playlist`;
CREATE TABLE `playlist` (
  `mid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`mid`,`uid`),
  KEY `FK_PlayList_User` (`uid`),
  CONSTRAINT `FK_PlayList_Music` FOREIGN KEY (`mid`) REFERENCES `music` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_PlayList_User` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playlist
-- ----------------------------

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `lang` varchar(50) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `introduction` text,
  `is_band` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('23', '薛之谦', '1', 'Chinese', 'music/23/23.jpg', '2004年,第一次参加大型歌唱比赛莱卡我型我Show全国偶像歌手大赛,但其后由于种种原因退出比赛。\r\n\r\n2005年再次站上了我型我Show的舞台。赛后成功签约上腾娱乐,成为一名艺人。\r\n\r\n2006年6月9日，薛之谦发行首张个人原创同名专辑《薛之谦》。\r\n\r\n2015年4月1日，薛之谦主演《男人帮·朋友》预告片发布 ；6月10日正式签约海蝶音乐公司，升为制作人。\r\n\r\n代表作品\r\n认真的雪，2006年专辑《薛之谦》\r\n未完成的歌，2009年专辑《未完成的歌》', '0');
INSERT INTO `singer` VALUES ('24', '林俊杰', '1', 'Chinese', 'music/24/24.jpg', '林俊杰，2003年，发行首张全创作专辑《乐行者》。虽然时逢SARS，但他和团队不轻言放弃，在3个月内走遍26个城市，进行了上百场演出，奠定了之后在中国大陆的稳固基础。2004年，游走大陆，让从小接受英语教育的林俊杰首次体验中华文化所带来的冲击，结合西方R&B现代曲风以及中国风的《江南》（台版为《第二天堂》）专辑由此诞生，同年更凭借《乐行者》专辑拿下第15届台湾金曲奖最佳新人奖。2005年，赴美国LA向音乐大师Seth Riggs学习唱歌技巧，同时林俊杰也成为Seth Riggs的第一位亚洲学生；3月25日，发行第三张创作专辑《编号89757》， 2007年，以人性的善恶纠结为基础，大胆推出更具突破性的专辑《西界》。代表作品，就是我，2003年专辑《乐行者》\r\n一千年以后，2005年专辑《编号89757》小酒窝，2008年专辑《JJ陆》我还想她，2008年专辑《JJ陆》', '0');
INSERT INTO `singer` VALUES ('25', '王菲', '0', 'Chinese', 'music/25/25.jpg', '1989年，王菲以一首《仍是旧句子》在《亚太金铮流行曲创作大赛》决赛中获铜奖。并于10月推出首张个人大碟《王靖雯》，销量突破3万，获金唱片。1990年发行第二个人大碟《EVERTHING》，以及8月份发行的《YOU ARE THE ONLYONE》 ，并获得得“叱咤乐坛流行榜女歌手铜奖”。1992年7月王菲推出第四张专辑《Coming Home》，专辑推出销量冲破三白金。其中歌曲《容易受伤的女人》受到欢迎，不仅在香港各大排行榜名列冠军，还在年终颁奖礼上获得了多个奖项。1993年2月5日，以王靖雯名发行粤语专辑《执迷不悔》，专辑曲风有灵魂乐式的演唱色彩并让王菲获得香港十大中文金曲奖、十大劲歌金曲。1994年4月，发行首张国语大碟《迷》，主打歌《我愿意》被众多歌手翻唱，是被翻唱成最多外国语言的中文歌曲。代表作品：人间，1997年专辑《王菲》；红豆，1998年专辑《唱游》；但愿人长久，1999年专辑《但愿人长久》；我愿意，2006年专辑《曾经拥有》；致青春，2013年专辑《致青春》', '0');
INSERT INTO `singer` VALUES ('26', '张韶涵', '0', 'Chinese', 'music/26/26.jpg', '张韶涵（Angela Zhang），生于中国台湾省桃园县，中国台湾女歌手、演员，毕业于加拿大温斯顿爵士邱吉尔中等学校。2001年《MVP情人》挑选女主角，张韶涵3秒钟的VCR得到了这个角色正式开始了演艺生涯。《MVP情人》在华视获得了5.02%的收视率。2003年张韶涵主演的电视剧《海豚湾恋人》播出，该剧入围台湾金钟奖，使张韶涵的演艺事业更上一层楼；此外张韶涵演唱的《遗失的美好》作为《海豚湾恋人》的片尾曲也开始走红。2004年张韶涵发行第一张专辑《Over The Rainbow》并且凭借该专辑获得百事音乐风云榜最佳新人奖。年底张韶涵发行第二张专辑《欧若拉》并凭借其入围第16届“金曲奖”最佳国语女演唱人。除此之外张韶涵还受邀参加韩国SBS电视台Kim Yoon A\'s Music wave的演出,由此成为第1个踏上SBS音乐节目舞台的华人歌手。代表作品歌曲有遗失的美好，2004年专辑《Over The Rainbow》欧若拉，2004年专辑《欧若拉》隐形的翅膀，2006年专辑《潘朵拉》亲爱的那不是爱情，2007年专辑《Ang5.0》影视有海豚湾恋人，2003年中国台湾爱情偶像剧公主小妹，2007年中国台湾偶像剧', '0');
INSERT INTO `singer` VALUES ('27', '牛奶咖啡', null, 'Chinese', 'music/27/27.jpg', '“牛奶咖啡”的成立充满了传奇色彩,主唱 KiKi(富妍) 念高中的时候通过 QQ 认识了格非,二人通过网络交流音乐创作。进入大学后,KiKi、格非与另外两位同学组建了乐队,大家兴致高昂的参加了某著名大学生校园乐队比赛,结果在初赛即被淘汰。那一次失败后,他们的乐队也因为另外两位成员先后毕业离京而被迫解散。但是 KiKi 和格非并没有放弃对的音乐梦想,他们随后便组成了“牛奶@咖啡”。而他们创作音乐的目的仅仅是出于他们对生活的热爱和随意的幽默感,没想到意外被摩登天空唱片公司慧眼相中,成为力捧的新人。', '1');
INSERT INTO `singer` VALUES ('28', '羽泉', null, 'Chinese', 'music/28/28.jpg', '1998年，陈羽凡与胡海泉组合，同年11月17日签约滚石唱片，羽泉正式诞生。1999年，羽泉推出首张专辑《最美》，销量即破百万。2000年，羽泉推出第二张专辑《冷酷到底》，销量破百万，2000年内地销量冠军，主打歌《冷酷到底》获得中国原创歌曲总评榜当年年度金曲。2001年，羽泉推出第三张专辑《热爱》，成为内地歌手中第一个3年连续推出3张专辑销量均突破百万的歌手。2003年，羽泉推出第四张专辑《没你不行》，获得国际唱片业协会(IFPI)颁发白金唱片销量认证书， 在上海举办了第一次演唱会。2004年，羽泉离开滚石唱片，签约华谊音乐。2006年，羽泉推出第六张专辑《朋友难当》，专辑首次选用了双主打歌的形式。专辑主打歌《朋友难当》获得第十四届中国歌曲排行榜年度金曲。代表作品：最美，1999年专辑《最美》；冷酷到底，2000年专辑《冷酷到底》；深呼吸，2001年专辑《热爱》；奔跑，2003年黄征专辑《爱情诺曼底》', '1');
INSERT INTO `singer` VALUES ('29', 'Justin Bieber', '1', 'English', 'music/29/29.jpg', '加拿大少年歌手Justin Bieber，早期因为在YouTube翻唱其他艺人的歌曲而出名，为亚瑟小子（Usher）所赏识，而目前已与小岛唱片（Island Records）签约，居住在美国洛杉矶，并已于2009年11月17日发行他的第一张专辑《我的世界》（My World）的第一部分。[2] 截止发行后第五周，该唱片已在美国售出百万张，并在加拿大被认证为城市唱片[3]。专辑的第二部分已于2010年3月发行。身体有多处刺青，左边小腿有“Jesus”刺青[4]。Justin Bieber于2011年冬季出版第二张专辑《Under the mistletoe》，于2012年春季发行第三张专辑《Believe》，让Justin Bieber正式成为美国热门歌手之一，也是最年轻便抢攻音乐排行榜前几名的歌手。他是YouTube观看量最多的艺人及首位19岁前拥有五张冠军专辑、在首张专辑发行前就有4首TOP40单曲的歌手。2011《人物》杂志公布的年度好莱坞最富有的年轻人。在“福布斯全球百位巨星排行榜”上贾斯汀连续2年名列第三，男歌手权利排行第一，推特粉丝全球第一。Billboard与VH1评选的当今最具影响童星。', '0');
INSERT INTO `singer` VALUES ('30', 'Adam Lambert', '1', 'English', 'music/30/30.jpg', '亚当·米歇尔·兰伯特（Adam Mitchel Lambert，1982年1月29日－）美国流行歌手。生于印第安纳州首府印第安纳波利斯，成长于一个犹太人家庭，是选秀节目美国偶像第八季参赛选手，亮眼的歌唱表现惊艳全美，获得评审高度赞赏，是美国偶像有史以来最受关注的选手之一。最后因选票及性取向等争议错失冠军Adam Lambert，获第53届格莱美奖最佳流行男歌手提名。亦是美国偶像有史以来最惊艳人心的选手。不羁的黑发，狂野的眼线，黑色指甲油，这已成为他的标志。这位被誉为“Rock God ” 的音乐天才，融合霸气、狂妄、才华於一身的表演魅力和惊人的歌唱实力，以及幽默且不卑不亢的品格，让他一出道便成为全美关注的超级新星。Adam Lambert风暴已经席卷而来，这不仅昭告着“Glam Rock”的强势回归，更标志着迷惑摇滚在新流行乐时代的复活和与之融合。', '0');
INSERT INTO `singer` VALUES ('31', 'Shakira', '0', 'English', 'music/31/31.jpg', '夏奇拉·伊莎贝尔·迈巴拉克·里波尔，出生于哥伦比亚小城，而今，Shakira除了一再地获得各种音乐奖项的肯定外，更被极具影响力与极高荣耀指标的美国时代杂志选为杂志封面人物，被推举为当今Latin艺人的代表人物。夏奇拉将在2010南非世界杯的闭幕式上演唱她专门为南非世界杯创作的歌曲《Waka Waka（This Time for Africa）》，这首歌的创作灵感来自喀麦隆音乐，而waka在非洲语言里，是火焰的意思，寓意足球之火将遍布非洲。代表作品：Hips Don’t Lie，2006年单曲Waka Waka (This Time For Africa)，2010南非世界杯主题曲。主要成就：2011 拉丁格莱美奖年度专辑奖（提名）；2000 拉丁格莱美奖最佳拉丁流行专辑奖  （获奖）', '0');
INSERT INTO `singer` VALUES ('32', 'Backstreet Boys', null, 'English', 'music/32/32.jpg', '后街男孩（英文：Backstreet Boys，缩写：BSB）是一支美国流行乐组合，1993年于美国佛罗里达州奥兰多市成立，其成员分别为：尼克·卡特、霍伊·多罗夫、布莱恩·利特尔、亚历山大·詹姆斯·迈克林和凯文·理查德森成立之初五位成员都不过十几岁。至今为止他们已经在美国销售了3800万张唱片，全球销量近1.3亿张，是自1990年代中期来最受欢迎的男生组合。由于他们在美国当时是较早的一个男孩团体，所以被誉为“男孩团体皇上皇”。', '1');
INSERT INTO `singer` VALUES ('33', 'Carpenters', null, 'English', 'music/33/33.jpg', 'The Carpenters(卡朋特乐队)\r\n是美国歌星理查德·卡朋特和卡伦·卡朋特兄妹二人组成的演唱组合,1970年代和1980年代初期风靡一时。卡朋特兄妹于1965年开始组织乐队,1969年11月15日,卡朋特乐队的单曲《Close to You》（靠近你）一举走红,其后,他们在整个1970年代大获成功。《Yesterday Once More》（昨日重现）、《Top of the World》（世界之颠）、《Please Mr. Postman》（请等一下,邮差先生）等歌曲广为人知。1983年2月4日,卡伦·卡朋特因长期严重神经性厌食症而突然去世,卡朋特乐队随之告终。尼克松总统称卡朋特兄妹是最出色的美国青年。代表作品：Close to You，1970年专辑《Close to You》；Top of the World，1972年专辑《A Song for You》；Yesterday Once More，1973年专辑《Now & Then》；The End of the World，1973年专辑《Now & Then》', '1');
INSERT INTO `singer` VALUES ('34', '黄致列', '1', 'Korean', 'music/ 34/34.jpg', '黄致列（황치열），1982年12月3日出生于韩国庆尚北道龟尾市，韩国流行乐男歌手、声乐老师，毕业于韩国第六理工大学（한국폴리텍6대학）龟尾校区机械工程系。2007年，推出首张个人EP专辑《致列》，从而正式出道。2010年，与Han Kook组成的二人男子团体Wednesday。2014年，黄致列改艺名为“Ten2”，并担任Infinite的声乐指导老师。2015年，黄致列以选手身份参加Mnet音乐推理节目《看见你的声音》的录制；同年，推出个人单曲《铅笔》 。2016年，作为首发阵容参加湖南卫视歌唱真人秀《我是歌手第四季》的比赛，最终获得总决赛季军 ；同年7月20日，推出首支个人中文数字单曲《最远的距离》。', '0');
INSERT INTO `singer` VALUES ('35', 'Rain', '1', 'Korean', 'music/35/35.jpg', '2002年一出道即囊括了几乎全韩国媒体新人奖的第一新人，也号称是突破大家对单眼皮小眼睛男生审美观的第一人。在首支单曲《坏男人》的MV中，以其充满爆发力的舞蹈、独特的外貌和国际性的全方位性感魅力，成为韩国头号师奶杀手，并深受多家广告厂商青睐，一举跃上2002年广告新人王宝座。2003以后在电视界和音乐界都交出了十分优异的成绩单，成为韩国歌而优则演的艺人中最成功典范；同时夺得KBS歌谣最高荣誉，成为当今韩国娱乐圈最具价值的的艺人。', '0');
INSERT INTO `singer` VALUES ('36', 'PSY', '1', 'Korean', 'music/36/36.jpg', '朴载相，外文名：PSY，别名：鸟叔，出生于1977年12月31日，毕业于美国伯克利音乐学院，2001年正式的出道，2010年8月签入YG Entertainment，是韩国很著名的R&B实力派歌手，“鸟叔”之名大概是源自于他2001年1月18日发行的正式一辑《PSY来自神经质的世界》中的歌曲《鸟》，这首歌当时在席卷韩国，让鸟叔人气飙升。让鸟叔真正在全球火起来的，是2012年的《江南Style》，2012年11月8日，韩国歌手PSY的《江南Style》获得了吉尼斯认证,打破youtube吉尼斯世界纪录.被评为史上最多网民“Like”数最多的视频。PSY以其出色的歌唱和舞蹈实力被认可，加上他独特的台风及亲自撰写讽刺时弊的歌词，受到了广大歌迷的青睐。另外，PSY还有着非常High的现场live实力。2013年4月12日发行的新歌《Gentleman》MV中有Brown Eyed Girls成员佳仁性感参演，点击率再创新高！', '0');
INSERT INTO `singer` VALUES ('37', 'G-Dragon', '1', 'Korean', 'music/37/37.jpg', 'G-DRAGON（权志龙），1988年8月18日出生于韩国首尔，韩国男歌手，男子演唱组合BIGBANG队长，所属经纪公司YG Entertainment词曲制作人。\r\n2001年，因参与特别企划专辑《大韩民国Hip-Hop Flex》而正式出道，2009年，发行第一张专辑《Heartbreaker》，之后陆续推出专辑《ONE OF A KIND》和《COUP D\'ETAT》。2012年9月15日，发行第二张专辑《One of a kind》。2013年9月，推出专辑《COUP D\'ETAT》。2013年8月31日至9月1日，在首尔奥林匹克体操竞技场举办演唱会。2013年，获得MAMA“年度最佳歌手”、“最佳男歌手”、“最佳舞蹈表演男歌手”、“最佳音乐录影带”奖项。2014年，创作发行单曲《Good Boy》。2016年9月1日，随组合BIGBANG正式发行专辑《MADE SERIES》。7月，随组合BIGBANG一起拍摄的电影《BIGBANG MADE》正式上映。 ', '0');
INSERT INTO `singer` VALUES ('38', '蔡妍', '0', 'Korean', 'music/38/38.jpg', '韩国著名流行歌手，有着“国民姐姐”、“性感元祖”和“韩国Beyonce”之称。以独特的舞蹈风格被人熟知，2003年发布《危险的演出》后使她迅速走红，2004年的大热舞曲《两个人》把她推向事业顶峰，2005年的《只有你》、2007年《My Love》及2009年《Shake》等歌曲让她标志性的舞曲奠定了“电音女王”地位。同时从出道至今一直积极投入韩国综艺的录制，在节目中敢于舍弃偶像形象搞笑，活泼机智的傻大姐兼小可爱形象深得人心。2008年被任命为中韩慈善大使，2009年任首尔大众交通健康形象代言人。', '0');
INSERT INTO `singer` VALUES ('39', '李孝利', '0', 'Korean', 'music/39/39.jpg', '李孝利，出生于1979年5月10日，韩国性感人气歌手。1998年，李孝利与李真、玉珠铉、成宥利组成四人女子组合Fin. K.L.（全名Fine Killing Liberty），并担任队长，在韩国迅速走红。2003年8月17日，李孝利通过SBS《人气歌谣》第1次一个人站在舞台上公开演出，开始了SOLO歌手生涯，专辑主打歌《10 Minutes》在整个韩国掀起狂潮！暌违三年最新专辑《Monochrome》已于2013年5月21日发行，首波主打曲《Bad Girls》攻占韩国各大排行榜。人气歌曲：《Hey Mr. Big》《U-Go-Girl 》《Anyclub》《10 Minutes》等。', '0');
INSERT INTO `singer` VALUES ('40', '泫雅', '0', 'Korean', 'music/40/40.jpg', '金泫雅，出生于1992年06月06日，CUBE Entertainment旗下艺人，女子组合4MINUTE成员之一，外表甜美可爱的她舞蹈性感、节奏强劲，被称为大韩民国最会跳舞的女艺人。泫雅原是Wonder Girls成员，2009年6月18日，以4minute组合成员身份正式复出，以首张单曲《HOT ISSUE》正式出道。2010年1月4日泫雅发表了她的个人单《Change》。2012客串了Psy的《江南style》，后来又演唱了女版《哥哥就是我的Style》。而泫雅个人第二张迷你专辑《MELTING》一经发出，主打歌《Ice Cream》在YouTube里的点击量不到三天就打破了韩国神曲“江南style”的记录，成为了韩国娱乐界在国际的代表人物之一。代表作品：《Change》《Bubble Pop》《Icecream》等。', '0');
INSERT INTO `singer` VALUES ('41', '尹美莱', '0', 'Korean', 'music/41/41.jpg', '尹美莱在现在的韩国是首屈一指的女RAPPER，绝对的大前辈，老公更是RAP圈内的大佬，两个人堪称韩国HIP POP 音乐的最高结合，可以毫不夸张地说是韩国的Beyonce和Jay-Z。', '0');
INSERT INTO `singer` VALUES ('42', 'T-ara', null, 'Korean', 'music/42/42.jpg', 'T-ara，别称“皇冠团”，拥有“韩国最百变女团”、“歌谣界的变色龙”等美誉，是M-net公司准备了三年时间的女子组合，于2009年7月29日出道，由全宝蓝、李居丽、朴素妍、咸恩静、朴孝敏、朴智妍六名散发不同魅力的成员组成。组合名称T-ara源自英文Tiara，意指将成为歌谣界的女王。T-ara以无限挑战的团队宗旨完美诠释了百变的无尽吸引力及超高风格驾驭力，如今不仅在歌谣界发光发热，更是在影视界、艺能界小有建树，是韩国极具代表性的偶像团体之一。主要代表作品有《Bo peep Bo peep》《Roly Poly》《Cry Cry》《lovey dovey》等。', '1');
INSERT INTO `singer` VALUES ('43', 'BIGBANG', null, 'Korean', 'music/43/43.jpg', 'Bigbang是于2006年出道的韩国组合，由队长权志龙(G-Dragon)、崔胜铉(T.O.P)、东永裴(太阳)、姜大声、李胜贤(胜利)五位成员组成。2006年8月19日，Bigbang在YG Family世界巡回演唱会首尔站上正式出道，并于同年12月22日发行首张正规专辑《BIGBANGVOL.1 SINCE2007》。2007年5月，Bigbang开始进行全国巡回演唱会，并于7月推出了第一张迷你专辑《谎言》。2011年，BigBang成为历史上第一个获得MTV 欧洲音乐大奖“Worldwide Act”的亚洲组合，并于2012年上半年登上美国格莱美官方网页，成为首个被格莱美介绍的韩国歌手。', '1');
INSERT INTO `singer` VALUES ('44', 'EXO', null, 'Korean', 'music/44/44.jpg', 'EXO是韩国SM娱乐有限公司于2012年4月8日正式推出的12人男子流行演唱团体。现以金珉锡、金俊勉、张艺兴、边伯贤、金钟大、朴灿烈、都暻秀、金钟仁、吴世勋9名成员的形式展开活动。EXO这个名字从意为太阳系以外的外部行星EXO PLANET一词中得来，蕴含了他们是从未知的世界来的新星之意。', '1');
INSERT INTO `singer` VALUES ('45', 'AOA', null, 'Korean', 'music/45/45.jpg', 'AOA（Ace Of Angels）是FNC Music公司继FT Island、CNBLUE后推出的又一实力组合，是FNC娱乐首支女团。AOA由7名Ace angels与1名Half angel组成。AOA是韩国的女子乐团和舞蹈组合，现任成员为申智玟，朴草娥，徐宥那，徐有庆，申惠晶，权玟娥，金雪炫，金澯美，成员们都有著一个特别的天使名字。而天使故事就是七位天使与连结地面之门的钥匙持有者，半天使Y发生的奇妙故事。七位天使经常透过水晶球看人类的世界，透过水晶球她们喜爱上了人类的音乐，忍不住好奇的Y，於是利用手上的钥匙，开启了地面之门，与七位天使来到地球。', '1');
INSERT INTO `singer` VALUES ('46', 'GReeeeN', null, 'Japanese', 'music/46/46.jpg', 'GREEEEN是日本4人组 J-POP 和声组合，由HIDE（ヒデ）、navi（ナビ）、92（クニ）、SOH（ソー）组成。所属标签NAYUTAWAVE RECORDS,所属事务所为UNDER HORSE RECORDS。2007年出道时，全部团员就读于福岛县某大学内的牙医学系，2007年,1月24日,发行单曲《道》正式Major出道，3月，发行第二张单曲《HIGH G.K LOW》并tie-up了雪碧的广告曲，但至此都表现平平。5月16日,第3张单曲《爱呗》发售,迎来了爆发。', '1');
INSERT INTO `singer` VALUES ('47', 'ONE OK ROCK', null, 'Japanese', 'music/47/47.jpg', 'ONE OK ROCK（ワンオクロック），日本AMUSE事务所四人乐队，现任成员：Taka(タカ，Vocal&Guitar)、Toru(トオル，Guitar&Vocal)、Ryota(リョータ，Bass)、Tomoya (トモヤ，Drums)。2005年夏天，Toru和他高中的好朋友ALex以及Ryota一起在准备好他们自己的乐器后组成了摇滚乐队ONE OK ROCK，之后Taka加入他们。2006年7月26日凭借第一张迷你专辑「ONE OK ROCK」出道，销量不错。2007的4月新成员鼓手Tomoya正式加入，4月25日推出的新五人乐团以单曲「内秘心书」同样大受好评。2009年4月5日，吉他手Alex丑闻发生，被逮捕。同年9月，活动再开。2010年2月3日，复归后发布“完全感觉Dreamer”的Oricon单曲榜的乐队首次进入TOP10。同年8月，ROCK IN JAPAN FESTIVAL·SUMMER SONIC·MONSTER baSH等的大型连续出演到夏天结束。11月28日职业首次在日本武道馆进行现场录音。代表作品：《The Beginning》《Re:make》。', '1');
INSERT INTO `singer` VALUES ('48', 'Zone', null, 'Japanese', 'music/48/48.jpg', 'ZONE是北海道札幌的演员培训学校RUNTIME培训出来的4人女子乐队，1997年以8人数结成，2001年以4人数正式出道，为索尼音乐唱片公司旗下事务所RUNTIME旗下艺人。2003年底有过一次人员更替，2005年中在日本武道馆举行ZONE Final 解散。2011年8月由3名成员实现了重组，2011年底一人病退。MIYU和MAIKO作为二人组合活动至2013年2月13日，主唱MIYU被事务所解约后仅剩MAIKO一人在4月7日举行Final Event，然后再度解散。至此，ZONE不复存在。\r\n队员有TAKAYO、MAIKO、MIYU、MIZUHO（此张专辑由MIYU和MAIKO完成）', '1');
INSERT INTO `singer` VALUES ('49', '岸部眞明', '1', 'Japanese', 'music/49/49.jpg', '岸部真明（Masaaki Kishibe）是日本新生代指弹吉他演奏家，日本finger-style大师Isato Nakagawa的学生。其作品风格非常的多元化，既有优美清新的吉他独奏小品，又有另类的独奏作品。他于2003年参加了National Fingerstyle Guitar Championships，并获得了第2名的好成绩，展现了其非凡的实力。\r\n所演奏曲目中，揉合了他细腻的情感与娴熟的演奏技巧，展现了多元的面貌，营造出极具情景和画面的音乐张力。', '0');
INSERT INTO `singer` VALUES ('50', '玉置浩二', '1', 'Japanese', 'music/50/50.jpg', '玉置浩二1958年9月13日出生，日本音乐家、演员，Sony Music Records旗下歌手是中国人最熟悉的日本流行歌手之一，他是被香港明星们翻唱得最多的日本歌手，从黎明、郭富城、张国荣、张学友等大牌歌手都指名翻唱过他的歌曲。热门歌曲《Friend（张学友 沉默的眼睛原曲）》《向悲哀说再见》等。', '0');
INSERT INTO `singer` VALUES ('51', '尾崎丰', '1', 'Japanese', 'music/51/51.jpg', '尾崎丰1965年11月29日出生於东京都世田谷区的一个公务员家庭。1981年就读于青山学院高中部。1983年凭《17岁的地图》和《15の夜》两首歌曲在歌坛崭露头角，同年推出的首张个人专辑《17岁的地图》使尾崎丰以惊人的速度一下子成为日本歌坛耀眼的明星。', '0');
INSERT INTO `singer` VALUES ('52', '小田和正', '1', 'Japanese', 'music/52/52.jpg', '小田和正是一位日本知名的男歌手，于1969年初与高中同学铃木康博等人创立乐团“Off Course”，并担任该乐团主唱。1989年2月26日Off Course于东京巨蛋举行告别演唱会后，正式解散。1991年，小田和正以《突如其来的爱情故事》并搭配日剧《东京爱情故事》主题曲而再创高峰。其2002年发表之精选辑《自己BEST》进入Oricon专辑榜至今已超过360周（七年），为日本音乐史上入榜周数最高之专辑。小田和正在日本属于80年代就红透半边天的创作型天才歌手，与之比肩的大概只有飞鸟凉（CHAGE&ASKA），歌声纯正优美感人至深，而且创作量与质量可以说是齐头并进。', '0');
INSERT INTO `singer` VALUES ('53', '浜崎あゆみ', '0', 'Japanese', 'music/53/53.jpg', '滨崎步（浜崎 あゆみ）出生于1978年10月2日，1998年出道，1999年一跃成名，席卷2000年代至今的亚洲音乐界，与宇多田光、仓木麻衣并称日本平成三大歌姬，是亚洲歌坛重量级女歌手，亚洲流行天后，日本歌坛流行教主。截至目前，滨崎步在日本本土的唱片总销量已经达到5034万张，是日本音乐史上第一位唱片销量突破5000万张的女性歌手，也是日本音乐史上唱片销量最高的女性歌手和个人歌手，代表作有《M》、《Seasons》、《Dearest》等。', '0');
INSERT INTO `singer` VALUES ('54', '仓木麻衣', '0', 'Japanese', 'music/54/54.jpg', '仓木麻衣（くらき まい，Kuraki Mai），日本著名女歌手，亚洲流行歌坛天后。她在看过一部关于迈克尔·杰克逊的生活电影和惠特尼·休斯顿的音乐会后就梦想成为一名歌手。1999年推出单曲《Love Day After Tomorrow》后大获成功，销量达到138万张。其后凭借首张大碟《Delicious Way》获得了2000年度细碟销量冠军（353万张）和大碟销量亚军、最佳作词、最出色新人奖和最高唱片收入亚军等五个奖项，并打破了原来的R&B小天后宇多田光的纪录，和滨崎步并列第一（总销量第二），出道不到一年就被公认为唯一可以威胁另外两大天后的新天后。', '0');
INSERT INTO `singer` VALUES ('55', '宇多田ヒカル', '0', 'Japanese', 'music/55/55.jpg', '宇多田ヒカル（宇多田光）出生在一个音乐世家，小名叫Hikki，出生生长在美国，她的母亲藤圭子是日本七十年代著名的流行歌曲歌手，父亲是唱片制作人，所以她成长中的很多时间都与父亲在演播室度过。1998年12月9日宇多田光正式在日本出道，首张日文专辑《First Love》在日本创造765万张的惊人销量，成为日本史上销量最高专辑，同时也是亚洲乐坛历史上最畅销的唱片。截至目前，宇多田光在日本的唱片总销量已经突破3800万张，位列日本艺人唱片销量榜第九位，为前十艺人中最年轻的；同时也是日本史上唱片销量第三的女歌手，仅次于滨崎步和松任谷由实。', '0');
INSERT INTO `singer` VALUES ('56', '安室奈美恵', '0', 'Japanese', 'music/56/56.jpg', '安室奈美惠，出生于日本冲绳县那霸市，拥有四分之一意大利血统。她于14岁出道，是女子组合Super Monkey\'s的一分子。尽管该组合不太成功，但在1995年时仍凭著单曲〈Try Me ～Watashi o Shinjite～〉取得一点知名度。在推出多两首单曲后，安室奈美惠离开了该组合，成为艾回旗下的独立歌手。其超过10年的歌手生涯，使她成为其中一位日本最长寿歌手。她亦是唯一一位日本女歌手可以连续十五年有单曲打入十大。主要代表作品：《BEST FICTION》，《PLAY》《Can You Celebrate?》并曾为知名漫画《海贼王》的动画版献唱主题曲《Fight Together》。', '0');
INSERT INTO `singer` VALUES ('57', 'Crazy Frog', null, 'Others', 'music/57/57.jpg', '“疯狂的青蛙”的创始人是年轻的瑞典小伙子丹尼尔，他尝试用电子音乐模仿发动机嗡嗡作响的声音。随后，这支曲子被一个德国手机铃声网站采用，他们在里面加入了德国电子舞曲和贝斯伴奏，2004年，“疯狂青蛙”的手机铃声被放到网上流传，并在所有年轻人的手机里迅速蔓延，疯狂地流行起来。“疯狂的青蛙”也催生了周边商品和玩具，以及两个电子游戏。', '0');
INSERT INTO `singer` VALUES ('58', 'Barbie', null, 'Others', 'music/58/58.jpg', 'No', '0');

-- ----------------------------
-- Table structure for singer_album
-- ----------------------------
DROP TABLE IF EXISTS `singer_album`;
CREATE TABLE `singer_album` (
  `sid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`aid`),
  KEY `FK_Album_Singer` (`aid`),
  CONSTRAINT `FK_Album_Singer` FOREIGN KEY (`aid`) REFERENCES `album` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Singer_Album` FOREIGN KEY (`sid`) REFERENCES `singer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singer_album
-- ----------------------------
INSERT INTO `singer_album` VALUES ('23', '1');
INSERT INTO `singer_album` VALUES ('23', '2');
INSERT INTO `singer_album` VALUES ('24', '3');
INSERT INTO `singer_album` VALUES ('24', '4');
INSERT INTO `singer_album` VALUES ('25', '5');
INSERT INTO `singer_album` VALUES ('25', '6');
INSERT INTO `singer_album` VALUES ('26', '7');
INSERT INTO `singer_album` VALUES ('26', '8');
INSERT INTO `singer_album` VALUES ('27', '9');
INSERT INTO `singer_album` VALUES ('27', '10');
INSERT INTO `singer_album` VALUES ('28', '11');
INSERT INTO `singer_album` VALUES ('28', '12');
INSERT INTO `singer_album` VALUES ('29', '13');
INSERT INTO `singer_album` VALUES ('29', '14');
INSERT INTO `singer_album` VALUES ('30', '15');
INSERT INTO `singer_album` VALUES ('30', '16');
INSERT INTO `singer_album` VALUES ('31', '17');
INSERT INTO `singer_album` VALUES ('31', '18');
INSERT INTO `singer_album` VALUES ('32', '19');
INSERT INTO `singer_album` VALUES ('32', '20');
INSERT INTO `singer_album` VALUES ('33', '21');
INSERT INTO `singer_album` VALUES ('33', '22');
INSERT INTO `singer_album` VALUES ('49', '23');
INSERT INTO `singer_album` VALUES ('50', '24');
INSERT INTO `singer_album` VALUES ('50', '25');
INSERT INTO `singer_album` VALUES ('51', '26');
INSERT INTO `singer_album` VALUES ('51', '27');
INSERT INTO `singer_album` VALUES ('52', '28');
INSERT INTO `singer_album` VALUES ('52', '29');
INSERT INTO `singer_album` VALUES ('37', '30');
INSERT INTO `singer_album` VALUES ('36', '31');
INSERT INTO `singer_album` VALUES ('36', '32');
INSERT INTO `singer_album` VALUES ('35', '33');
INSERT INTO `singer_album` VALUES ('35', '34');
INSERT INTO `singer_album` VALUES ('34', '35');
INSERT INTO `singer_album` VALUES ('34', '36');
INSERT INTO `singer_album` VALUES ('53', '37');
INSERT INTO `singer_album` VALUES ('53', '38');
INSERT INTO `singer_album` VALUES ('53', '39');
INSERT INTO `singer_album` VALUES ('54', '40');
INSERT INTO `singer_album` VALUES ('54', '41');
INSERT INTO `singer_album` VALUES ('55', '42');
INSERT INTO `singer_album` VALUES ('55', '43');
INSERT INTO `singer_album` VALUES ('56', '44');
INSERT INTO `singer_album` VALUES ('56', '45');
INSERT INTO `singer_album` VALUES ('56', '46');
INSERT INTO `singer_album` VALUES ('38', '47');
INSERT INTO `singer_album` VALUES ('38', '48');
INSERT INTO `singer_album` VALUES ('38', '49');
INSERT INTO `singer_album` VALUES ('39', '50');
INSERT INTO `singer_album` VALUES ('39', '51');
INSERT INTO `singer_album` VALUES ('40', '52');
INSERT INTO `singer_album` VALUES ('41', '53');
INSERT INTO `singer_album` VALUES ('41', '54');
INSERT INTO `singer_album` VALUES ('41', '55');
INSERT INTO `singer_album` VALUES ('46', '56');
INSERT INTO `singer_album` VALUES ('46', '57');
INSERT INTO `singer_album` VALUES ('47', '58');
INSERT INTO `singer_album` VALUES ('47', '59');
INSERT INTO `singer_album` VALUES ('48', '60');
INSERT INTO `singer_album` VALUES ('48', '61');
INSERT INTO `singer_album` VALUES ('45', '62');
INSERT INTO `singer_album` VALUES ('45', '63');
INSERT INTO `singer_album` VALUES ('42', '64');
INSERT INTO `singer_album` VALUES ('42', '65');
INSERT INTO `singer_album` VALUES ('43', '66');
INSERT INTO `singer_album` VALUES ('43', '67');
INSERT INTO `singer_album` VALUES ('44', '68');
INSERT INTO `singer_album` VALUES ('44', '69');
INSERT INTO `singer_album` VALUES ('57', '70');
INSERT INTO `singer_album` VALUES ('57', '71');

-- ----------------------------
-- Table structure for singer_band
-- ----------------------------
DROP TABLE IF EXISTS `singer_band`;
CREATE TABLE `singer_band` (
  `sid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`bid`),
  KEY `FK_Band_Singer` (`bid`),
  CONSTRAINT `FK_Band_Singer` FOREIGN KEY (`bid`) REFERENCES `singer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Singer_Band` FOREIGN KEY (`sid`) REFERENCES `singer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singer_band
-- ----------------------------
INSERT INTO `singer_band` VALUES ('37', '43');

-- ----------------------------
-- Table structure for traffic
-- ----------------------------
DROP TABLE IF EXISTS `traffic`;
CREATE TABLE `traffic` (
  `id` varchar(32) NOT NULL,
  `url` varchar(255) NOT NULL,
  `seed` varchar(20) DEFAULT NULL,
  `step` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traffic
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` char(64) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `address` text,
  `qq` varchar(12) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `privilege` varchar(5) NOT NULL,
  `is_real_public` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'windawings', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', null, null, null, null, null, null, null, null, 'windawings@foxmail.com', 'images/user.png', 'admin', null);
