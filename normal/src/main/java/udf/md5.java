package udf;


import org.apache.hadoop.hive.ql.exec.UDF;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author:MarryCheck
 * create 2018-11-18 12:11
 * comment: hive 加密udf函数
 */

public class md5 extends UDF{
    public String evaluate(String col){
        MessageDigest md5 = null;
        if (col == null){
            return null;
        }
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] byteArray = md5.digest(col.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b:byteArray){
                int number = b & 0XFF;
                String s = Integer.toHexString(number);
                if (s.length() ==1){
                    sb.append("0");
                }else {
                    sb.append(s);
                }
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String a = null;
        md5 m = new md5();
        System.out.println(m.evaluate(a));
    }
}
