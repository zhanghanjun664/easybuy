package easybuy.servlet.user;

import easybuy.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/register")
public class Register extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String inviterName = req.getParameter("inviterName");
        String inviterID = req.getParameter("inviterID");

//        校验完成，注册
//        性别(1:男 0：女)
//        类型（1：后台 0:前台）
//        {userName, password, sex, identityCode, email, mobile, type};
        int result = userDao.register(username, password, 1, null, email, mobile, 0);
        int registerResult = 0;
        if(result > 0){
            System.out.println("注册成功");
            registerResult = 1;
        } else {
            System.out.println("注册失败");
            registerResult = 2;

        }

//        req.getRequestDispatcher("Regist.jsp").forward(req, resp);
        String redirectUrl = req.getContextPath() + "/Regist.jsp?registerResult="+registerResult;
        resp.sendRedirect(redirectUrl);


    }
}
