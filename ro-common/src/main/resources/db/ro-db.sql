/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : ro-db

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 04/09/2019 17:16:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginaccount` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当前操作人',
  `loginip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当前操作人ip',
  `actionurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作请求的链接',
  `module` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '执行的模块',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '执行的方法',
  `actiontime` bigint(11) NULL DEFAULT 0 COMMENT '执行操作时长',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `gmtcreate` datetime NULL DEFAULT NULL COMMENT '执行开始时间',
  `state` int(2) NULL DEFAULT NULL COMMENT '该操作状态，1表示成功，-1表示失败！',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, '—— ——', '0:0:0:0:0:0:0:1', '/login', '登录模块', '登录', 866, '执行成功', '2019-08-20 18:24:13', 1);
INSERT INTO `log` VALUES (2, '—— ——', '0:0:0:0:0:0:0:1', '/login', '登录模块', '登录', 820, '执行成功', '2019-08-20 18:25:50', 1);
INSERT INTO `log` VALUES (3, '—— ——', '0:0:0:0:0:0:0:1', '//api/test5', '登录模块', '登录', 409, '执行成功', '2019-08-20 18:30:11', 1);
INSERT INTO `log` VALUES (4, '—— ——', '0:0:0:0:0:0:0:1', '/test5', '登录模块', '登录', 26, '执行成功', '2019-08-20 18:32:03', 1);
INSERT INTO `log` VALUES (5, '—— ——', '0:0:0:0:0:0:0:1', '//api/test5', '登录模块', '登录', 187, '执行成功', '2019-08-20 18:32:24', 1);
INSERT INTO `log` VALUES (6, '—— ——', '0:0:0:0:0:0:0:1', '//api/test5', '登录模块', '登录', 173, '执行成功', '2019-08-20 18:35:50', 1);
INSERT INTO `log` VALUES (7, '—— ——', '0:0:0:0:0:0:0:1', '/test5', '登录模块', '登录', 26, '执行成功', '2019-08-20 18:35:57', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NULL DEFAULT NULL COMMENT '父级菜单id',
  `menuname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问地址',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单样式标识',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '0启用 -1禁用',
  `type` int(2) NULL DEFAULT NULL COMMENT '1主页面 2功能 3子页面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20205 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '系统管理', 'javaScript:;', 'layui-icon-set', 0, 0, 0);
INSERT INTO `menu` VALUES (2, 0, '权限管理', 'javaScript:;', 'layui-icon-set', 0, 0, 0);
INSERT INTO `menu` VALUES (3, 0, '用户管理', 'javaScript:;', 'layui-icon-set', 0, 0, 0);
INSERT INTO `menu` VALUES (201, 2, '角色列表', '/role/showRoleList', NULL, 0, 0, 1);
INSERT INTO `menu` VALUES (202, 2, '管理员列表', '/user/showUserList', '', 0, 0, 1);
INSERT INTO `menu` VALUES (20101, 201, '新增/编辑角色页面', '/role/showRoleEdit', NULL, 0, 0, 3);
INSERT INTO `menu` VALUES (20102, 201, '启用/禁用角色', '/role/updateRoleStatus', NULL, 0, 0, 2);
INSERT INTO `menu` VALUES (20103, 201, '删除角色', '/role/deleteRole', NULL, 0, 0, 2);
INSERT INTO `menu` VALUES (20201, 202, '新增/编辑管理员页面', '/user/showUserEdit', NULL, 0, 0, 3);
INSERT INTO `menu` VALUES (20202, 202, '新增/编辑管理员', '/user/editUser', NULL, 0, 0, 2);
INSERT INTO `menu` VALUES (20203, 202, '删除管理员', '/user/deleteUser', NULL, 0, 0, 2);
INSERT INTO `menu` VALUES (20204, 202, '开启/禁用管理员', '/user/updateUserStatus', NULL, 0, 0, 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `menuids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '角色菜单权限组，逗号分隔',
  `status` int(1) NULL DEFAULT 0 COMMENT '0有效 -1无效',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '20203,20103,20202,20102,20201,20101,20204,2,201,202', 0, '2019-08-20 14:39:23');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `headurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `roleid` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `status` int(2) NULL DEFAULT 0 COMMENT '0有效 -1无效',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员账号表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '21218cca77804d2ba1922c33e0151105', 'aaaaa', NULL, 1, 0, '2019-08-20 14:39:04');

SET FOREIGN_KEY_CHECKS = 1;
