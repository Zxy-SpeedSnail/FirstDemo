package book;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by yuan on 16-10-12.
 */
public class SimpleServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8000,1);
        Thread.sleep(360000);
    }
}
