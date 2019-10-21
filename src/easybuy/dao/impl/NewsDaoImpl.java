package easybuy.dao.impl;

import easybuy.dao.NewsDao;
import easybuy.utils.C3p0Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List getNewsList() {
        String sql = "select id, title from easybuy_news order by createTime desc limit 5";
//        List<Object[]> result = C3p0Utils.getArrayHandler(sql);
//        ArrayList list = new ArrayList();
//        for (Object[] objects : result) {
//            HashMap map = new HashMap();
//            map.put("id", objects[0]);
//            map.put("title", objects[1]);
//            list.add(map);
//        }
        List<Map<String, Object>> list = C3p0Utils.getMapListHandler(sql);

        return list;
    }
}
