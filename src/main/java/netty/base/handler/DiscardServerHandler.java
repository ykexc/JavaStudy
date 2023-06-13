package netty.base.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.Buffer;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有客户端连接");
    }

    /**
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        int grade = Integer.parseInt(byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println(grade < 60 ? "bujige" : grade == 100 ? "满分" : "及格");
    }
}
