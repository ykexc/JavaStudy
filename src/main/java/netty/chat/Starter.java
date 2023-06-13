package netty.chat;

import netty.chat.server.DiscardServer;

public class Starter {


    public static void main(String[] args) {
        try {
            new DiscardServer(9001).run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
