package com.service.Impl;

import com.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 11 - 21:07
 * @Description: com.service.Impl
 * @Version: 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Reference
    private com.dubbo.service.DemoService demoService;

    @Override
    public String demo() {
        return demoService.demo("张三");
    }


}
