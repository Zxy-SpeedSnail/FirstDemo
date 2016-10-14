package book;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by yuan on 16-10-12.
 */
public class PortScanner {
    public void scan(String host){
        Socket socket = null;
        for(int port = 1;port<1024;port++){
            try {
                socket = new Socket(host,port);
                System.out.println("there is a server on port" +port);

            } catch (IOException e) {
                System.out.println("Cannot connect to port "+port);

            }finally {
                if(socket!=null)
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        if(args.length>0)
            host=args[0];
        new PortScanner().scan(host);
    }
}
