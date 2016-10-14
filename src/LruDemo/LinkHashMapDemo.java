package LruDemo;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by yuan on 16-8-11.
 */
public class LinkHashMapDemo {

    public static void main(String[] args) {
    LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1,'a');
        linkedHashMap.put(2,'b');
        linkedHashMap.put(3,'c');

//        System.out.println(linkedHashMap.get(1));
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
