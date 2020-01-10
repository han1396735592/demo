package com.example.demo;

import io.netty.channel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 */
@ChannelHandler.Sharable
@Component
@RestController
public class EchoChannelInboundHandler extends SimpleChannelInboundHandler<String> {

    private Set<Channel> channelSet = new HashSet<>();

    @GetMapping("/send")
    public String send(@RequestParam String s) {
        channelSet.forEach(channel -> {
            System.out.println(s+channel.remoteAddress());
            channel.writeAndFlush(s);
        });
        return s;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("aaa");
        channelSet.add(ctx.channel());
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
        System.out.println(s.getClass());
        System.out.println(s.getClass());
        System.out.println(s.getClass());
        System.out.println("a");
        channelHandlerContext.writeAndFlush(s);
    }
}
