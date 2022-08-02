package com.fastdfs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: ly
 * @create: 2022-08-02 15:15
 * @version: 1.0
 **/
@Controller
public class PageController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/{path}")
    public String jump(String path) {
        return path;
    }

}
