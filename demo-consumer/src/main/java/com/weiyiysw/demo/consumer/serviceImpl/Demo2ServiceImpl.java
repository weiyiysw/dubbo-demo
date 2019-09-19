package com.weiyiysw.demo.consumer.serviceImpl;

import com.weiyiysw.dubbo.demo.api.Demo2Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author yishiwei
 * @date 2019/9/10
 */

@Service(version = "${demo.service.version}")
public class Demo2ServiceImpl implements Demo2Service {

    @Value("${demo.service.name}")
    private String serviceName;

    @Override
    public String sayName(String name) {
        return serviceName + " hello " + name;
    }
}
