package Demo;

import java.util.LinkedList;

/**
 * Created by yuan on 16-9-6.
 */
public class MainClass {
    public static void main(String[] a) {


        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list.get(3));
        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }
}
