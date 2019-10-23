package easybuy.servlet.user;

import com.alibaba.fastjson.JSON;
import easybuy.dao.UserDao;
import easybuy.dao.impl.UserDaoImpl;
import easybuy.service.UserService;
import easybuy.service.impl.UserServiceImpl;
import easybuy.utils.PageUtil;
import easybuy.utils.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/memberList")
public class MemberList extends HttpServlet {
    UserService userService = new UserServiceImpl();
    PageUtil pageUtil = new PageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");

        String level = req.getParameter("level");

        long total = userService.getMemberCountByLevel(level);

        pageUtil.setPageNumAndPageSize(req);
        pageUtil.setPageSize(3);
        int pageNum = pageUtil.getPageNum();
        int pageSize = pageUtil.getPageSize();

//        获取数据
        List userList = userService.getMemberByLevel(level, pageNum, pageSize);

        pageUtil.setTotal((int)total);
        pageUtil.setPages((int)total, pageSize);
        int pages = pageUtil.getPages();

        HashMap<String , Object> map = new HashMap<>();
        map.put("list", userList);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("pages", pages);
        map.put("total", total);

        Response response = new Response(map, "success", 0);
        String jsonString = response.getJsonString();

        PrintWriter writer = resp.getWriter();
        writer.print(jsonString);

        writer.close();




    }
}
