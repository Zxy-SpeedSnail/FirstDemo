package SocketCode;

import java.net.Socket;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class Client3 {
    public static void main(String[] args) throws Exception {
        final int lenght = 100;
        String hsot = "localhost";
        int port = 8000;

        Socket[] sockets = new Socket[lenght];
        for(int i =0 ;i<lenght;i++){
            sockets[i]=new Socket(hsot,port);
            System.out.println("第"+(i+1)+"次链接成功");

        }
        Thread.sleep(3000);
        for(int i = 0;i<lenght;i++){
            sockets[i].close();
        }
    }
}
