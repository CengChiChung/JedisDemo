package com.chichung.jedisdemo.mockclient.api;

import com.chichung.jedisdemo.mockclient.connection.Connection;
import com.chichung.jedisdemo.mockclient.protocol.Protocol;
import com.chichung.jedisdemo.mockclient.util.SafeEncoder;

/**
 * Api操作层
 * 就是给程序员提供API接口的
 */
public class Client {

    private Connection connection;

    /**
     * 连接客户端
     * @param host ip地址
     * @param port 端口号
     */
    public Client(String host,int port) {
        connection = new Connection(host, port);
    }

    public String set(String key,String value) {
        connection.sendCommand(Protocol.Command.SET,SafeEncoder.encode(key),SafeEncoder.encode(value));
        return connection.getStatusReply();
    }

    public String get(String key) {
        connection.sendCommand(Protocol.Command.GET,SafeEncoder.encode(key));
        return connection.getStatusReply();
    }
}
