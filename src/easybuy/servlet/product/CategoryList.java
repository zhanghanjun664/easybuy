package easybuy.servlet.product;

import easybuy.dao.ProductDao;
import easybuy.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryList")
public class CategoryList extends HttpServlet {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String pid = req.getParameter("pid");
        int cid = 0;
        int pageNum = 1;
        int pageSize = 5;
        if(req.getParameter("cid") != null){
            cid = Integer.parseInt(req.getParameter("cid"));
        }
        if(req.getParameter("pageNum") != null){
            pageNum = Integer.parseInt(req.getParameter("pageNum"));
        }
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }

        long count = productDao.getProductsCount(cid);
        long pages = getPages(pageSize, count);
        List products = productDao.getProductsById(cid, pageNum, pageSize);
        int[] emptyTmp = new int[(int)pages];

        System.out.println("products==>"+pages+","+products);

        req.setAttribute("pageNum", pageNum);
        req.setAttribute("pages", pages);
        req.setAttribute("products", products);
        req.setAttribute("emptyTmp", emptyTmp);
        req.setAttribute("cid", cid);
        req.setAttribute("count", count);

        req.getRequestDispatcher("CategoryList.jsp").forward(req, resp);

    }

    private long getPages(int pageSize, long count){
        long pages = (count/pageSize)+1;
        if(count%pageSize == 0) pages--;

        return pages;
    }

}
