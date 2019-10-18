package easybuy.utils;

public class Verify {

//姓名
    public static Boolean checkName(String name){
        String reg = "^[^0-9][\\\\w_]{5,9}$";
        if(name.matches(reg)){
            return true;
        } else {
            return false;
        }
    }

//密码
    public static Boolean checkPSW(String psw){
        String reg = "^[\\w_]{6,20}$";
        if(psw.matches(reg)){
            return true;
        } else {
            return false;
        }
    }

//    邮箱
    public static Boolean checkEmail(String email){
        String reg = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if(email.matches(reg)){
            return true;
        } else {
            return false;
        }
    }

    //    手机号
    public static Boolean checkMobile(String email){
        String reg = "^1\\d{10}";
        if(email.matches(reg)){
            return true;
        } else {
            return false;
        }
    }

}
