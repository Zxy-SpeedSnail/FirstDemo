package SocketCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yuan4j on 2017/3/7.
 */
//线程控制接收socket服务
public class EchoServer2 {
    private int port = 8000;
    private ServerSocket serverSocket;

    public EchoServer2() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("server start!");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                Thread workthread = new Thread(new Handler(socket));
                workthread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Handler implements Runnable {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public String echo(String msg) {
            return "server 端发送 " + msg;
        }

        private PrintWriter getWrite(Socket socket) throws IOException {
            OutputStream socketOut = socket.getOutputStream();
            return new PrintWriter(socketOut, true);
        }

        private BufferedReader getReader(Socket socket) throws IOException {
            InputStream socketIn = socket.getInputStream();
            return new BufferedReader(new InputStreamReader(socketIn));
        }

        @Override
        public void run() {
            try {

                System.out.println("New socket accept " + socket.getInetAddress() + " " + socket.getPort());
                BufferedReader br = getReader(socket);
                PrintWriter pw = getWrite(socket);

                String msg = null;
                while ((msg=br.readLine())!=null){
                    System.out.println(msg);
                    pw.println(echo(msg));
                    if(msg.equals("bye")){
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer2().service();
    }
}
