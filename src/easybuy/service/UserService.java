package easybuy.service;

import easybuy.bean.Easybuy_user;

public interface UserService {
//    注册
    public int register(String userName, String password, int sex, String identityCode, String email, String mobile, int type);

//    登录
    public Easybuy_user login(String userName, String password);
}
