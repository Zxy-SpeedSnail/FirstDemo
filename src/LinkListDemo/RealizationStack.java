package LinkListDemo;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by yuan on 16-9-8.
 */
public class RealizationStack {
    public static void main(String[] args) {

        /**
         * 实现栈
         */
        LinkedList stack = new LinkedList();
        Object object = "";
        stack.addFirst(object);
        Object o = stack.getFirst();
        stack = (LinkedList) Collections.synchronizedList(stack);


        /**
         * 实现队列
         */
//        LinkedList queue = new LinkedList();
//        Object object = "";
//        // Add to end of queue
//        queue.add(object);
//        // Get head of queue
//        Object o = queue.removeFirst();


        /**
         * 同步方法
         */
//        LinkedList queue = new LinkedList();
//        Object object = "";
//        queue.add(object);
//        Object o = queue.removeFirst();
//        queue = (LinkedList) Collections.synchronizedList(queue);



    }
}
