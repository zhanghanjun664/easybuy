package easybuy.service;

import easybuy.bean.Easybuy_product;

import java.util.List;

public interface ProductService {
//    获取类目
    public List getCategory();

//    根据类目id查商品列表
    public List getProductsById(int id, int pageNum, int pageSize);

    public <T> T getProductById(String id);
//    public Easybuy_product getProductById(String id);

//    获取总数
    public long getProductsCount(int id);
}
