package SocketCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yuan4j on 2017/3/3.
 */
public class EchoPlayer {
    public String echo(String s) {
        return "echo " + s;
    }

    public void talk() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(echo(msg));
            if (msg.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoPlayer().talk();
    }
}

