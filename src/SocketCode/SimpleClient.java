package SocketCode;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {
        for(int i = 1;i<=3;i++){
            Socket socket = new Socket("localhost",8000);
            System.out.println("第"+i+"次链接成功");
        }
    }
}
