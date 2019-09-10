package com.weiyiysw.demo.consumer.controller;

import com.weiyiysw.dubbo.demo.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yishiwei
 * @date 2019/9/10
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Reference(version = "1.0.0", loadbalance = "mylb")
    private DemoService demoService;

    @RequestMapping(value = "sayName/{name}", method = RequestMethod.GET)
    public String callDubboSayName(@PathVariable String name) {
        return demoService.sayName(name);
    }
}
