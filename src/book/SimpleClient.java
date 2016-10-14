package book;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by yuan on 16-10-12.
 */
public class SimpleClient {
    public static void main(String[] args) throws Exception {
        Socket s1 = new Socket("localhost",8000);
        System.out.println("first");
        Socket s2 = new Socket("localhost",8000);
        System.out.println("second");
        Socket s3 = new Socket("localhost",8000);
        System.out.println("third");
    }
}
