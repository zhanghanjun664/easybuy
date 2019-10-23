package easybuy.service;

import easybuy.bean.Easybuy_user;

import java.util.List;

public interface UserService {
//    注册
    public int register(String userName, String password, int sex, String identityCode, String email, String mobile, int type);

//    登录
    public Easybuy_user login(String userName, String password);

//    获取用户分类信息
    public List getMemberCategory();

//    根据level获取用户列表
    public List getMemberByLevel(String level, int pageNum, int pageSize);
//    根据level获取用户数量
    public long getMemberCountByLevel(String level);

//    更新用户信息
    public int updateMemberInfo(int id, String userName, String mobile, String email, int sex);
}
