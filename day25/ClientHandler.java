package day25;

import java.nio.channels.SocketChannel;

public class ClientHandler implements Runnable{

    private final SocketChannel socketChannel;

    public ClientHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public void run() {
        System.out.println("ClientHandler Started for " + this.socketChannel);
        String partName;
        while (true) {
            partName = HelpMethod.receiveMessage(socketChannel);
            if (partName.equalsIgnoreCase("quit")) {
                break;
            } else {
                Float price = PartsServer.getPrice(partName);
                HelpMethod.sendMessage(socketChannel, price.toString());
            }
        }
        System.out.println("ClientHandler Terminated for " + this.socketChannel);
    }
}
