package easybuy.bean;

public class Easybuy_user {
//      `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
//            `loginName` varchar(255) NOT NULL COMMENT '登录名',
//            `userName` varchar(255) NOT NULL COMMENT '用户名',
//            `password` varchar(255) NOT NULL COMMENT '密码',
//            `sex` int(2) NOT NULL DEFAULT '1' COMMENT '性别(1:男 0：女)',
//            `identityCode` varchar(60) DEFAULT NULL COMMENT '身份证号',
//            `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
//            `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
//            `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
    private int id;
    private String loginName;
    private String userName;
    private String password;
    private int sex;
    private String identityCode;
    private String email;
    private String mobile;
    private int type;



}
