package easybuy.servlet.product;

import easybuy.dao.ProductDao;
import easybuy.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productDetail")
public class Detail extends HttpServlet {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("pid");
        Object product = productDao.getProductById(pid);

        req.setAttribute("product", product);

        req.getRequestDispatcher("Product.jsp").forward(req, resp);

    }
}
