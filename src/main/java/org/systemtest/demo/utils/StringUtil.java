package org.systemtest.demo.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author 12589
 */
public class StringUtil {
    public static String getRandomSalt(){
        SecureRandomNumberGenerator generator=new SecureRandomNumberGenerator();
        return generator.nextBytes(3).toHex();
    }

    public static String encryptPassword(String salt,String password){
        return new Md5Hash(salt+password).toHex();
    }

    public static void main(String[] args) {
        String salt=StringUtil.getRandomSalt();
        System.out.println(salt);

        String password=encryptPassword(salt,"123456");
        System.out.println(password);

    }
}
