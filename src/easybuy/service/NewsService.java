package easybuy.service;

import java.util.List;
import java.util.Map;

public interface NewsService {
    public List getNewsList(int pageNum, int pageSize);

    public Map getNewsDetail(int id);

    public long getNewsCount();
}
