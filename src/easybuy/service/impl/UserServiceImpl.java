package easybuy.service.impl;

import easybuy.bean.Easybuy_user;
import easybuy.dao.impl.UserDaoImpl;
import easybuy.service.UserService;

import java.util.List;

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

    @Override
    public List getMemberCategory() {
        return userDao.getMemberCategory();
    }

    @Override
    public List getMemberByLevel(String level, int pageNum, int pageSize) {
        return userDao.getMemberByLevel(level, pageNum, pageSize);
    }

    @Override
    public long getMemberCountByLevel(String level) {
        return userDao.getMemberCountByLevel(level);
    }

    @Override
    public int updateMemberInfo(int id, String userName, String mobile, String email, int sex) {
        return userDao.updateMemberInfo(id, userName, mobile, email, sex);
    }

    @Override
    public int deleteMember(int id) {
        return userDao.deleteMember(id);
    }

    @Override
    public Boolean checkUsername(String name) {
        return userDao.checkUsername(name);
    }
}
