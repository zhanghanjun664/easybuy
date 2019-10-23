package easybuy.servlet.user;

import easybuy.dao.UserDao;
import easybuy.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/memberCategory")
public class Category extends HttpServlet {
    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1:大众会员，2：高级会员，3：镇店之宝
        HashMap categoryMapped = new HashMap();
        categoryMapped.put(1, "大众会员");
        categoryMapped.put(2, "高级会员");
        categoryMapped.put(3, "镇店之宝");

//        查询会员分类信息
        List<Map<String, Object>> category = userDao.getMemberCategory();

        int total = getMemberCount(category);

        req.setAttribute("categoryMapped", categoryMapped);
        req.setAttribute("category", category);
        req.setAttribute("total", total);

        req.getRequestDispatcher("Member_Member.jsp").forward(req, resp);

    }

//    获取总会员数
    private int getMemberCount(List<Map<String, Object>> list){
        int count = 0;
        for (Map<String, Object> item : list) {
//            int count1 = (int)item.get("count");
//            System.out.println("count1=>"+count1);
//            count += count1;
            count += (long)item.get("count");
        }

        return count;
    }
}
