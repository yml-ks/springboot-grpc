# 1. grpc简介
gRPC  是google提供的一个高性能、开源和通用的 RPC 框架，在gRPC里客户端应用可以像调用本地对象一样直接调用另一台不同的机器上服务端应用的方法，使得您能够更容易地创建分布式应用和服务

使用grpc有几点优势：
* 更快的传输速度，底层序列化为二进制进行传输
* 基于IDL的统一的接口定义语言
* 跨平台多语言，支持C, C++, Python, PHP, Nodejs, C#, Objective-C、Golang、Java，并能够基于语言自动生成客户端和服务端功能库
* 基于HTTP 2.0标准设计，gRPC基于HTTP 2.0标准设计，带来了更多强大功能，如多路复用、二进制帧、头部压缩、推送机制

> 官网rpc基础示例https://grpc.io/docs/languages/java/basics/

