package SocketCode;

import java.io.IOException;
import java.net.*;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class ConnectTester {
    public void connect(String host, int port) {
        SocketAddress remoteAddress = new InetSocketAddress(host, port);
        Socket socket = null;
        String result = "";
        try {
            long begin = System.currentTimeMillis();
            socket = new Socket();
            socket.connect(remoteAddress, 1000);

            long end = System.currentTimeMillis();
            result = (end - begin) + "ms";
        } catch (BindException e) {
            result = "local address and port can not be bind";
        }catch (UnknownHostException e){
            result = "UnKnow host ";
        }catch (ConnectException e){
            result ="connect refused";
        }catch (SocketTimeoutException e){
            result = "time out";
        }catch (IOException e){
            result = "failure";
        }finally {
            if(socket!=null) try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(remoteAddress+":"+result);
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 25 ;
        if(args.length>0){
            host=args[0];
            port=Integer.parseInt(args[1]);
        }
        new ConnectTester().connect(host,port);
    }
}
