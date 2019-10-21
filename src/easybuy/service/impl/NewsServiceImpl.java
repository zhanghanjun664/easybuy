package easybuy.service.impl;

import easybuy.dao.NewsDao;
import easybuy.dao.impl.NewsDaoImpl;
import easybuy.service.NewsService;

import java.util.List;
import java.util.Map;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    public List getNewsList(int pageNum, int pageSize) {
        return newsDao.getNewsList(pageNum, pageSize);
    }

    @Override
    public Map getNewsDetail(int id) {
        return newsDao.getNewsDetail(id);
    }

    @Override
    public long getNewsCount() {
        return newsDao.getNewsCount();
    }
}
