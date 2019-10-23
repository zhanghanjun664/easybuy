package easybuy.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class Response {
    private Object data;
//    success  /  fail
    private String resultMsg;
//    0:成功   1:失败
    private int resultCode;

    public Response(Object data, String resultMsg, int resultCode) {
        this.resultMsg = resultMsg;
        this.resultCode = resultCode;
        this.data = data;
    }

    public Response() {
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getJsonString(){
        HashMap map = new HashMap();
        map.put("data", data);
        map.put("resultCode", resultCode);
        map.put("resultMsg", resultMsg);
        String string = JSON.toJSONString(map);
        return string;
    }
}
