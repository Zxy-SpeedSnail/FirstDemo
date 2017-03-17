package SocketCode.Httpserv.noBlockHttpServ;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yuan4j on 2017/3/16.
 */
//负责处理接收链接处理就绪事件
public class AcceptHandler implements Handler {
    public void handle(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel=(ServerSocketChannel)key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        if (socketChannel== null)return;
        System.out.println("接收到客户连接，来自:" +
                socketChannel.socket().getInetAddress() +
                ":" + socketChannel.socket().getPort());

        ChannelIO cio =new ChannelIO(socketChannel, false/*非阻塞模式*/);
        RequestHandler rh = new RequestHandler(cio);
        socketChannel.register(key.selector(), SelectionKey.OP_READ, rh);
    }
}