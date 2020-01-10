package com.example.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Netty implements ApplicationRunner , ApplicationContextAware {

    public Netty(){
        System.out.println(Thread.currentThread());
    }
    @Autowired
    private EchoChannelInboundHandler echoChannelInboundHandler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        NioEventLoopGroup bootstrapGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(bootstrapGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel serverSocketChannel) throws Exception {
                            ChannelPipeline pipeline = serverSocketChannel.pipeline();
                            pipeline.addFirst(echoChannelInboundHandler);
                            pipeline.addFirst(new StringDecoder());
                            pipeline.addFirst(new StringEncoder());
                            System.out.println(pipeline);
                        }
                    });
            ChannelFuture sync = bootstrap.bind(8888).sync();
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            bootstrapGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
