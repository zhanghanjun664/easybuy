package easybuy.service.impl;

import easybuy.dao.ProductDao;
import easybuy.dao.impl.ProductDaoImpl;
import easybuy.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public List getCategory() {
        return productDao.getCategory();
    }

    @Override
    public List getProductsById(int id, int pageNum, int pageSize) {
        return productDao.getProductsById(id, pageNum, pageSize);
    }

    @Override
    public <T> T getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Override
    public long getProductsCount(int id) {
        return productDao.getProductsCount(id);
    }
}
