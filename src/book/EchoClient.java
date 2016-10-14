package book;

import java.io.*;
import java.net.Socket;

/**
 * Created by yuan on 16-10-12.
 */
public class EchoClient {
    private String host = "localhost";
    private int port =  8000;
    private Socket socket;

    public EchoClient() throws IOException {
        socket = new Socket(host,port);
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }

    private PrintWriter getWrite(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    private void talk() {
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pr = getWrite(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while((msg=localReader.readLine())!=null){
                pr.println(msg);
                System.out.println(br.readLine());
                if(msg.equals("bye"))
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
