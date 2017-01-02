package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuan4j on 2016/11/15.
 */
public class testAutomic {
    public static AtomicInteger integer = new AtomicInteger();

    public static void main( String[] args) {
        integer.incrementAndGet();
    }
}
