package day25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelpMethod {

    public static void sendFixedLengthMessage(SocketChannel socketChannel, String message) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(3);
            buffer.put(message.getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            System.out.println("Sent: " + message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String receiveFixedLengthMessage(SocketChannel socketChannel) {
        String message = "";
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(3);
            socketChannel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                message += (char) byteBuffer.get();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return message;
    }

    public static void sendMessage(SocketChannel socketChannel, String message) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(message.length() + 1);
            buffer.put(message.getBytes());
            buffer.put((byte) 0x00);  // 문자열의 끝을 확인하기 위해 NULL 문자 넣어줌
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            System.out.println("Sent: " + message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String receiveMessage(SocketChannel socketChannel) {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
            String message = "";
            while (socketChannel.read(byteBuffer) > 0) {
                char byteRead = 0x00;
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byteRead = (char) byteBuffer.get();
                    if (byteRead == 0x00) {
                        break;
                    }
                    message += byteRead;
                }
                if (byteRead == 0x00) {
                    break;
                }
                byteBuffer.clear();
            }
            return message;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
