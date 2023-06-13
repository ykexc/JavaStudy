package bio;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer {

    @SneakyThrows
    public static void main(String[] args){
        ServerSocket socket = new ServerSocket(9001);
        while (true) {
            System.out.println("---Waiting client connection---");
            Socket accept = socket.accept();
            System.out.println("There is a client connection");
            //handler(accept);  只能同时为一个客户端服务
            new Thread(() -> handler(accept)).start();  //多线程改进, 但还是存在服务资源浪费的情况
        }
    }

    @SneakyThrows
    public static void handler(Socket clientSocket) {
        byte[] bytes = new byte[1024];
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read finished");
        if (read != -1) System.out.println("message: " + new String(bytes, 0, read));
    }

}
