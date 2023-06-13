package nio;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NioServer {

    static List<SocketChannel> socketChannelList = new ArrayList<>();

    @SneakyThrows
    public static void main(String[] args) {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9001));
        serverSocket.configureBlocking(false);  //设置非阻塞
        System.out.println("Service started successfully");

        while (true) {
            SocketChannel accept = serverSocket.accept();
            if (accept != null) {
                System.out.println("There is a client connection");
                accept.configureBlocking(false);  //设置非阻塞
                socketChannelList.add(accept);
            }
            Iterator<SocketChannel> iterator = socketChannelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel next = iterator.next();
                ByteBuffer buffer = ByteBuffer.allocate(128);
                int read = next.read(buffer);
                if (read > 0) {
                    System.out.println(Thread.currentThread().getName() + " " + "message: " + new String(buffer.array()));
                } else if (read == -1){
                    iterator.remove();
                    System.out.println("Client disconnected");
                }
            }
        }
    }
}
