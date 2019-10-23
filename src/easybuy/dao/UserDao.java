package easybuy.dao;

import easybuy.bean.Easybuy_user;

import java.util.List;

public interface UserDao {
    public int register(String userName, String password, int sex, String identityCode, String email, String mobile, int type);
    public Easybuy_user login(String userName, String password);

    public List getMemberCategory();
    public List getMemberByLevel(String level, int pageNum, int pageSize);
    public long getMemberCountByLevel(String level);
    public int updateMemberInfo(int id, String userName, String mobile, String email, int sex);
}
