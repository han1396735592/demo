package cn.qqhxj.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class Filter implements GlobalFilter, Ordered {
    @Value("${server.port}")
    private Integer serverPort;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
//        System.out.println(request);
//        ServerHttpResponse response = exchange.getResponse();
//
//        DataBuffer wrap = response.bufferFactory().wrap("err ".getBytes());
//
//        return response.writeWith(Mono.just(wrap));

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
