package com.fox.grpc.service.impl;

import com.fox.grpc.helloworld.dto.GetRequest;
import com.fox.grpc.helloworld.dto.GetResponse;
import com.fox.grpc.helloworld.service.HelloWorldGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * GRPC服务提供者
 * G0012140-于明亮
 * 2021/11/19
 */
//一定添加此标签
@GrpcService
@Slf4j
public class HelloWorldServiceImpl  extends HelloWorldGrpc.HelloWorldImplBase {
    /**
     * 服务测试接口
     * G0012140-于明亮
     * 2021/11/19
     * @param request 请求参数
     * @param responseObserver 返回参数
     */
    @Override
    public void say(GetRequest request, StreamObserver<GetResponse> responseObserver) {
        log.info("前一个服务传输的参数是======"+request.getParameter());
        GetResponse getResponse= GetResponse.newBuilder().setParameter("您的信息我已经收到").build();
        responseObserver.onNext(getResponse);
        responseObserver.onCompleted();
    }
}
