package lol.servlet;

import lol.bean.Legends;
import lol.service.LegendsService;
import lol.service.impl.LegendsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class LegendsServlet extends HttpServlet {
    LegendsService legendsService = new LegendsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<Legends> legends = legendsService.getLegends();
//        req.setAttribute("legends", legends);

//        String pageNo = req.getParameter("pageNo");
//        if(pageNo == null) pageNo = "1";
        int pageNo = 1;
        if(req.getParameter("pageNo") != null){
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }


        int pageSize = 5;
//        if(req.getParameter("pageSize") != null){
//            pageSize = Integer.parseInt(req.getParameter("pageSize"));
//        }

//        查询英雄列表
        List<Legends> legends = legendsService.getLegends(pageNo, pageSize);
//        查询英雄总数
        long legendsCount = legendsService.getLegendsCount();
        long totalPageCount = getTotalPageCount(legendsCount, pageSize);

        req.setAttribute("pageNo", pageNo);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("legends", legends);
        req.setAttribute("legendsCount", legendsCount);
        req.setAttribute("totalPageCount", totalPageCount);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    private long getTotalPageCount(long pages, int pageSize){
        long count = pages/pageSize + 1;
        if(pages % pageSize == 0){
            count--;
        }

        return count;
    }


}
