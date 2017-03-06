package SocketCode;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class SimpleServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket =new ServerSocket(8000,2);
        Thread.sleep(3600);
    }
}
