package com.dubbo.service.Impl;

import com.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 11 - 21:01
 * @Description: com.dubbo.service.Impl
 * @Version: 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String demo(String param) {
        System.out.println("demo 已执行");
        return param+"xxxxxxxxxxx";
    }
}
