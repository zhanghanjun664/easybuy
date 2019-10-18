package easybuy.dao;

import easybuy.bean.Easybuy_user;

public interface UserDao {
    public int register(String userName, String password, int sex, String identityCode, String email, String mobile, int type);
    public Easybuy_user login(String userName, String password);
}
