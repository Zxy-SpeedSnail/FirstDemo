package SocketCode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by yuan4j on 2017/3/3.
 */
public class EchoClient {
    private String host = "localhost";
    private int port = 8000;
    private Socket socket;

    InetAddress inetAddress = InetAddress.getLocalHost();
    public EchoClient() throws IOException {
        socket = new Socket(host, port);
    }

    private PrintWriter getWrite(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void talk() throws IOException {
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWrite(socket);

            BufferedReader localbr = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localbr.readLine()) != null) {
                pw.println(msg);
                System.out.println(br.readLine());

                if (msg.equals("bye")) {
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }
}
