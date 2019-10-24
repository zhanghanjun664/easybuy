package easybuy.servlet.user;

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
import java.io.IOException;


@WebServlet("/user/delete")
public class Delete extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JSONObject params = Utils.getJsonObjecByReader(req.getReader());

        Integer uid = params.getInteger("uid");
        System.out.println("params:"+params);

        int result = userService.deleteMember(uid);

        Response response = new Response();
        if(result > 0){
            System.out.println("删除成功");
            response.setResultCode(0);
            response.setResultMsg("success");
        } else {
            System.out.println("删除失败");
            response.setResultCode(1);
            response.setResultMsg("fail");
        }

        String jsonString = response.getJsonString();
        resp.getWriter().write(jsonString);

    }
}
