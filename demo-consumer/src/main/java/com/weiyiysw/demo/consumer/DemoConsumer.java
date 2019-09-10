package com.weiyiysw.demo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yishiwei
 * @date 2019/9/10
 */
@EnableDubbo
@SpringBootApplication
public class DemoConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DemoConsumer.class);
    }
}
