package netty.heartbeat.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.util.HashMap;

import static io.netty.handler.timeout.IdleState.ALL_IDLE;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * @param ctx
     * @param evt
     * @throws Exception
     */
    int k = 0;
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent event = (IdleStateEvent) evt;
        if (event.state() == ALL_IDLE) k++;
        if (k == 3) ctx.close();
        System.out.println("触发了" + event.state() + "事件");
    }
}
