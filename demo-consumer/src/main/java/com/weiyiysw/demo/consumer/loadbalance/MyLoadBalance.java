package com.weiyiysw.demo.consumer.loadbalance;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @author yishiwei
 * @date 2019/9/10
 */
public class MyLoadBalance implements LoadBalance {

    @Value("${dubbo.invoker.name}")
    private String name;

    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        if (invokers == null || invokers.isEmpty()) {
            return null;
        }
        if (invokers.size() == 1) {
            return invokers.get(0);
        }
        for (Invoker invoker : invokers) {
            System.out.println("invoker port: " + invoker.getUrl().getPort());
            System.out.println(invocation.getAttachment("test"));
            String portStr = invocation.getAttachment("port");
            int port = Integer.parseInt(portStr);
            if (invoker.getUrl().getPort() == port) {
                return invoker;
            }
        }
        return invokers.get(0);
    }
}
