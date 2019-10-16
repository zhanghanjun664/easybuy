package lol.dao.impl;

import lol.bean.Legends;
import lol.dao.LegendsDao;
import lol.utils.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class LegendsDaoImpl implements LegendsDao {
    @Override
    public List<Legends> getLegends() {
        String sql = "select * from lol";
        BeanListHandler<Legends> beanListHandler = new BeanListHandler<Legends>(Legends.class);
        List<Legends> beanList = C3p0Utils.getBeanList(sql, beanListHandler, null);
        return beanList;
    }

    @Override
    public List<Legends> getLegends(int pageNo, int pageSize) {
        String sql = "select * from lol limit ?,?";
        BeanListHandler<Legends> beanListHandler = new BeanListHandler<>(Legends.class);
        int startIndex = (pageNo-1)*pageSize;
        Object[] params = {startIndex, pageSize};
        List<Legends> legends = C3p0Utils.getBeanList(sql, beanListHandler, params);
        return legends;
    }

    @Override
    public long getLegendsCount() {
        String sql = "select count(1) from lol";
        ScalarHandler scalarHandler = new ScalarHandler();
        Object result = C3p0Utils.getScalarHandler(sql, scalarHandler);
        return (long)result;
    }


    @Override
    public int deleteLegendById(String id) {
        String sql = "delete from lol where id=?";
        Object[] params = {id};
        int result = C3p0Utils.updateLegend(sql, params);
        return result;
    }

    @Override
    public int addLegends(String name, String ages, String catalog_id, String sex) {
        String sql = "insert into lol values(null, ?,?,?,?)";
        Object[] params = {name, ages, catalog_id, sex};
        int result = C3p0Utils.updateLegend(sql, params);
        return result;
    }

    @Override
    public int updateLegendsById(String id, String name, String ages, String catalog_id, String sex) {
        String sql = "update lol set name=?, ages=?, catalog_id=?, sex=? where id=?";
        Object[] params = {id, name, ages, catalog_id, sex};
        int result = C3p0Utils.updateLegend(sql, params);
        return result;
    }

    @Override
    public <T> T getLegends(String id) {
        String sql = "select * from lol where id=?";
        Object[] params = {id};
        BeanHandler<Legends> beanHandler = new BeanHandler<Legends>(Legends.class);
        Legends legends = C3p0Utils.getBeanList(sql, beanHandler, params);
        System.out.println("sql==>"+sql);
        System.out.println("legends==>"+legends);

        return (T)legends;
    }


}
