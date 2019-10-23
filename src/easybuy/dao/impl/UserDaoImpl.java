package easybuy.dao.impl;

import easybuy.bean.Easybuy_user;
import easybuy.dao.UserDao;
import easybuy.utils.C3p0Utils;
import easybuy.utils.MD5Util;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;
import java.util.Map;

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

    @Override
    public List getMemberCategory() {
        String sql = "select level, count(1) count from easybuy_user where type=0 group by level";
        List<Map<String, Object>> mapListHandler = C3p0Utils.getMapListHandler(sql);
        return mapListHandler;
    }

    @Override
    public List getMemberByLevel(String level, int pageNum, int pageSize) {
        String sql = "select * from easybuy_user where type=0 and level=? limit ?,?";
        BeanListHandler<Easybuy_user> beanListHandler = new BeanListHandler<>(Easybuy_user.class);
//        System.out.println("sql==>"+pageNum+","+pageSize+","+sql);
        int index = (pageNum - 1) * pageSize;
        List<Easybuy_user> users = C3p0Utils.getBeanList(sql, beanListHandler, level, index, pageSize);
        return users;
    }

    @Override
    public long getMemberCountByLevel(String level) {
        String sql = "select count(1) from easybuy_user where type=0 and level=?";
        ScalarHandler scalarHandler = new ScalarHandler();
        Object result = C3p0Utils.getScalarHandler(sql, scalarHandler, level);
        return (long) result;
    }

    @Override
    public int updateMemberInfo(int id, String userName, String mobile, String email, int sex) {
        String sql = "update easybuy_user set userName=?, mobile=?, email=?, sex=? where id=?";
        Object[] params = {userName, mobile, email, sex, id};
        System.out.println(userName + ","+ mobile + ","+ email + ","+sex + ","+id);
        int result = C3p0Utils.updateRecord(sql, params);
        System.out.println(result+","+sql);
        return result;
    }
}
