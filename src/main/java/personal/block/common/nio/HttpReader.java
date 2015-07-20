package personal.block.common.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by yaoqijun.
 * Date:2015-07-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class HttpReader {

    public static void main(String args[]) throws Exception {
        Charset charset = Charset.forName("GBK");
        SocketChannel socketChannel;
        InetSocketAddress address = new InetSocketAddress("www.upc.edu.cn",80);

        socketChannel = SocketChannel.open(address);

        socketChannel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (socketChannel.read(buffer)!=-1){
            buffer.flip();
            System.out.println(charset.decode(buffer));
            buffer.clear();
        }

        socketChannel.close();
        System.out.println("finish");
    }

}
