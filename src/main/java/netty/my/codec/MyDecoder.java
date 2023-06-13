package netty.my.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(
            ChannelHandlerContext channelHandlerContext,
            ByteBuf in,
            List<Object> list
    ) throws Exception {
        if (in.readableBytes() < 4) return;
        int len = in.readInt();
        if (in.readableBytes() < len) {
            in.resetReaderIndex();
            return;
        }
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        System.out.println(new String(bytes));
        in.markReaderIndex();
    }
}
