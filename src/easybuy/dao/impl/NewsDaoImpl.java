package easybuy.dao.impl;

import easybuy.dao.NewsDao;
import easybuy.utils.C3p0Utils;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;
import java.util.Map;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List getNewsList(int pageNum, int pageSize) {
        String sql = "select * from easybuy_news order by createTime desc limit ?,?";
        int index = (pageNum-1)*pageSize;
        Object[] params = {index, pageSize};
        List<Map<String, Object>> list = C3p0Utils.getMapListHandler(sql, params);

        return list;
    }

    @Override
    public Map getNewsDetail(int id) {
        String sql = "select * from easybuy_news where id=?";
        Map item = C3p0Utils.getMapHandler(sql, id);

        return item;
    }

    @Override
    public long getNewsCount() {
        String sql = "select count(1) from easybuy_news";
        ScalarHandler scalarHandler = new ScalarHandler();
        Object count = C3p0Utils.getScalarHandler(sql, scalarHandler);
        return (long)count;
    }
}
