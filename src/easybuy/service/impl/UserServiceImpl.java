package easybuy.service.impl;

import easybuy.bean.Easybuy_user;
import easybuy.dao.impl.UserDaoImpl;
import easybuy.service.UserService;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public int register(String userName, String password, int sex, String identityCode, String email, String mobile, int type) {

        return userDao.register(userName, password, sex, identityCode, email, mobile, type);
    }

    @Override
    public Easybuy_user login(String userName, String password) {
        return userDao.login(userName, password);
    }
}
