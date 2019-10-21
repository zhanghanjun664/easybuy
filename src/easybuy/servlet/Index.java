package easybuy.servlet;

import easybuy.dao.NewsDao;
import easybuy.dao.ProductDao;
import easybuy.dao.impl.ProductDaoImpl;
import easybuy.service.NewsService;
import easybuy.service.ProductService;
import easybuy.service.impl.NewsServiceImpl;
import easybuy.service.impl.ProductServiceImpl;
import easybuy.utils.C3p0Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/Index")
public class Index extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        获取3级分类
        List category = productService.getCategory();
        req.setAttribute("category", category);

//        获取新闻资讯
        List newsList = newsService.getNewsList(1, 5);
        req.setAttribute("newsList", newsList);

//        String sql = "select id, title from easybuy_news order by createTime desc limit 5";
//        NewsList<Map<String, Object>> beanListToMap = C3p0Utils.getMapListHandler(sql);
//        System.out.println("beanListToMap->"+beanListToMap);
//        for (Map<String, Object> stringObjectMap : beanListToMap) {
//            System.out.println("stringObjectMap:"+stringObjectMap);
//            for(Map.Entry e: stringObjectMap.entrySet()){
//                System.out.println(e.getKey()+":"+e.getValue());
//            }
//        }

        req.getRequestDispatcher("Index.jsp").forward(req, resp);
    }
}
