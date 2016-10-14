package book;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yuan on 16-10-12.
 */
public class HttpClient {
    String host= "www.javathinker.org";
    int port = 80;
    Socket socket;
    public void createSocket() throws IOException {
        socket = new Socket(host,port);
    }
    public void communicate() throws IOException {
        StringBuffer sb = new StringBuffer("GET"+"/index.jsp"+"HTTP/1.1\r\n");
        sb.append("Host:www.javathinker.org\r\n");
        sb.append("Accept:*/*\r\n");
        sb.append("Accept-Language:zh-cn\r\n");
        sb.append("Accept-Encoding:gzip,deflate\r\n");
        sb.append("User-Agent:Mozilla/4.0(compatible;MSIE6.0;Windows NT 5.0)\r\n");
        sb.append("Connection:Keep-Alive\r\n\r\n");

        //发出HTTP请求
        OutputStream soout = socket.getOutputStream();
        soout.write(sb.toString().getBytes());
        socket.shutdownOutput();

        //接收相应结果
        InputStream socin = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[]buff = new byte[1024];
        int len = -1;
        while ((len=socin.read(buff))!=-1){
            buffer.write(buff,0,len);
        }
        System.out.println(new String(buffer.toByteArray()));
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        client.createSocket();
        client.communicate();
    }
}
