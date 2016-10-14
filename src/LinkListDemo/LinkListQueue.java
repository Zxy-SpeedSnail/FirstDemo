package LinkListDemo;

import java.util.LinkedList;

/**
 * Created by yuan on 16-9-6.
 */

/**
 * 用LinkList实现队列
 */
public class LinkListQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 10; i++)
            queue.put(Integer.toString(i));
        while (!queue.isEmpty())
            System.out.println(queue.get());
    }
}
class Queue {
    private LinkedList list = new LinkedList();
    public void put(Object v) {
        list.addFirst(v);
    }
    public Object get() {
        return list.removeLast();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}