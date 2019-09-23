package com.weiyiysw.demo.consumer.controller;

import com.weiyiysw.dubbo.demo.api.Demo2Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yishiwei
 * @date 2019/9/23
 */
@RestController
@RequestMapping("rpc")
public class RpcController {

    @Reference(version = "1.0.0", check = false)
    private Demo2Service rpcDemo2Service;

    @RequestMapping(value = "sayName2/{name}/{port}", method = RequestMethod.GET)
    public String callLocalSayName(@PathVariable String name, @PathVariable String port) {
        return rpcDemo2Service.sayName(name);
    }
}
