/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 23/02/2019 20:32:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `article_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户名ID',
  `article_type` int(10) NULL DEFAULT NULL COMMENT '类型',
  `article_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `article_content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `article_sendTime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间',
  `article_create` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '来源',
  `article_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `article2user`(`user_id`) USING BTREE,
  INDEX `article2type`(`article_type`) USING BTREE,
  CONSTRAINT `article2type` FOREIGN KEY (`article_type`) REFERENCES `tb_article_type` (`type_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `article2user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (1, 1, 2, '测试内容', 'qesafdsffffffffffffffffffffff', 'sfdf', '个人日记', '个人日记asd');
INSERT INTO `tb_article` VALUES (4, 10, 8, '测试内容', '水电费水电费第三方士大夫水电费水电费啥的说的都是范德萨 水电费水电费水电费水电费水电费水电费是的 水电费啥的水电费 水电费第三方水电费啥的', 'sfdf', '个人日记', '个人日记asd');
INSERT INTO `tb_article` VALUES (5, 10, 8, '测试内容', '水电费水电费第三方士大夫水电费水电费啥的说的都是范德萨 水电费水电费水电费水电费水电费水电费是的 水电费啥的水电费 水电费第三方水电费啥的', 'sfdf', '个人日记', '个人日记asd');
INSERT INTO `tb_article` VALUES (6, 10, 8, '测试内容', '水电费水电费第三方士大夫水电费水电费啥的说的都是范德萨 水电费水电费水电费水电费水电费水电费是的 水电费啥的水电费 水电费第三方水电费啥的', 'sfdf', '个人日记', '个人日记asd');
INSERT INTO `tb_article` VALUES (7, 10, 4, 'JAVA中获取当前系统时间', 'JAVA中获取当前系统时间\r\n一. 获取当前系统时间和日期并格式化输出:\r\n\r\nimport java.util.Date;\r\nimport java.text.SimpleDateFormat;\r\n\r\npublic class NowString {\r\npublic static void main(String[] args) { \r\nSimpleDateFormat df = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");//设置日期格式\r\nSystem.out.println(df.format(new Date()));// new Date()为获取当前系统时间\r\n}\r\n}\r\n\r\n二. 在数据库里的日期只以年-月-日的方式输出，可以用下面两种方法：\r\n\r\n1、用convert()转化函数：\r\n\r\nString sqlst = \"select convert(varchar(10),bookDate,126) as convertBookDate from roomBook where bookDate between \'2007-4-10\' and \'2007-4-25\'\";\r\n\r\nSystem.out.println(rs.getString(\"convertBookDate\"));\r\n\r\n2、利用SimpleDateFormat类：\r\n\r\n先要输入两个java包：\r\n\r\nimport java.util.Date;\r\nimport java.text.SimpleDateFormat;\r\n\r\n然后：\r\n\r\n定义日期格式：SimpleDateFormat sdf = new SimpleDateFormat(yy-MM-dd);\r\n\r\nsql语句为：String sqlStr = \"select bookDate from roomBook where bookDate between \'2007-4-10\' and \'2007-4-25\'\";\r\n\r\n输出：\r\n\r\nSystem.out.println(df.format(rs.getDate(\"bookDate\")));\r\n\r\n \r\n\r\n************************************************************\r\n\r\njava中获取当前日期和时间的方法\r\n \r\nimport java.util.Date; \r\nimport java.util.Calendar; \r\n\r\nimport java.text.SimpleDateFormat; \r\n\r\npublic class TestDate{ \r\npublic static void main(String[] args){ \r\nDate now = new Date(); \r\nSimpleDateFormat dateFormat = new SimpleDateFormat(\"yyyy/MM/dd HH:mm:ss\");//可以方便地修改日期格式\r\n\r\n\r\nString hehe = dateFormat.format( now ); \r\nSystem.out.println(hehe); \r\n\r\nCalendar c = Calendar.getInstance();//可以对每个时间域单独修改\r\n\r\n \r\n\r\n\r\nint year = c.get(Calendar.YEAR); \r\nint month = c.get(Calendar.MONTH); \r\nint date = c.get(Calendar.DATE); \r\nint hour = c.get(Calendar.HOUR_OF_DAY); \r\nint minute = c.get(Calendar.MINUTE); \r\nint second = c.get(Calendar.SECOND); \r\nSystem.out.println(year + \"/\" + month + \"/\" + date + \" \" +hour + \":\" +minute + \":\" + second); \r\n} \r\n}\r\n\r\n 有时候要把String类型的时间转换为Date类型，通过以下的方式，就可以将你刚得到的时间字符串转换为Date类型了。\r\n\r\nSimpleDateFormat sdf=new SimpleDateFormat(\"yyyy-MM-dd\");\r\n\r\njava.util.Date time=null;\r\ntry {\r\n   time= sdf.parse(sdf.format(new Date()));\r\n\r\n} catch (ParseException e) {\r\n\r\n   e.printStackTrace();\r\n}', 'sfdf', '转载', '技术博客');

-- ----------------------------
-- Table structure for tb_article_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_type`;
CREATE TABLE `tb_article_type`  (
  `type_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名',
  `type_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型说明',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article_type
-- ----------------------------
INSERT INTO `tb_article_type` VALUES (2, '个人日志', '记录个人信息的一个博客分类');
INSERT INTO `tb_article_type` VALUES (3, '个人日志', '记录个人信息的一个博客分类');
INSERT INTO `tb_article_type` VALUES (4, '心情', '哇哦大红活动啊顺丰发asxvddsad aasdasd');
INSERT INTO `tb_article_type` VALUES (5, '心情类型', '哇哦大红活动啊顺丰发asxvddsad aasdasd');
INSERT INTO `tb_article_type` VALUES (6, '心情类型', '哇哦大红活动啊顺丰发asxvddsad aasdasd');
INSERT INTO `tb_article_type` VALUES (7, '心情类型', 'asdasasaaaaaaaaaaaaaaaaaaaa限制性政策出租车');
INSERT INTO `tb_article_type` VALUES (8, '啊啊啊啊啊啊啊啊啊啊', '爱的是的是的是的是的是的实打实的事项做出 阿打算的祖先');
INSERT INTO `tb_article_type` VALUES (9, '旅游记录', '记录旅游图中的信息');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `commentArticle_id` int(10) NULL DEFAULT NULL COMMENT '文章ID',
  `review_author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复者',
  `review_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复内容',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `commentArticle_id`(`commentArticle_id`) USING BTREE,
  CONSTRAINT `tb_comment_ibfk_1` FOREIGN KEY (`commentArticle_id`) REFERENCES `tb_article` (`article_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_friend
-- ----------------------------
DROP TABLE IF EXISTS `tb_friend`;
CREATE TABLE `tb_friend`  (
  `friend_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '好友ID',
  `user_id` int(10) NULL DEFAULT NULL COMMENT ' 用户ID',
  `friend_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '好友名',
  `friend_sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `friend_qq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' QQ号',
  `friend_blog` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '好友博客',
  PRIMARY KEY (`friend_id`) USING BTREE,
  INDEX `friend2user`(`user_id`) USING BTREE,
  CONSTRAINT `friend2user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `message_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '留言ID',
  `user_id` int(10) NULL DEFAULT NULL COMMENT ' 用户',
  `message_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `message_author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言者',
  `message_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言内容',
  `message_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言时间',
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `message2user`(`user_id`) USING BTREE,
  CONSTRAINT `message2user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_photo
-- ----------------------------
DROP TABLE IF EXISTS `tb_photo`;
CREATE TABLE `tb_photo`  (
  `photo_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '相册',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `photo_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相册名',
  `photo_addr` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相册地址',
  `photo_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `photo_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间',
  PRIMARY KEY (`photo_id`) USING BTREE,
  INDEX `photo2user`(`user_id`) USING BTREE,
  CONSTRAINT `photo2user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `user_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `user_qq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qq',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'RJsetter', '123456', '?', '1039339929@qq.com', '1039339929');
INSERT INTO `tb_user` VALUES (8, 'RJsette', '123456', 'M', '1039339929@qq.com', '1039339929');
INSERT INTO `tb_user` VALUES (9, 'qwe', '123456', 'F', '1039339929@qq.com', '103933929');
INSERT INTO `tb_user` VALUES (10, 'yeqiang', '123456', 'M', '1039339926@qq.co', '1039339926');
INSERT INTO `tb_user` VALUES (11, 'mysql', '123456', '?', '1039339929@qq.com', '1039339929');

SET FOREIGN_KEY_CHECKS = 1;
