package lol.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.SQLException;
import java.util.List;

public class C3p0Utils {

    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    private static QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);

    public static ComboPooledDataSource getComboPooledDataSource() {
        return comboPooledDataSource;
    }

//    查询list
    public static <T> T getBeanList(String sql, ResultSetHandler<T> rsh, Object[] params){
        Object result = null;
        try {
            result = queryRunner.query(sql, rsh, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T)result;

    }

//    查询单值
    public static Object getScalarHandler(String sql, ResultSetHandler rsh){
        Object result = null;
        try {
            result = queryRunner.query(sql, rsh);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

//    增，删，改
    public static int updateLegend(String sql, Object ...params){
        int result = 0;
        try {
            result = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



}
