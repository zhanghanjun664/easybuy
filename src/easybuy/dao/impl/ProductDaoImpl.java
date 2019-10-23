package easybuy.dao.impl;

import easybuy.bean.Easybuy_product;
import easybuy.dao.ProductDao;
import easybuy.utils.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

    @Override
    public List getProductsById(int id, int pageNum, int pageSize) {
        String sql = "select * from easybuy_product where categoryLevel3Id=? limit ?,?";
        BeanListHandler<Easybuy_product> beanListHandler = new BeanListHandler<>(Easybuy_product.class);
        int index = (pageNum - 1)*pageSize;
        Object[] params = {id, index, pageSize};
        List<Easybuy_product> beanList = C3p0Utils.getBeanList(sql, beanListHandler, params);

        return beanList;
    }

    @Override
    public <T> T getProductById(String id) {
        String sql = "select * from easybuy_product where id=?";
        BeanHandler<Easybuy_product> beanHandler = new BeanHandler<>(Easybuy_product.class);
        Easybuy_product beanList = C3p0Utils.getBeanList(sql, beanHandler, id);

        return (T)beanList;
    }

    @Override
    public long getProductsCount(int id) {
        String sql = "select count(1) from easybuy_product where categoryLevel3Id=?";
        ScalarHandler scalarHandler = new ScalarHandler();
        Object count = C3p0Utils.getScalarHandler(sql, scalarHandler, id);
        return (long)count;
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
