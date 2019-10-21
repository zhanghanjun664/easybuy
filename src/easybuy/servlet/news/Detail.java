package easybuy.servlet.news;

import easybuy.dao.NewsDao;
import easybuy.dao.impl.NewsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/newsDetail")
public class Detail extends HttpServlet {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;
        if(req.getParameter("id") != null){
            id = Integer.parseInt(req.getParameter("id"));

        }
//        int[] ints = new int[4];

        Map newsDetail = newsDao.getNewsDetail(id);
        req.setAttribute("newsDetail", newsDetail);

//        String target = req.getContextPath() + "/News_detail.jsp";
        req.getRequestDispatcher("News_detail.jsp").forward(req, resp);

    }
}
