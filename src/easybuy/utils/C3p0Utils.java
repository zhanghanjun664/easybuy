package easybuy.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class C3p0Utils {

    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    private static QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);

    public static ComboPooledDataSource getComboPooledDataSource() {
        return comboPooledDataSource;
    }

//    查询list
    public static <T> T getBeanList(String sql, ResultSetHandler<T> rsh, Object ...params){
        Object result = null;
        try {
            result = queryRunner.query(sql, rsh, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T)result;

    }

//    查询list --> ArrayHandler
    public static List<Object[]> getArrayHandler(String sql, Object ...params){
        List<Object[]> result = null;
        try {
            result = queryRunner.query(sql, new ArrayListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

//    查询list --> MapListHandler
    public static List<Map<String, Object>> getMapListHandler(String sql, Object ...params){
        List<Map<String, Object>> result = null;
        try {
             result = queryRunner.query(sql, new MapListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

//    查询一项 --> MapHandler
    public static Map getMapHandler(String sql, Object ...params){
        Map<String, Object> result = null;
        try {
            result = queryRunner.query(sql, new MapHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

//    查询单值
    public static Object getScalarHandler(String sql, ResultSetHandler rsh, Object ...params){
        Object result = null;
        try {
            result = queryRunner.query(sql, rsh, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

//    增，删，改
    public static int updateRecord(String sql, Object ...params){
        int result = 0;
        try {
            result = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



}
