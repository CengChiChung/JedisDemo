package com.chichung.jedisdemo.mockclient.connection;

import com.chichung.jedisdemo.mockclient.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 传输层
 */
public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 获取连接
     */
    private void connect() {
        try {
            // IO复用
            if (!isConnected()) {
                socket = new Socket(host, port);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断socket连接是否存活
     * @return
     */
    private boolean isConnected() {
        return socket != null
                && socket.isBound()
                && !socket.isClosed()
                && socket.isConnected()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown();
    }

    /**
     * 发送命令
     * @param command
     * @param args
     */
    public void sendCommand(Protocol.Command command,byte[]... args) {
        this.connect();
        Protocol.sendCommand(outputStream,command,args);
    }

    /**
     * 获取返回状态码
     * @return
     */
    public String getStatusReply() {
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
}
