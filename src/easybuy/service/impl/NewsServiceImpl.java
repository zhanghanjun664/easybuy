package easybuy.service.impl;

import easybuy.dao.NewsDao;
import easybuy.dao.impl.NewsDaoImpl;
import easybuy.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    public List getNewsList() {
        return newsDao.getNewsList();
    }
}
