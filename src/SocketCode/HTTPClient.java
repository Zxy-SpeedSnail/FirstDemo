package SocketCode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class HTTPClient {
    String host = "www.javathinker.org";
    int port = 80;
    Socket socket;

    public void createConnect() throws IOException {
        socket = new Socket(host, port);
    }

    public void communicate() throws IOException {
        StringBuffer sb = new StringBuffer("GET" + "/index.jsp" + "HTTP/1.1\r\n");
        sb.append("Host:www.javathinker.org\r\n");
        sb.append("Accept:*/*\r\n");
        sb.append("Accept-Language:zh-cn\r\n");
        sb.append("Accept-Encoding:gzip,deflate\r\n");
        sb.append("User-Agent:Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.0)\r\n");
        sb.append("Connection:Keep-Alive\r\n\r\n");
        //发Http请求
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(sb.toString().getBytes());
        socket.shutdownOutput();

        //接收响应
        InputStream socketIn = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len =socketIn.read(bytes))!=-1){
            buffer.write(bytes,0,len);
        }
        System.out.println(new String(buffer.toByteArray()));
        socket.close();

    }

    public static void main(String[] args) throws IOException {
        HTTPClient httpClient = new HTTPClient();
        httpClient.createConnect();
        httpClient.communicate();
    }
}
