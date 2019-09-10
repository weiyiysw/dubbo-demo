package com.weiyiysw.dubbo.server.serviceimpl;

import com.weiyiysw.dubbo.demo.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author yishiwei
 * @date 2019/9/10
 */

@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Value("${demo.service.name}")
    private String serviceName;

    @Override
    public String sayName(String name) {
        return serviceName + " hello " + name;
    }
}
