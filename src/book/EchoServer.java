package book;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yuan on 16-10-12.
 */
public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }
    public String echo (String msg){
        return "echo"+msg;
    }

    private PrintWriter getWrite(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void service(){
        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New connection accept" + socket.getInetAddress() +"."+socket.getPort());
                BufferedReader br = getReader(socket);

                PrintWriter pr = getWrite(socket);
                String msg = null;

                while ((msg = br.readLine())!=null){
                    System.out.println(msg);
                    pr.println(echo(msg));
                    if(msg.equals("bye"))
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                    if(socket!=null)
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}
