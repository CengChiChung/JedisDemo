package com.chichung.jedisdemo.mockclient.util;

import java.io.UnsupportedEncodingException;

public class SafeEncoder {

    public static byte[] encode(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
