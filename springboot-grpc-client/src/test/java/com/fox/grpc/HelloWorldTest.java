package com.fox.grpc;

import com.alibaba.fastjson.JSONObject;
import com.fox.grpc.helloworld.dto.GetRequest;
import com.fox.grpc.helloworld.dto.GetResponse;
import com.fox.grpc.helloworld.service.HelloWorldGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootClientApplication.class)
@Slf4j
public class HelloWorldTest {
    @GrpcClient("springbootGrpcClient")
    private HelloWorldGrpc.HelloWorldBlockingStub helloWorldBlockingStub;

    @GrpcClient("springbootGrpcClient")
    private HelloWorldGrpc.HelloWorldStub helloWorldStub;

    @PostMapping("/say")
    public String  say(@RequestParam(value = "parameter") String parameter){
        log.info("开始执行方法,对应的参数==========="+parameter);
        parameter="这是我第一次向你问好!";
        //请求参数初始化:
        GetRequest getRequest=GetRequest.newBuilder().setParameter(parameter).build();
        //调用接口:
        GetResponse getResponse=helloWorldBlockingStub.say(getRequest);
        log.info("执行完成返回结果======="+getResponse.getParameter());
        return JSONObject.toJSONString(getResponse.getParameter());
    }
}
