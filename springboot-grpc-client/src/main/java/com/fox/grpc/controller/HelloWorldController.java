package com.fox.grpc.controller;

import com.alibaba.fastjson.JSONObject;
import com.fox.grpc.helloworld.dto.GetRequest;
import com.fox.grpc.helloworld.dto.GetResponse;
import com.fox.grpc.helloworld.service.HelloWorldGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {
   @GrpcClient("springbootGrpcClient")
   private HelloWorldGrpc.HelloWorldBlockingStub helloWorldBlockingStub;
   /**
    * GRPC调用测试方法
    * G0012140-于明亮
    * 2021/11/9
    * @param parameter
    * @return
    */
   @PostMapping("/say")
   public String  say(@RequestParam(value = "parameter",required = false) String parameter){
      parameter="这是我第一次向你问好!";
      log.info("开始执行方法,对应的参数==========="+parameter+"\n");
      //请求参数初始化:
      GetRequest getRequest=GetRequest.newBuilder().setParameter(parameter).build();
      //调用接口:
      GetResponse getResponse=helloWorldBlockingStub.say(getRequest);
      log.info("执行完成返回结果======="+getResponse.getParameter());
      return JSONObject.toJSONString(getResponse.getParameter());
   }

}
