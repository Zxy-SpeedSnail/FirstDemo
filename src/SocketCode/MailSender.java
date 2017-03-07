package SocketCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by yuan4j on 2017/3/6.
 */
public class MailSender {
    private String smtpServer = "smtp.mydomain.com";
    private int port = 25;

    public static void main(String[] args) {
        Message message = new Message("13622185659@163.com","zhouxueyuan@lsh123.com","hello","miss you my my me");
        new MailSender().sendMail(message);
    }

    private void sendMail(Message message) {
        Socket socket = null;
        try {
            socket=new Socket(smtpServer,port);
//            BufferedReader br = getReader()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Message{
        String from;
        String to;
        String subject;
        String content;
        String data;
        public Message(String from,String to,String subject,String content){
            this.from=from;
            this.to= to;
            this.subject= subject;
            this.content= content;
            this.data="subject:"+subject+"\r\n"+content;
        }
    }
}
