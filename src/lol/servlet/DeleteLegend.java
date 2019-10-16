package lol.servlet;

import lol.service.LegendsService;
import lol.service.impl.LegendsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteLegend extends HttpServlet {
    LegendsService legendsService = new LegendsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int result = legendsService.deleteLegendById(id);
        if(result > 0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

//        req.getRequestDispatcher("/index").forward(req, resp);
        String projectName = req.getContextPath();
        resp.sendRedirect(projectName+"/index");

    }
}
