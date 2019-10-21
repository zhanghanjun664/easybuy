package easybuy.dao.impl;

import easybuy.dao.ProductDao;
import easybuy.utils.C3p0Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List getCategory() {
//        String sql = "SELECT cat.`name`, pro.categoryLevel1Id id FROM easybuy_product pro, easybuy_product_category cat \n" +
//                "WHERE pro.categoryLevel1Id = cat.id\n" +
//                "GROUP BY categoryLevel1Id";
        String sql = "select id, name from easybuy_product_category where type = 1";

        List<Map<String, Object>> categoryList = C3p0Utils.getMapListHandler(sql);
//        [
//          {id: xxx, name: xxx, children: []}
//        ]

        for (Map<String, Object> item : categoryList) {
            List children = getChildrenByParentId(item.get("id"));
            item.put("children", children);
        }

        return categoryList;
    }

    private List getChildrenByParentId(Object id){
        String sql = "SELECT `name`, id FROM easybuy_product_category WHERE parentId = ?";
        List<Map<String, Object>> list = C3p0Utils.getMapListHandler(sql, id);
        if(list.size() == 0){
            return list;
        }
        for (Map item : list) {
            List children = getChildrenByParentId(item.get("id"));
            item.put("children", children);

        }

        return list;
    }

}
