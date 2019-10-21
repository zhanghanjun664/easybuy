package easybuy.servlet.news;

import easybuy.dao.NewsDao;
import easybuy.dao.impl.NewsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newsList")
public class NewsList extends HttpServlet {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNum = 1;
        int pageSize = 10;
        if(req.getParameter("pageNum") != null){
            pageNum = Integer.parseInt(req.getParameter("pageNum"));
        }
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }

        java.util.List newsList = newsDao.getNewsList(pageNum, pageSize);
        req.setAttribute("newsList", newsList);

        long count = newsDao.getNewsCount();
        long pages = getPages(count, pageSize);
        int[] emptyTmp = new int[(int)pages];
        System.out.println("pages->"+pages);
        req.setAttribute("pages", pages);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("emptyTmp", emptyTmp);

//        String target = req.getContextPath() + "/News.jsp";
//        System.out.println("req.getContextPath()==>"+req.getContextPath()+","+target);
        req.getRequestDispatcher("News.jsp").forward(req, resp);


    }

    private long getPages(long count, int pageSize){
        long pages = (count / pageSize) + 1;
        if(count < pageSize) pages = 1;

        return pages;
    }

}
