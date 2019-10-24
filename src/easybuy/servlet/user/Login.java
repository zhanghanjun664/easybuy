package easybuy.servlet.user;

import easybuy.bean.Easybuy_user;
import easybuy.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/user/login")
public class Login extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String saveInfo = req.getParameter("saveInfo");

//校验完成
        Easybuy_user user = userDao.login(username, password);


        System.out.println(user);
//        String userName = user.getUserName();

        String redirectUrl = req.getContextPath();
//        String redirectUrl = "";
        if(user != null){
            System.out.println("登录成功"+username);
//            redirectUrl += "/Index.jsp?username="+URLEncoder.encode(username, "UTF-8");
            int level = user.getLevel();
            if(level == 3){
                redirectUrl += "/memberCategory";
            }
//            redirectUrl += "/";

//           登录成功，设置用户信息
            username = URLEncoder.encode(username, "UTF-8");
            password = URLEncoder.encode(password, "UTF-8");
            System.out.println(username);
            System.out.println(password);
            Cookie name = new Cookie("username", username);
            Cookie psw = new Cookie("password", password);
            name.setMaxAge(60*60*8);
            psw.setMaxAge(60*60*8);
            String host = "localhost";
            name.setDomain(host);
            name.setPath("/");
            psw.setDomain(host);
            psw.setPath("/");

            resp.addCookie(name);
            resp.addCookie(psw);


            //        选中状态：on
            if(saveInfo != null){
                Cookie saveInfoCookie = new Cookie("saveInfo", "true");
                saveInfoCookie.setMaxAge(60*60*8);
                saveInfoCookie.setDomain(host);
                saveInfoCookie.setPath("/");
                resp.addCookie(saveInfoCookie);
            }

        } else {
            System.out.println("登录失败");
            redirectUrl += "/Login.jsp?loginStatus=fail";
        }
        System.out.println("=========="+redirectUrl);

        resp.sendRedirect(redirectUrl);
//        req.getRequestDispatcher("../Index").forward(req, resp);

    }
}
