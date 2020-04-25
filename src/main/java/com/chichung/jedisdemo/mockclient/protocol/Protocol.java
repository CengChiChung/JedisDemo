package com.chichung.jedisdemo.mockclient.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
    private static final String DOLLAR_BYTE="$";
    private static final String ASTERISK_BYTE="*";
    private static final String BLANK_BYTE="\r\n";

    public enum Command{
        SET,GET,AUTH
    }

    public static void sendCommand(OutputStream outputStream,Command command, byte[] ... args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ASTERISK_BYTE).append(args.length + 1).append(BLANK_BYTE);
        stringBuffer.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE);
        stringBuffer.append(command.name()).append(BLANK_BYTE);
        for (byte[] arg : args) {
            stringBuffer.append(DOLLAR_BYTE).append(arg.length).append(BLANK_BYTE);
            stringBuffer.append(new String(arg)).append(BLANK_BYTE);
        }
        try {
            outputStream.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
