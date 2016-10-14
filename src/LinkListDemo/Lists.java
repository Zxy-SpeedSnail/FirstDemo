package LinkListDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by yuan on 16-9-8.
 */

/**
 * 生成list的帮助类
 */

public class Lists {
    private Lists() { }
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }
    public static <E> ArrayList<E> newArrayListWithCapacity(int initialCapacity) {
        return new ArrayList<E>(initialCapacity);
    }
    public static <E> ArrayList<E> newArrayList(E... elements) {
        ArrayList<E> set = newArrayList();
        Collections.addAll(set, elements);
        return set;
    }
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements) {
        ArrayList<E> list = newArrayList();
        for(E e : elements) {
            list.add(e);
        }
        return list;
    }
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<E>();
    }
}
