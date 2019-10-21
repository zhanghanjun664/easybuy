package easybuy.dao;

import java.util.List;
import java.util.Map;

public interface NewsDao {
    public List getNewsList(int pageNum, int pageSize);

    public Map getNewsDetail(int id);

    public long getNewsCount();
}
