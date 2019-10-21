package easybuy.utils;

import javax.servlet.http.Cookie;
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
}
