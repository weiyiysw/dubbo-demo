package com.weiyiysw.demo.consumer.controller;

import com.weiyiysw.dubbo.demo.api.Demo2Service;
import com.weiyiysw.dubbo.demo.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yishiwei
 * @date 2019/9/10
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Reference(version = "1.0.0", loadbalance = "mylb")
    private DemoService demoService;

    @Resource
    private Demo2Service demo2Service;

    /**
     * rpc调用添加传递隐式参数
     * @param name
     * @param port
     * @return
     */
    @RequestMapping(value = "sayName/{name}/{port}", method = RequestMethod.GET)
    public String callDubboSayName(@PathVariable String name, @PathVariable String port) {
        RpcContext.getContext().setAttachment("test", name);
        RpcContext.getContext().setAttachment("port", port);
        String value = demoService.sayName(name);
        return value;
    }

    /**
     * 本地即使provider,也是consumer时，consumer只调用本地的接口测试
     * @param name
     * @param port
     * @return
     */
    @RequestMapping(value = "sayName2/{name}/{port}", method = RequestMethod.GET)
    public String callLocalSayName(@PathVariable String name, @PathVariable String port) {
        return demo2Service.sayName(name);
    }
}
