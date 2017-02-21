package com.company;

import java.util.*;

/**
 * Created by yuan4j on 2017/1/13.
 */
public class testset {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<String>();
        set1.add("a");
        set1.add("b");

        Set<String> set2 = new LinkedHashSet<String>();
        set2.add("a");
        set2.add("b");
        System.out.println(set1.equals(set2));
        System.out.println(set1==set2);

        Map<Integer ,String> map = new TreeMap<Integer, String>();
        map.put(80,"a");
        map.put(100,"b");
        map.put(70,"c");

        Set keyset = map.keySet();
        for (Object s : keyset) {
            System.out.println(s);
        }

        List<String> list= new ArrayList();
        list.add("v");
        list.add("a");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
