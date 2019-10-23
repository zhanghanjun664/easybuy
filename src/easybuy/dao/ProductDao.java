package easybuy.dao;

import java.util.List;

public interface ProductDao {
//    获取类目
    public List getCategory();

    public List getProductsById(int id, int pageNum, int pageSize);

    public <T> T getProductById(String id);

    public long getProductsCount(int id);
}
