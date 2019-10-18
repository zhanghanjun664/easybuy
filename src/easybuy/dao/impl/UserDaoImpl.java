package easybuy.dao.impl;

import easybuy.bean.Easybuy_user;
import easybuy.dao.UserDao;
import easybuy.utils.C3p0Utils;
import easybuy.utils.MD5Util;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
    @Override
    public int register(String userName, String password, int sex, String identityCode, String email, String mobile, int type) {
        String sql = "insert into easybuy_user(userName, password, sex, identityCode, email, mobile, type, loginName) values(?, ?, ?, ?, ?, ?, ?, ?)";
        String encodePsw = MD5Util.encode(password);
        Object[] params = {userName, encodePsw, sex, identityCode, email, mobile, type, userName};
        int result = C3p0Utils.updateRecord(sql, params);
        return result;
    }

    @Override
    public Easybuy_user login(String userName, String password) {
        String sql = "select * from easybuy_user where userName=? and password=?";
        BeanHandler<Easybuy_user> beanHandler = new BeanHandler<>(Easybuy_user.class);
        String encodePsw = MD5Util.encode(password);
        Easybuy_user user = C3p0Utils.getBeanList(sql, beanHandler, userName, encodePsw);
        return user;
    }
}
