/*
 Navicat Premium Data Transfer

 Source Server         : vg
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 20/04/2022 10:23:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `credit` float NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '语文', 4);
INSERT INTO `course` VALUES (2, '数学', 4);
INSERT INTO `course` VALUES (3, '地理', 2);
INSERT INTO `course` VALUES (4, '物理', 2);
INSERT INTO `course` VALUES (5, '英语', 2);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stud_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` tinyint(255) NOT NULL,
  `grade` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张四', 0, 6);
INSERT INTO `student` VALUES (3, '张三', 0, 6);
INSERT INTO `student` VALUES (4, '张五', 0, 6);
INSERT INTO `student` VALUES (5, '小红', 1, 3);
INSERT INTO `student` VALUES (6, '小美', 1, 2);
INSERT INTO `student` VALUES (7, '李四', 0, 5);
INSERT INTO `student` VALUES (8, '成龙', 0, 1);

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES (1, 1, 1);
INSERT INTO `student_course` VALUES (2, 1, 2);
INSERT INTO `student_course` VALUES (3, 2, 2);
INSERT INTO `student_course` VALUES (4, 2, 1);
INSERT INTO `student_course` VALUES (5, 3, 5);
INSERT INTO `student_course` VALUES (6, 4, 2);
INSERT INTO `student_course` VALUES (7, 5, 3);

SET FOREIGN_KEY_CHECKS = 1;
