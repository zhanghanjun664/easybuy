package easybuy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.Cookie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Utils {

    public static String getCookieByName(String name, Cookie[] cookies){
        String value = "";
        if(cookies.length == 0) return null;
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                try {
                    value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return value;
    }

//    读取数据，返回字符串
    public static JSONObject getJsonObjecByWriter(BufferedReader reader) throws IOException {
        String datas = "", str ="";
        while ((str = reader.readLine()) != null){
            datas += str;
        }

        JSONObject jsonObject = JSON.parseObject(datas);

        reader.close();

        return jsonObject;
    }
}
