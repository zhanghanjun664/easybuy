package easybuy.servlet;

import easybuy.service.LegendsService;
import easybuy.service.impl.LegendsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddLegends extends HttpServlet {
    LegendsService legendsService = new LegendsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String ages = req.getParameter("ages");
        String catalog_id = req.getParameter("catalog_id");
        String sex = req.getParameter("sex");
        System.out.println(name+ages+catalog_id +sex);

        int result = legendsService.addLegends(name, ages, catalog_id, sex);
        if(result>0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }

        String pojectName = req.getContextPath();
        resp.sendRedirect(pojectName + "/index");


    }
}
