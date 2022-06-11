package com.controller;

import com.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 11 - 21:11
 * @Description: com.controller
 * @Version: 1.0
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo")
    public String demo() {
        return demoService.demo();
    }

}
