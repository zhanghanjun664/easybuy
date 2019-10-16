package easybuy.servlet;

import easybuy.service.LegendsService;
import easybuy.service.impl.LegendsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modify")
public class ModifyLegends extends HttpServlet {
    LegendsService legendsService = new LegendsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String ages = req.getParameter("ages");
        String catalog_id = req.getParameter("catalog_id");
        String sex = req.getParameter("sex");

        int result = legendsService.updateLegendsById(name, ages, catalog_id, sex, id);
        if(result>0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }

        String pojectName = req.getContextPath();
        resp.sendRedirect(pojectName + "/index");

    }
}
