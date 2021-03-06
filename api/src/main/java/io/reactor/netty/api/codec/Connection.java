package io.reactor.netty.api.codec;

import io.reactor.netty.api.codec.TransportMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.NettyContext;
import reactor.ipc.netty.NettyInbound;
import reactor.ipc.netty.NettyOutbound;

import java.net.InetSocketAddress;


/**
 * @Auther: lxr
 * @Date: 2018/10/30 14:46
 * @Description:
 */
public interface Connection {

    NettyInbound getInbound();

    NettyOutbound getOutbound();

    NettyContext getContext();

    Mono<Void>   dispose();

    Mono<NettyInbound> onReadIdle(Long l, Runnable readLe);

    Mono<NettyOutbound> onWriteIdle(Long l, Runnable writeLe);

    Flux<TransportMessage> receiveMsg();

    Mono<InetSocketAddress> address();

    void onClose(Runnable remove);


}
