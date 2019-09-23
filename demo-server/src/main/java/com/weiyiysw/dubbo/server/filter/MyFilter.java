package com.weiyiysw.dubbo.server.filter;

import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yishiwei
 * @date 2019/9/23
 */
public class MyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String token = invocation.getAttachment("token");
        // before invoker, do check token failed return null
        LOGGER.info("token : {}", token);

        Result result = invoker.invoke(invocation);

        // after invoker, do something
        LOGGER.info("after invoker!");
        return result;
    }
}
