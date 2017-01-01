package lsh;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouxueyuan on 16/10/31.
 */
public class firstDemo {
    public static void main(String[] args) {
//        String s ="";
//        s.charAt(3);
//        System.out.println(1);

        String b =a();
        System.out.println(b);
        Map map = new HashMap();
        map.put("a","b");
        map.put("c","v");
        map.put("g","b");
        System.out.println(map.toString());
    }
    public static String a(){
        if(true){
            System.out.println("v");
            return "qw";
        }
        System.out.println("a");
        return "cxcxcx";
    }
}
