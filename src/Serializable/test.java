package Serializable;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yuan on 16-8-18.
 */
public class test {
    private static ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue(5);
    private static String [] a = {"a","a","a","a","a"};
    private static CopyOnWriteArrayList writeArrayList = new CopyOnWriteArrayList();
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                try {
                    System.out.println(blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run(){
                for(int i=0;i<a.length;i++){
                    try {
                        blockingQueue.put(a[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
