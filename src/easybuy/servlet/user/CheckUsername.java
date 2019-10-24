package easybuy.servlet.user;

import easybuy.service.UserService;
import easybuy.service.impl.UserServiceImpl;
import easybuy.utils.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user/check")
public class CheckUsername extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        Boolean isExist = userService.checkUsername(username);

        Response response = new Response();
        HashMap<Object, Object> respMap = new HashMap<>();
        // 请求成功
        response.setResultCode(0);
        response.setResultMsg("success");

        if(isExist){
            respMap.put("isExist", true);
        }else{
            respMap.put("isExist", false);
        }
        response.setData(respMap);
        String jsonString = response.getJsonString();
        resp.getWriter().write(jsonString);

    }
}
