package SocketCode.Httpserv.noBlockHttpServ;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by yuan4j on 2017/3/16.
 */
public interface Handler {
    public void handle(SelectionKey selectionKey) throws IOException;
}
