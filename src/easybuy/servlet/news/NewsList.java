package easybuy.servlet.news;

import easybuy.dao.NewsDao;
import easybuy.dao.impl.NewsDaoImpl;
import easybuy.utils.PageUtil;

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
    PageUtil pageUtil = new PageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int pageNum = 0;
//        int pageSize = 0;
//        if(req.getParameter("pageNum") != null){
//            pageNum = Integer.parseInt(req.getParameter("pageNum"));
//        }
//        if(req.getParameter("pageSize") != null){
//            pageSize = Integer.parseInt(req.getParameter("pageSize"));
//        }


        pageUtil.setPageNumAndPageSize(req);
        int pageNum = pageUtil.getPageNum();
        int pageSize = pageUtil.getPageSize();

        long total = newsDao.getNewsCount();

        pageUtil.setPageNum(pageNum);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotal((int)total);
        pageUtil.setPages((int)total, pageSize);


        List newsList = newsDao.getNewsList(pageNum, pageSize);
        req.setAttribute("newsList", newsList);

        int pages = pageUtil.getPages();

        int[] emptyTmp = new int[pages];


        req.setAttribute("pages", pages);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("emptyTmp", emptyTmp);

//        String target = req.getContextPath() + "/News.jsp";
//        System.out.println("req.getContextPath()==>"+req.getContextPath()+","+target);
        req.getRequestDispatcher("News.jsp").forward(req, resp);


    }


}
