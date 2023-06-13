package netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf {


    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 5; i++) {
            byteBuf.writeByte(i);
        }
        System.out.println("byteBuf: " + byteBuf);

        for (int i = 0; i < 5; i++) {
            byteBuf.getByte(i);
        }
        System.out.println("byteBuf = " + byteBuf);

        for (int i = 0; i < 5; i++) {
            byteBuf.readByte();
        }
        System.out.println("byteBuf = " + byteBuf);

    }

}
