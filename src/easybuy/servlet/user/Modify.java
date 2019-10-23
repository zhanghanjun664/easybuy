package easybuy.servlet.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import easybuy.service.UserService;
import easybuy.service.impl.UserServiceImpl;
import easybuy.utils.Response;
import easybuy.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/user/modify")
public class Modify extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("dopost!");

        JSONObject params = Utils.getJsonObjecByWriter(req.getReader());
        System.out.println(params);

        String username = (String) params.get("username");
        String mobile = (String) params.get("mobile");
//        String sex = (String) params.get("sex");
        int sex = Integer.parseInt(String.valueOf(params.get("sex")));
        String email = (String) params.get("email");
        int id = (int) params.get("id");

        int result = userService.updateMemberInfo(id, username, mobile, email, sex);

        Response response = new Response();

        if(result > 0){
            System.out.println("update success!");
            response.setResultCode(0);
            response.setResultMsg("success");
        }else{
            System.out.println("update fail!");
            response.setResultCode(1);
            response.setResultMsg("fail");
        }

        String jsonString = response.getJsonString();
        resp.getWriter().write(jsonString);


    }
}
