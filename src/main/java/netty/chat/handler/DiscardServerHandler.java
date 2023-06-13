package netty.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.HashSet;
import java.util.Set;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    static Set<Channel> channels = new HashSet<>();

    /**
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        channels.forEach(e -> e.writeAndFlush("[客户端]" + ctx.channel().remoteAddress()));
//        channels.add(ctx.channel());
    }

    /**
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  //netty底层只任ByteBuf


        String message = (String) msg;
//        channels.forEach(e -> {
//            if (e == ctx.channel()) {
//                e.writeAndFlush("[me]: " + message);
//            } else {
//                e.writeAndFlush("[客户端] " + ctx.channel().remoteAddress() + ": " + message);
//            }
//        });
        System.out.println("收到数据: " + msg);
    }


    /**
     * @param ctx
     * @throws Exception channel 不活跃时调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        channels.remove(ctx.channel());
//        channels.forEach(e -> {
//            e.writeAndFlush("[客户端] " + ctx.channel().remoteAddress() + " 下线了");
//        });
    }
}
