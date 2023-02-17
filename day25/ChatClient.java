package day25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClient {

    public ChatClient() {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            System.out.println("Connected to Chat Server");
            String message;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Receive message
                System.out.println("Waiting for message from the server ...");
                System.out.println("Message: "
                        + HelpMethod.receiveMessage(socketChannel));
//                System.out.println("Message: "
//                        + HelpMethod.receiveFixedLengthMessage(
//                                socketChannel));
                System.out.print("> ");
                message = scanner.nextLine();
                if (message.equalsIgnoreCase("quit")) {
                    HelpMethod.sendMessage(socketChannel, "Client terminating");
//                    HelpMethod.sendFixedLengthMessage(socketChannel, "Client terminating");
                    break;
                }
                // Send message
//                HelperMethods.sendMessage(socketChannel, message);
                HelpMethod.sendFixedLengthMessage(socketChannel, message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
