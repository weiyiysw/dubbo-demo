# Dubbo-Demo

本项目是Dubbo的示例项目。采用技术Spring Boot + Dubbo + nacos。

实现的功能：2个服务提供方，1个服务消费方，同时自定义实现LoadBalance。

* demo-api：dubbo API接口项目
* demo-consumer：模拟dubbo消费方，同时实现了Demo2Service接口，作为服务提供方，自己消费
* demo-server：模拟dubbo服务provider1
* demo-server2：模拟dubbo服务provider2

> 本项目运行起来，依赖于nacos。请先自行安装并运行nacos，并配置域名指向nacos地址。

实现自定义的LoadBalance，通过`RpcContext.getContext().setAttachment()`方法隐式传入参数。

本例子使用隐式参数，为了在LoadBalance中，根据传入的参数选择服务Provider。

> 隐式参数能够做的更多。