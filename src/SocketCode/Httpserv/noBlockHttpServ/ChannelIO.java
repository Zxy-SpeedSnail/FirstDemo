package SocketCode.Httpserv.noBlockHttpServ;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yuan4j on 2017/3/16.
 */
public class ChannelIO {
    protected SocketChannel socketChannel;
    protected ByteBuffer requestBuffer;
    private static int requestBufferSize = 4096;

    public ChannelIO(SocketChannel socketChannel, boolean blocking) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(blocking);
        requestBuffer = ByteBuffer.allocate(requestBufferSize);
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    /**
     * 如果原缓冲区的剩余容量不够，就创建一个新的缓冲区，容量为原来的两倍,
     * 把原来缓冲区的数据拷贝到新缓冲区
     */
    protected void resizeRequestBuffer(int remaining) {

        if (requestBuffer.remaining() < remaining) {    //requestBuffer.remaining()剩余可用空间
            //扩大两倍
            ByteBuffer bb = ByteBuffer.allocate(requestBuffer.capacity() * 2);
            requestBuffer.flip();
            bb.put(requestBuffer);  //原数据复制到新缓冲区。
            requestBuffer = bb;
        }
    }

    /**
     * 接收数据，把它们存放到requestBuffer中，如果requsetBuffer的剩余容量不足5%，
     * 就调用resizeRequestBuffer()方法扩充容量
     */
    public int read() throws IOException {
        resizeRequestBuffer(requestBufferSize / 20);
        return socketChannel.read(requestBuffer);
    }

    /**
     * 返回requestBUffer ,它存放了所有请求数据
     */
    public ByteBuffer getReadBuf() {
        return requestBuffer;
    }

    /**
     * 发送参数指定的ByteBuffer中的数据
     */
    public int write(ByteBuffer src) throws IOException {
        return socketChannel.write(src);
    }

    /**
     * 把FileChannel中的数据写到SocketChannel中
     */
    public long transferTo(FileChannel fc, long pos, long len) throws IOException {
        return fc.transferTo(pos, len, socketChannel);
    }

    /**
     * 关闭SocketChannel
     */
    public void close() throws IOException {
        socketChannel.close();
    }
}
