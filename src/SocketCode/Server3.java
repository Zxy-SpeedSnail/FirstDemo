package SocketCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class Server3 {
    private int port = 8000;
    private ServerSocket serverSocket;

    public Server3() throws IOException {
        serverSocket = new ServerSocket(port, 3);
        System.out.println("server start!");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("new connection accept"+socket.getInetAddress()+" "+socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket!=null) try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server3 server3 = new Server3();
//        Thread.sleep(6000);
        server3.service();
    }
}
