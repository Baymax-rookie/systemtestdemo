package org.systemtest.demo.utils;

/**
 * @author 12589
 */
public class RandomUtil {
    public static String getHtml(String str) {
        return "Email地址验证<br/>" +
                "这封邮件是由XXX测试发送的。<br/>" +
                "<br/>" +
                "下面验证码也是测试所用：<h3 style='color:red;'>" + str + "</h3><br/>";
    }
    public static String getRandom(){
        String[] strs=new String[]{"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
                "A","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
                "0","1","2","3","4","5","6","7","8","9"};
        StringBuilder code= new StringBuilder();
        for (int i=0;i<4;i++){
            code.append(strs[(int) Math.floor(Math.random() * strs.length)]);
        }
        return code.toString();
    }
}
