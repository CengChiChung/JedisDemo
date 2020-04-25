package com.chichung.jedisdemo;

import com.chichung.jedisdemo.mockclient.api.Client;

public class TestClient {
    public static void main(String[] args) {
        Client client = new Client("192.168.50.48", 6380);
        String str1 = client.set("name", "chichung");
        System.out.println(str1);
        System.out.println("---");
        String str2 = client.get("name");
        System.out.println(str2);
    }
}
