package easybuy.servlet;

import easybuy.service.LegendsService;
import easybuy.service.impl.LegendsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/afterModify")
public class TransferServlet extends HttpServlet {
    LegendsService legendsService = new LegendsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println("id==>"+id);
//        查询英雄信息
        Object legend = legendsService.getLegends(id);
        if(legend != null){
            req.setAttribute("legend", legend);
            System.out.println("查询成功");

        }else{
            System.out.println("查询失败");
        }
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}
