package com.xuchao.netty.test.handler;

import com.xuchao.netty.domain.ReqDeviceData;
import com.xuchao.netty.domain.RspDeviceData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ReqDeviceData reqDeviceData = new ReqDeviceData();
        reqDeviceData.setTag("conn");
        reqDeviceData.setDeviceNo("d001");

        ctx.writeAndFlush(reqDeviceData);

        // 连接10秒后客户端主动断开
//        ThreadUtil.sleep(10000);
//        log.info("测试10s后客户端主动断开连接");
//        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            RspDeviceData rspDeviceData = (RspDeviceData) msg;
            log.info("客户端接收数据：" + rspDeviceData);

            ReqDeviceData reqDeviceData = new ReqDeviceData();
            reqDeviceData.setTag("result");
            reqDeviceData.setDeviceNo(rspDeviceData.getDeviceNo());
            reqDeviceData.setData("ok");

            ctx.writeAndFlush(reqDeviceData);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("channelInactive");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        log.info("handlerRemoved");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当异常时释放关闭连接
        log.info("exceptionCaught");
        cause.printStackTrace();
    }
}
