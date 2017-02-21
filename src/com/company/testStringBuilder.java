package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuan4j on 2017/1/17.
 */
public class testStringBuilder {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("Test");
        StringBuilder s2 = new StringBuilder("Test");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2)); //Line 1
        System.out.println(s1.toString() == s2.toString()); //Line 2
//        if (s1.toString() == s2.toString()) System.out.println("True"); //Line 3
        System.out.println(s1.toString().equals(s2.toString()));

        Integer integer = new Integer(1);
        Integer integers = new Integer(1);
        System.out.println(integer==integers);
        System.out.println(integer.equals(integers));

        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
    }
}
