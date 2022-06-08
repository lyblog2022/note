package com.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 06 - 20:16
 * @Description: com.server.controller
 * @Version: 1.0
 */
@RestController
public class ServerController {

    @RequestMapping("/demo")
    public String demo(String param) {
        return "param:"+param;
    }

}
