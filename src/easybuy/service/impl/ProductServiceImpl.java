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
}
