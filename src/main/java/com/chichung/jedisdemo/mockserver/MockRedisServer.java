package com.chichung.jedisdemo.mockserver;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模仿redis服务端进行抓包。分析jedis是怎么跟redis进行通信的。
 * -----
 * set name chichung 发过来之后，接收到的是
 * *3
 * $3
 * SET
 * $4
 * name
 * $8
 * chichung
 * ---
 * get name 发过来之后，接收到的是
 * *2
 * $3
 * GET
 * $4
 * name
 * ---
 * 这就是redis的RESP协议
 */
public class MockRedisServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6380);
        Socket socket = serverSocket.accept();
        byte[] b = new byte[1024];
        socket.getInputStream().read(b);
        System.out.println(new String(b));
    }
}
